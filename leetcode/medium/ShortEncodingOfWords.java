import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import java.util.*;

public class ShortEncodingOfWords {
	/*
	public int minimumLengthEncoding(String[] words) {
		PriorityQueue<String> pq=new PriorityQueue<>((o1,o2)-> {return o2.length()-o1.length();});
		for(String word:words)pq.add(word);
		StringBuilder builder=new StringBuilder();
		while(!pq.isEmpty()) {
			String s=pq.poll();
			if(!builder.toString().contains(s+"#")){
				builder.append(s+"#");
			}
		}
		return builder.length();
	}
	*/

	public int minimumLengthEncoding(String[] words) {
		Set<String> wordSet=new HashSet<>(Arrays.asList(words));
		for(String word:words) {
			for(int i=1;i<word.length();i++) {
				wordSet.remove(word.substring(i));
			}
		}
		int ret=0;
		for(String word:wordSet) {
			ret+=word.length()+1;
		}
		return ret;
	}
	
	@Test
	public void test() {
		assertEquals(10, minimumLengthEncoding(new String[]{"time","me","bell"}));
	}

}
