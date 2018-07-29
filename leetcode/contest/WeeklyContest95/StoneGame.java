package contest.WeeklyContest95;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StoneGame {
//    public boolean stoneGame(int[] piles) {
//        return isWinAlex(0, 0, 0, piles.length - 1, piles);
//    }
//
//    private boolean isWinAlex(int Alex, int Lee, int l, int r, int[] piles) {
//        if (l >= r) return Alex > Lee;
//        if (isWinAlex(Alex + piles[l], Lee + piles[l], l + 2, r, piles) || isWinAlex(Alex + piles[l], Lee + piles[r], l + 1, r - 1, piles))
//            return true;
//        if (isWinAlex(Alex + piles[r], Lee + piles[l], l + 1, r - 1, piles) || isWinAlex(Alex + piles[r], Lee + piles[r], l, r - 2, piles))
//            return true;
//        return false;
//    }

    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int[]dp= Arrays.copyOf(piles,n);
        for(int j=1;j<n;j++){
            for (int i=0; i<n-j;i++){
                dp[i]=Math.max(piles[i]-dp[i+1],piles[i+j]-dp[i]);
            }
        }
        return dp[0]>0;
    }

    @Test
    public void test() {
        assertTrue(stoneGame(new int[]{3, 2, 10, 4}));
        assertTrue(stoneGame(new int[]{5, 3, 4, 5}));
        assertFalse(stoneGame(new int[]{1, 100, 1}));
    }
}
