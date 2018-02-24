import java.util.*;

import org.junit.Test;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		List<Set<Character>> strSetList = new ArrayList<>();

		for (String str : strs) {
			boolean isAppear = false;
			for (int j = 0; j < strSetList.size(); j++) {
				
				if (strSetList.get(j).size() != str.length())
					continue;
				
				isAppear = true;
				for (int i = 0; i < str.length(); i++) {
					if (!strSetList.get(j).contains(str.charAt(i))) {
						isAppear = false;
						break;
					}
				}
				
				if(isAppear) {
					res.get(j).add(str);
					break;
				}
			}
			if(isAppear)continue;
			res.add(new ArrayList<>());
			res.get(res.size() - 1).add(str);
			Set<Character> strSet = new HashSet<>();
			for (char c : str.toCharArray()) {
				strSet.add(c);
			}
			strSetList.add(strSet);

		}
		return res;
	}

	@Test
	public void test() {
		groupAnagrams(new String[] {"","b"});
		groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
	}
}
