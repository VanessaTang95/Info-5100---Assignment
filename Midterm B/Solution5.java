package problem;

import java.util.ArrayList;
import java.util.Arrays;

class Cell{
	int x,y;
	Cell(int x,int y){
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return "["+this.x+", "+this.y+"]";
	}
}


public class Solution5 {
	public static ArrayList<Cell> findPath(int[][] maze){
		ArrayList<Cell> res=new ArrayList<>();
		if(!solvemaze(maze,0,0,res)) {
			return null;
		}
		return res;
		
	}

	private static boolean solvemaze(int[][] maze, int i, int j, ArrayList<Cell> res) {
		if(i==maze.length-1 && j==maze[0].length-1) {
			res.add(new Cell(i,j));
			return true;
		}
		if(safe(maze,i,j)) {
			res.add(new Cell(i,j));
			if(solvemaze(maze,i+1,j,res)) {
				return true;
			}
			if(solvemaze(maze,i,j+1,res)) {
				return true;
			}
		}
		return false;
	}

	private static boolean safe(int[][] maze, int i, int j) {
		
		return (i>=0 &&i<maze.length && j>=0 && j<maze[0].length && maze[i][j]==1);
	}
	
	public static void main(String[] args) {
		int maze[][]= {
				{1,0,0,0},
				{1,1,1,1},
				{0,1,0,0},
				{1,1,1,1}
		};
		System.out.println("Result is:");
		ArrayList<Cell> ans=findPath(maze);
		System.out.println(ans);
	}
}
