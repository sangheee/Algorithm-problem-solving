import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

public class LengthofLongestFibonacciSubsequence {
	public int lenLongestFibSubseq(int[] A) {
		Set<Integer> seq=new HashSet<>();
		for(int n:A)seq.add(n);
		List<int[]> longestFibonacci=new ArrayList<>();
		for(int i=0; i<A.length;i++) {
			for(int j=i+1;j<A.length;j++) {
				int val=A[i]+A[j];
				if(seq.contains(val))
					longestFibonacci.add(new int[] {A[j],val});
				if(val>=A[A.length-1])break;
			}
		}
		if(longestFibonacci.isEmpty())return 0;
		int maxlen=3;
		while(true) {
			List<int[]> subFibonacci=new ArrayList<>();
			for(int[] fibo:longestFibonacci) {
				int val=fibo[0]+fibo[1];
				if(seq.contains(val)) 
					subFibonacci.add(new int[] {fibo[1],val});
			}
			if(subFibonacci.isEmpty())break;
			longestFibonacci=subFibonacci;
			maxlen++;
		}
		return maxlen;
	}
	@Test
	public void test() {
		assertEquals(5,lenLongestFibSubseq(new int[] {2,4,7,8,9,10,14,15,18,23,32,50}));
	}
	
}
