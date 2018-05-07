import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class BinaryTreesWithFactors {
	private int mod=(int) (Math.pow(10, 9)+7);
	public int numFactoredBinaryTrees(int[] A) {
		Set<Integer>number=new TreeSet<>();
		for(int a:A)number.add(a);
		
		Map<Integer,Long> cache=new HashMap<>();
		
		int ret=0;
		for(int a:number) {
			long tmp=1;
			for(int n:number) {
				if(n>=a)break;
				if(a%n==0 && cache.containsKey(a/n)) {
					tmp+=cache.get(n)*cache.get(a/n);
				}
			}
			cache.put(a, tmp);
			ret+=(tmp%mod);
			ret%=mod;
		}
		return ret;
	}
	
	@Test
	public void test() {
		assertEquals(7,numFactoredBinaryTrees(new int[] {2,4,5,10}));
		assertEquals(12,numFactoredBinaryTrees(new int[] {2,4,5,8,10}));
	}
}
