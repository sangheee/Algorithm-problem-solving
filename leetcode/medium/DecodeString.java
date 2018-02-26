import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecodeString {
	public String decodeString(String s) {
		StringBuilder res=new StringBuilder();
		String number="";
		for(int i=0; i<s.length();i++) {
			char c=s.charAt(i);
			if(c>='0' &&c<='9')number+=c;
			else if(c=='[') {
				i+=appendString(s.substring(i+1),Integer.valueOf(number),res);
				number="";
			}else
				res.append(c);
		}
		return res.toString();
	}
	
	public int appendString(String s,int n,StringBuilder res) {
		StringBuilder tmp=new StringBuilder();
		String number="";
		int i=0;
		for(;i<s.length();i++) {
			char c=s.charAt(i);
			if(c>='0' &&c<='9')number+=c;
			else if(c=='[') {
				i+=appendString(s.substring(i+1),Integer.valueOf(number),tmp);
				number="";
			}else if(c==']') {
				break;
			}else
				tmp.append(c);
		}
		for(int j=0;j<n;j++)res.append(tmp);
		return i+1;
	}

	@Test
	public void test() {
		assertEquals(decodeString("3[a]2[bc]"), "aaabcbc");
		assertEquals(decodeString("3[a2[c]]"), "accaccacc");
		assertEquals(decodeString("2[abc]3[cd]ef"), "abcabccdcdcdef");

	}
}
