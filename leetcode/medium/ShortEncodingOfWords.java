import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import java.util.*;

public class ShortEncodingOfWords {
	public int minimumLengthEncoding(String[] words) {
		PriorityQueue<String> pq=new PriorityQueue<String>((o1,o2)-> {return o2.length()-o1.length();});
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
	@Test
	public void test() {
		assertEquals(10, minimumLengthEncoding(new String[]{"time","me","bell"}));
	}
}
