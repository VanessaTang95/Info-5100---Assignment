/*
Given input that represent as a maze, write a program that finds a valid
solution to the maze by outputting directional instructions from the start
maker to the finish maker.(4 scores)
Maze character:
S - start F-finish +-open space @barrier
Output should be a string of commands to move through the maze from start
to finish.
D = down, R = right, L = left, U = up;
Sample input 1: Sample Onput 1:
S@@@ DRRRD
++++
@@@F
Sample input 2: Sample Onput 2:
@S@@@@@ DRRRDDDDLLLD
@+++++@
@@+@+@@
@++@++@
@@@@+@@
@+++++@
@F@@@@@
*/
package assignment;

public class MazeSolution {
	 //static char arr[][]= {{'S','@','@','@'},{'+','+','+','+'},{'@','@','@','F'}};
	static char arr[][]= {{'@','S','@','@','@','@','@'},{'@','+','+','+','+','+','@'},{'@','@','+','@','+','@','@'},
					{'@','+','+','@','+','+','@'},{'@','@','@','@','+','@','@'},{'@','+','+','+','+','+','@'},{'@','F','@','@','@','@','@'}};
			
	
	
	public static void main(String args[]) {
		//getIndex of start and end
		int s_row=getIndex(arr,'S')[0];
		int s_col=getIndex(arr,'S')[1];
		
		int f_row=getIndex(arr,'F')[0];
		int f_col=getIndex(arr,'F')[1];

		if(solve(s_row,s_col)) { 
	 	findSolution(s_row,s_col,f_row,f_col);
		}
	}

	

	private static void findSolution(int s_row, int s_col, int f_row, int f_col ) {
		
		int row=s_row;
		int col=s_col;
		
	
		if(((arr[row+1][col]=='-')||(arr[row+1][col]=='F'))&&((row+1)<=arr.length-1)) {//turn down
			System.out.print("D");
			arr[row][col]='@';
			if((row+1==f_row)&&(col==f_col)){
				return;
			}
			findSolution((row+1),col,f_row,f_col);
		}else if(((arr[row-1][col]=='-')||(arr[row+1][col]=='F'))&&((row-1)>=0)) {//turn up
			System.out.print("U");
			arr[row][col]='@';
			if((row-1==f_row)&&(col==f_col)){
				return;
			}
			findSolution((row-1),col,f_row,f_col);
		}else if(((arr[row][col+1]=='-')||(arr[row+1][col]=='F'))&&((col+1)<=arr[0].length-1)) {//turn right
			System.out.print("R");
			arr[row][col]='@';
			if((row==f_row)&&(col+1==f_col)){
				return;
			}
			findSolution(row,(col+1),f_row,f_col);
		}else if(((arr[row][col-1]=='-')||(arr[row+1][col]=='F'))&&((col-1)>=0)) {//turn left
			System.out.print("L");
			arr[row][col]='@';
			if((row==f_row)&&(col-1==f_col)){//find F
				return;
			}
			findSolution(row,(col-1),f_row,f_col);
		}
	}

	//find valid path and block invalid path
	  private static boolean solve(int r, int c) {
		  	
		    // if we're at the goal then we've solved it
		    if (arr[r][c] == 'F') {
		      return true;
		    }

		    // mark the current position as on the path
		    
		    arr[r][c] = '-';

		    // try all available neighbors - if any of these return true then we're solved
		    if (available(r - 1, c) && solve(r - 1, c)) {
		      return true;
		    }
		    if (available(r + 1, c) && solve(r + 1, c)) {
		      return true;
		    }
		    if (available(r, c - 1) && solve(r, c - 1)) {
		      return true;
		    }
		    if (available(r, c + 1) && solve(r, c + 1)) {
		      return true;
		    }

		    // nothing found so remove the current position from the path and backtrack
		    arr[r][c] = '+';

		    return false;
		  }

		  // position is available if it is in the maze and either a clear space or the
		  // goal - it is not available if it is a wall or already on the current path
		  private static boolean available(int r, int c) {
		    return r >= 0 && r < arr.length
		        && c >= 0 && c < arr[r].length
		        && (arr[r][c] == '+' || arr[r][c] == 'F');
		  }

	
	private static int[] getIndex(char[][] arr, char c) {//find the position of character(in this maze, find s and f)
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==c) {
					return new int[]{i,j};
				}
			}
		}
		return null;
	}

}
