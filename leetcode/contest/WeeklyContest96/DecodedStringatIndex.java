package contest.WeeklyContest96;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodedStringatIndex {
    public String decodeAtIndex(String S, int K) {
        int n = S.length();
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            if (c >= '2' && c <= '9') {
                dp[i + 1] = dp[i] * (c - '0');
            } else {
                dp[i + 1] = dp[i] + 1;
            }
        }
        K--;
        for (int i = n - 1; i >= 0; i--) {
            K %= dp[i + 1];
            if (K + 1 == dp[i + 1] && !(S.charAt(i) >= '2' && S.charAt(i) <= '9'))
                return String.valueOf(S.charAt(i));
        }
        return null;
    }

    @Test
    public void test() {
        assertEquals("l", decodeAtIndex("yyuele72uthzyoeut7oyku2yqmghy5luy9qguc28ukav7an6a2bvizhph35t86qicv4gyeo6av7gerovv5lnw47954bsv2xruaej", 123365626));
        assertEquals("c",decodeAtIndex("abc",3));
        assertEquals("c", decodeAtIndex("a2b3c4d5e6f7g8h9", 10));
        assertEquals("h",decodeAtIndex("ha22",5));
        assertEquals("o", decodeAtIndex("leet2code3", 10));
    }
}
