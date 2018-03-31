import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class PerfectSquares {

	public int numSquares(int n) {
        int[]arr=new int[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0]=0;
        for(int i=1; i<=n;i++) {
        		for(int j=(int) Math.sqrt(i); j>0;j--) {
        			arr[i]=Math.min(arr[i], arr[i-(j*j)]+1);
        		}
        }
        return arr[n];
    }
	
	@Test
	public void test() {
		assertEquals(numSquares(12),3);
	}
}
