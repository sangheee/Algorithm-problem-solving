import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LargestSumofAverages {
	public double largestSumOfAverages(int[] A, int K) {
		int n=A.length;
		double[][] cache=new double[K+1][n];
		
		int sum=0;
		for(int i=n-1,j=1;i>=0;i--,j++) {
			sum+=A[i];
			cache[1][i]=(double)(sum)/j;
		}
		return dfs(A,K,cache,0);
	}

	private double dfs(int[] A, int K,double[][] cache, int idx) {
		if(K==0)return 0;
		if(cache[K][idx]>0) return cache[K][idx];
		
		int sum=0;
		double avgSum=0;
		for(int i=idx,j=1; i<A.length-K+1;i++,j++) {
			sum+=A[i];
			avgSum=Math.max(avgSum, (double)sum/j+dfs(A,K-1,cache,i+1));
		}
		return cache[K][idx]=avgSum;
	}

	
	@Test
	public void test() {
		assertEquals(largestSumOfAverages(new int[] {4,1,7,5,6,2,3},4),18.16667,0.001);
		assertEquals(largestSumOfAverages(new int[] {192,2926,1373,182},3),3895.5,0.00000001);
		assertEquals(largestSumOfAverages(new int[] {1,1,1},3),3,0.00000001);
		assertEquals(largestSumOfAverages(new int[] {9,1,2,3,9},3),20,0.00000001);
		
		int[] test=new int[100];
		for(int i=0; i<100;i++) {
			test[i]=(int) (Math.random()*10000);
		}
		long start=System.currentTimeMillis();
		System.out.println(largestSumOfAverages(test,27));
		System.out.println(System.currentTimeMillis()-start);
		
		
	}
}
