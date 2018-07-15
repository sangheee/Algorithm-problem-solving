import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryGap {
	public int binaryGap(int N) {
		String s=Integer.toBinaryString(N);
		int maxGap=0;
		int curGap=0;
		for(int i=1; i<s.length();i++) {
			curGap++;
			if(s.charAt(i)=='1'){maxGap=Math.max(maxGap, curGap);curGap=0;}
		}
		return maxGap;
	}
	@Test
	public void test() {
		assertEquals(binaryGap(22),2);
		assertEquals(binaryGap(6),1);
		assertEquals(binaryGap(8),0);
		assertEquals(binaryGap(5),2);
	}
}
