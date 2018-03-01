/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order. (Score 2)

For example, Given the following matrix: 
{{1,2,3},
{4,5,6},
{7,8,9}}
You should return {1,2,3,6,9,8,7,4,5}.

public List<Integer> spiralOrder(int[][] matrix) {
         //write your code here
}
*/
package assignment6;

import java.util.ArrayList;
import java.util.List;

public class Extra {

	public static List<Integer> spiralOrder(int[][] matrix){
		List result=new ArrayList();
		//in case the matrix is null 
		if (matrix==null||matrix.length==0){
			return result;
		}
		
		int start_row=0;
		int end_row=matrix.length-1;
		int start_col=0;
		int end_col=matrix[0].length-1;
		while(start_row<=end_row && start_col<=end_col) {
			//going right
			for(int r=start_col;r<=end_col;r++) {
				result.add(matrix[start_row][r]);
			}
			start_row++;
			
			//going down
				for(int d=start_row;d<=end_row;d++) {
					result.add(matrix[d][end_col]);
				}
			end_col--;
			
			//if the matrix only have one row,it would not have the case down or up
			// going left
			if(start_col<=end_col) {
				for(int l=end_col;l>=start_col;l--) {
					result.add(matrix[end_row][l]);
				}
			}
			end_row--;
			
			//going up
			if(start_row<=end_row) {
				for(int u=end_row;u>=start_row;u--) {
					result.add(matrix[u][start_col]);
				}
			}
			start_col++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		//int matrix[][]= {{1,2,3},{4,5,6},{7,8,9}};
		int matrix[][]= {{2,3}};
		List spiral=new ArrayList();
		spiral=spiralOrder(matrix);
		System.out.println(spiral);
		
	}

}
