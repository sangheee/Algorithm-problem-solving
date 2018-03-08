import java.util.*;

import org.junit.Test;

public class RotateImage {
	public void rotate(int[][] matrix) {
		/*LinkedList<Integer> tmpList=new LinkedList<>();
		int n=matrix.length;
		for(int i=n-1; i>=0;i--) {
			for(int idx=i,k=0; idx>=0; idx--,k+=n-i) {
				tmpList.add(k, matrix[n-idx-1][i]);
			}
			int j=0;
			for(;j<i;j++){
				matrix[j][i]=matrix[n-i-1][j];
			}
			for(;j<n;j++) {
				matrix[j][i]=tmpList.pollFirst();
			}
		}*/
		//swap 2
		int n=matrix.length;
		for(int i=0;i<n;i++) {
			for(int j=i; j<n;j++) {
				int tmp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=tmp;
			}
		}
		int l=0,r=n-1;
		while(l<r) {
			for(int i=0; i<n;i++) {
				int tmp=matrix[i][l];
				matrix[i][l]=matrix[i][r];
				matrix[i][r]=tmp;
			}
			l++;r--;
		}
	}
	@Test
	public void test() {
		int[][] matrix=new int[3][3];
		matrix[0]= new int[]{1,2,3};
		matrix[1]= new int[]{4,5,6};
		matrix[2]= new int[]{7,8,9};
		rotate(matrix);
		
	}
}
