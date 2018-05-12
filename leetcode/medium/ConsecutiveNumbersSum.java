import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConsecutiveNumbersSum {
	public int consecutiveNumbersSum(int N) {
		int ret=1;
		for(int i=2;i<=Math.sqrt(2*N);i++) {
			if((N-(i*(i+1))/2)%i==0)ret++;
		}
		return ret;
	}
	@Test
	public void test() {
		assertEquals(consecutiveNumbersSum(1000000000),10);
		assertEquals(consecutiveNumbersSum(15),4);
	}
}
