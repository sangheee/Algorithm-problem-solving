import java.util.*;

public class FindAllAnagramsString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result=new ArrayList<>();
		int[] charset=new int[26];
		char[]ss=s.toCharArray();
		char[]pp=p.toCharArray();
		
		int cnt=pp.length;
		for(char ppp:pp)charset[ppp-97]++;
		for(int l=0,r=0;r<ss.length;r++){
			if(charset[ss[r]-97]-->=1)cnt--;
			
			if(r-l==pp.length && charset[ss[l++]-97]++>=0)cnt++;
            
            if(cnt==0)result.add(l);
		}
		return result;
	}
}
