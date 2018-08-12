package contest.WeeklyContest97;

import java.util.*;


public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Set<String> uncommon= new HashSet<>();
        Set<String> common=new HashSet<>();
        for (String S:A.split(" ")){
            if(uncommon.contains(S) ||common.contains(S)){
                uncommon.remove(S);
                common.add(S);
            }
            else uncommon.add(S);
        }
        for (String S:B.split(" ")){
            if(uncommon.contains(S) ||common.contains(S)){
                uncommon.remove(S);
                common.add(S);
            }
            else uncommon.add(S);
        }
        String[] ret=new String[uncommon.size()];
        int i=0;
        for (String s:uncommon)ret[i++]=s;
        return ret;
    }
}
