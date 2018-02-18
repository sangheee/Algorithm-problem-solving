import java.util.*;

public class LetterCasePermutation {
	public List<String> letterCasePermutation(String S) {
		List<String> ret=new ArrayList<>();
		ret.add(new String(S));
	
		for(int i=0; i<S.length();i++) {
			if(S.charAt(i)>=65) {
				getLetterPermutation(ret,S,i);
				break;
			}
		}
		return ret;
	}

	private void getLetterPermutation(List<String> ret, String S, int idx) {
		int i=idx+1;
		char[]s=S.toCharArray();
		for(;i<s.length;i++) {
			if(s[i]>=65 &&s[i]<=122) break;
		}
		if(s[idx]>=65 && s[idx]<=90)s[idx]+=32;
		else if(s[idx]>=97)s[idx]-=32;
		ret.add(new String(s));
		
		if(i>=s.length) return;
		
		getLetterPermutation(ret,S,i);
		getLetterPermutation(ret,new String(s),i);
		
	}
}
