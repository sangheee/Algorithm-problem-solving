import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecodeWays {
	public int numDecodings(String s) {
		int n=s.length();
		if(n==0)
			return 0;
		else if(n==1) 
			return s.charAt(0)=='0'?0:1; 
		
		int[] dp=new int[n+1];
		if(s.charAt(0)=='0')return 0;
		else if(s.length()<2) return 1;
		dp[0]=1;
		dp[1]=1;

		for(int i=1,j=2; i<n;i++,j++) {
			if(s.charAt(i)!='0') dp[j]+=dp[j-1];
			else if(s.charAt(i-1)=='0')return 0;

			int tmp=Integer.parseInt(s.substring(i-1, i+1));
			if(tmp>=10 && tmp<=26)dp[j]+=dp[j-2];
		}
		return dp[n];
	}
	@Test
	public void test() {
		assertEquals(numDecodings("226"),3);
		assertEquals(numDecodings("12"),2);
		assertEquals(numDecodings("27"),1);
		assertEquals(numDecodings("9"),1);
		assertEquals(numDecodings("1001"),0);
		assertEquals(numDecodings("110"),1);
		assertEquals(numDecodings("01"),0);
		assertEquals(numDecodings("301"),0);
		
	}
}
