package contest.WeeklyContest99;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class GroupsofSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {
        List<Map<Character, Integer>[]> list = new ArrayList<>();

        for (String a : A) {
            Map<Character, Integer> evenMap = new HashMap<>();
            Map<Character, Integer> oddMap = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {

                if (i % 2 == 0) {
                    int n = evenMap.getOrDefault(a.charAt(i), 0);
                    evenMap.put(a.charAt(i), n + 1);
                } else {
                    int n = oddMap.getOrDefault(a.charAt(i), 0);
                    oddMap.put(a.charAt(i), n + 1);
                }
            }
            boolean contain = false;

            for (int i = 0; i < list.size(); i++) {
                //evenMap check
                boolean evenContain = true;
                for (char k : list.get(i)[0].keySet()) {
                    if (!evenMap.containsKey(k) || evenMap.get(k) != list.get(i)[0].get(k)) {
                        evenContain = false;
                        break;
                    }
                }
                boolean oddContain = true;
                //oddMap check
                for (char k : list.get(i)[1].keySet()) {
                    if (!oddMap.containsKey(k) || oddMap.get(k) != list.get(i)[1].get(k)) {
                        oddContain = false;
                        break;
                    }
                }
                if (evenContain && oddContain) {
                    contain = true;
                    break;
                }
            }
            if (!contain) {
                list.add(new Map[]{evenMap, oddMap});
            }

        }
        return list.size();
    }

    public int numSpecialEquivGroups2(String[] A) {
        Set<String> set = new HashSet<>();
        for (String S : A) {
            int[] appear = new int[52];
            for (int i = 0; i < S.length(); i++) {
                appear[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            set.add(Arrays.toString(appear));
        }
        return set.size();
    }

    @Test
    public void test() {
        assertEquals(3, numSpecialEquivGroups(new String[]{"couxuxaubw", "zsptcwcghr", "kkntvvhbcc", "nkhtcvvckb", "crcwhspgzt"}));
        assertEquals(3, numSpecialEquivGroups2(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}));
    }
}
