
public class CountBinarySubstrings {
	public int countBinarySubstrings(String s) {
		int cur=1,pre=0;
		int ret=0;
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)!=s.charAt(i-1)) {
				pre=cur;
				cur=0;
			}
			cur++;
			ret+=cur<=pre?1:0;
		}
		return ret;
	}
}
