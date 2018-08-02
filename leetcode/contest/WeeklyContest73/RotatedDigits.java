import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RotatedDigits {

	public int rotatedDigits(int N) {
		int res=0;
		for(int i=1;i<=N;i++) {
			boolean isGood=false;
			char[]c=String.valueOf(i).toCharArray();
			for(int j=0;j<c.length;j++) {
				if(c[j]=='3'||c[j]=='4'||c[j]=='7') {
					isGood=false;
					break;
				}
				if(c[j]=='2'||c[j]=='5'||c[j]=='6'||c[j]=='9')
					isGood=true;
			}
			
			if(isGood)res++;
		}
		return res;
	}
	@Test
	public void test() {
		//assertEquals(rotatedDigits(10),4);
		//assertEquals(rotatedDigits(15),6);
		assertEquals(rotatedDigits(857),247);
	}
}
