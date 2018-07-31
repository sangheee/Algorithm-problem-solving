package contest.WeeklyContest95;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ProfitableSchema {
    private static final int mod = (int) (Math.pow(10,9)+7);

    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] profitGroup=new int[profit.length][2];
        for (int i=0;i<profit.length;i++){
            profitGroup[i][0]=profit[i];
            profitGroup[i][1]=group[i];
        }
        Arrays.sort(profitGroup, (o1,o2)->{return o1[0]-o2[0];});

        long sum = 0;
        long[][] cant = new long[G + 1][P];
        cant[0][0] = 1;

        long[] can = new long[G + 1];

        for (int i = profit.length - 1; i >= 0; i--) {
            for (int j = G - profitGroup[i][1]; j >= 0; j--) {
                if (can[j] > 0) {
                    sum += can[j];
                    sum %= mod;
                    can[j + profitGroup[i][1]]+=can[j];
                    can[j + profitGroup[i][1]]%=mod;
                }
            }
            for (int j = G - profitGroup[i][1]; j >= 0; j--) {
                for (int k = P-1; k >=0; k--) {
                    if (k+profitGroup[i][0]>=P && cant[j][k] > 0) {
                        sum+=cant[j][k];
                        sum%=mod;
                        can[j+profitGroup[i][1]]+=cant[j][k];
                        can[j+profitGroup[i][1]]%=mod;
                    } else if(k+profitGroup[i][0]<P){
                        cant[j+profitGroup[i][1]][k+profitGroup[i][0]]+=cant[j][k];
                        cant[j+profitGroup[i][1]][k+profitGroup[i][0]]%=mod;
                    }
                }
            }
        }

        return (int) sum;
    }


    @Test
    public void test() {
        assertEquals(653387801,profitableSchemes(100,100,
                new int[]{24,23,7,4,26,3,7,11,1,7,1,3,5,26,26,1,13,12,2,1,7,4,1,27,13,16,26,18,6,1,1,7,16,1,6,2,5,9,19,28,1,23,2,1,3,4,4,3,22,1,1,3,5,34,2,1,22,16,8,5,3,21,1,8,14,2,1,3,8,12,40,6,4,2,2,14,1,11,9,1,7,1,1,1,6,6,4,1,1,7,8,10,20,2,14,31,1,13,1,9},
                new int[]{5,2,38,25,4,17,5,1,4,0,0,8,13,0,20,0,28,1,22,7,10,32,6,37,0,11,6,11,23,20,13,13,6,2,36,1,0,9,4,5,6,14,20,1,13,6,33,0,22,1,17,12,10,1,19,13,8,1,0,17,20,9,8,6,2,2,1,4,22,11,3,2,6,0,40,0,0,7,1,0,25,5,12,7,19,4,12,7,4,4,1,15,33,14,2,1,1,61,4,5}));
        assertEquals(28,profitableSchemes(10,10,new int[]{9,11,6,1,6,3,1,9,3,10},new int[]{2,5,3,0,10,6,11,9,9,6}));
        assertEquals(7,profitableSchemes(10,5,new int[]{2,3,5},new int[]{6,7,8}));
        assertEquals(33940,profitableSchemes(10,1,new int[]{6,3,6,1,10,1,11,6,8,8,11,10,9,10,4,7,9,6,7,9,10,8,4,6,7,7,9,4,4,4,8,6,7,10,5,2,1,6,11,3,8,9,3,2,8,4,7,10,9,5,3,6,10,4,5,4,10,3,8,6,11,10,6,9,8,11,3,7,2,7,7,9,7,10,1,3,3,9,6,3,11,3,5,10,9,4,10,6,4,10,9,2,1,1,9,10,5,10,7,6},new int[]{2,0,0,1,2,0,0,1,2,1,1,2,2,2,1,0,2,2,1,1,0,0,2,2,0,2,2,2,0,1,2,1,1,0,0,2,2,2,2,0,0,0,0,2,0,0,1,0,2,1,0,2,0,0,1,2,2,1,1,2,1,1,2,0,2,0,0,1,1,1,0,1,1,2,2,1,0,0,1,0,2,2,1,2,2,0,0,2,0,2,2,1,0,2,0,1,0,1,0,2}));
        assertEquals(31, profitableSchemes(1, 1, new int[]{2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 2, 1, 2, 2, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 1, 0, 1, 2, 0, 0, 2, 2, 1, 1, 1, 2, 0, 1, 1, 2, 0, 2, 2, 1, 0, 1, 0, 1, 2, 2, 1, 1, 2, 0, 2, 1, 1, 1, 1, 1, 2, 0, 1, 0, 2, 2, 2, 2, 2, 0, 1, 1, 2, 1, 0, 1, 0, 0, 2, 1, 0, 2, 0, 2, 1, 1, 1, 0, 1, 0, 1, 2, 2, 0, 1, 1, 2, 2, 0, 1, 0, 0, 1, 1, 2, 2, 2, 2, 1, 0, 0, 1, 2, 1, 1, 1, 1, 0, 1}));
        assertEquals(2, profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));
    }
}
