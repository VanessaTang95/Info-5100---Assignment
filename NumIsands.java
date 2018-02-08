// well done


package assignment;

public class NumIsands {
	public static void main(String[] args) {
		int[][] target= {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
		PrintArray(target);
		int num=numIsands(target);
		System.out.println("Number of Island:"+num);
	}

	private static int numIsands(int[][] target) {
		// TODO Auto-generated method stub
		int row=target.length;
		int col=target[0].length;
		if(target==null||row==0||col==0) {
			return 0;
		}else {
			int count=0;
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					if(target[i][j]==1) {
						count++;
						union(target,row,col,i,j);
					}
				}
			}
		return count;
		}
			
	}

	private static void union(int[][] target, int row, int col, int i, int j) {
		// TODO Auto-generated method stub
		if(i<0||i>row||j<0||j>col||target[i][j]!=1) {
			return;
		}
		target[i][j]=-1;
		union(target,row,col,i-1,j);
		union(target,row,col,i+1,j);
		union(target,row,col,i,j-1);
		union(target,row,col,i,j+1);
	}

	private static void PrintArray(int[][] target) {
		// TODO Auto-generated method stub
		for(int i=0;i<target.length;i++) {
			for(int j=0;j<target[0].length;j++) {
				System.out.print(target[i][j]+" ");
			}
			System.out.println();
		}
	}
}
