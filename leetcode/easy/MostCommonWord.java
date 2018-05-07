import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		paragraph=paragraph.toLowerCase();

		Map<String,Integer> map=new HashMap<>();
		Set<String> bannedSet=new HashSet<>(Arrays.asList(banned));
		
		String ret="";
		int retCnt=0;
		for(String word:paragraph.split("[ !?',;.]+")) {
			if(!bannedSet.contains(word)) {
				int n=map.getOrDefault(word,0)+1;
				map.put(word, n);
				if(n>retCnt) {
					retCnt=n;
					ret=word;
				}
			}
		}
		return ret;
	}
	@Test
	public void test() {
		assertEquals("ball",mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[] {"hit"}));
	}
}
