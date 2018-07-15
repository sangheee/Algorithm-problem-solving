import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;

public class ReorderedPowerof2 {
	private static Set<Integer> power2 = new HashSet<>();

	public boolean reorderedPowerOf2(int N) {
		for (int i = 1; i < Math.pow(2, 30); i *= 2) {
			power2.add(i);
		}
		String s = String.valueOf(N);
		boolean[] visited = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) > '0') {
				visited[i] = true;
				if (permutation(visited, s, s.substring(i, i + 1)))
					return true;
				visited[i] = false;
			}
		}
		return false;
	}

	private boolean permutation(boolean[] visited, String s, String cur) {
		boolean flag = false;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				flag = true;
				visited[i] = true;
				if (permutation(visited, s, cur + s.substring(i, i + 1)))
					return true;
				visited[i] = false;
			}
		}
		if (!flag && power2.contains(Integer.valueOf(cur)))
			return true;
		return false;
	}

	@Test
	public void test() {
		assertTrue(reorderedPowerOf2(1024));
		assertTrue(reorderedPowerOf2(46));
		assertTrue(reorderedPowerOf2(1));
		assertFalse(reorderedPowerOf2(10));
		assertTrue(reorderedPowerOf2(16));
	}
}
