import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomSortString {
	public String customSortString(String S, String T) {
		StringBuilder res=new StringBuilder();
		char[]t=T.toCharArray();
		int[] tappear=new int[26];
		for(char tt:t)tappear[tt-97]++;
		
		char[]s=S.toCharArray();
		for(char ss:s) {
			while(tappear[ss-97]>0) {
				res.append(ss);
				tappear[ss-97]--;
			}
		}
		for(int i=0; i<26;i++) {
			char c=(char) (i+97);
			while(tappear[i]>0) {
				res.append(c);
				tappear[i]--;
			}
		}
		return res.toString();
	}
	@Test
	public void test() {
		assertEquals(customSortString("cba","abcd"),"cbad");
	}
	
}
