import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

public class KthSmallestElementSortedMatrix {
	/*public int kthSmallest(int[][] matrix, int k) {
		int n=matrix.length;
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o0, int[] o1) {
				return matrix[o0[0]][o0[1]]-matrix[o1[0]][o1[1]];
			}
		});
		pq.offer(new int[] {0,0});
		int idx=1;
		while(true) {
			int[] poll=pq.poll();
			if(idx++==k)return matrix[poll[0]][poll[1]];
			if(poll[0]+1<n) {
				pq.offer(new int[] {poll[0]+1,poll[1]});
			}
			if(poll[0]==0 && poll[1]+1<n) {
				pq.offer(new int[] {poll[0],poll[1]+1});
			}
		}
	}
	*/

	int kthSmallest(int[][] matrix, int k) {
		int n=matrix.length;
		int lo=matrix[0][0],hi=matrix[n-1][n-1];
		while(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			int cnt=getLessEqual(matrix,mid);
			if(cnt<k) {
				lo=mid+1;
			}else {
				hi=mid-1;
			}
		}
		return lo;
	}
	
	private int getLessEqual(int[][] matrix, int val) {
		int n=matrix.length;
		int res=0;
		for(int i=0,j=n-1; i<n && j>=0;) {
			if(matrix[j][i]>val) {
				j--;
			}else {
				res+=j+1;
				i++;
			}
		}
		
		return res;
	}

	@Test
	public void test() {
		assertEquals(kthSmallest(new int[][] {{1,3,5},{6,7,12},{11,14,14}},5),7);
		assertEquals(kthSmallest(new int[][] {{1,5,9},{10,11,13},{12,13,15}},4),10);
		assertEquals(kthSmallest(new int[][] {{1,5,9},{10,11,13},{12,13,15}},8),13);
	}
}
