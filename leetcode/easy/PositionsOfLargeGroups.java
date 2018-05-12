import java.util.*;
import org.junit.Test;

public class PositionsOfLargeGroups {
	public List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> ret=new ArrayList<>();
		S+="@";
		int p=0;
		for(int i=1; i<S.length();i++) {
			if(S.charAt(p)!=S.charAt(i)) {
				if(i-p>2)ret.add(Arrays.asList(p,i-1));
				p=i;
			}
		}
		return ret;
	}
	@Test
	public void test() {
		largeGroupPositions("abbxxxxzzy");
	}
}
