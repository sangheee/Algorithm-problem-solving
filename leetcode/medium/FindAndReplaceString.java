import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class FindAndReplaceString {
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		StringBuilder ret=new StringBuilder();
		Map<Integer,Integer> isContain=new HashMap<>();
		for(int i=0; i<indexes.length;i++) {
			if(S.startsWith(sources[i], indexes[i])){
				isContain.put(indexes[i], i);
			}
		}
		for(int i=0; i<S.length();) {
			if(isContain.containsKey(i)) {
				int v=isContain.get(i);
				ret.append(targets[v]);
				i+=sources[v].length();
			}else {
				ret.append(S.charAt(i++));
			}
		}
		return ret.toString();
	}
	@Test
	public void test() {
		assertEquals("vbfrssozp",findReplaceString("vmokgggqzp",new int[] {3,5,1},new String[] {"kg","ggq","mo"},new String[] {"s","so","bfr"}));
		assertEquals("eeebffff",findReplaceString("abcd",new int[] {0,2},new String[] {"a","cd"},new String[] {"eee","ffff"}));
		assertEquals("eeecd",findReplaceString("abcd",new int[] {0,2},new String[] {"ab","ec"},new String[] {"eee","ffff"}));
	}
}
