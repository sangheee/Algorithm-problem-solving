package contest.WeeklyContest96;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ret = 0;
        int l = 0, r = people.length - 1;
        while (l <= r) {
            if (people[l] + people[r] <= limit) l++;
            r--;
            ret++;
        }
        return ret;
    }

    @Test
    public void test() {
        assertEquals(3, numRescueBoats(new int[]{3, 2, 2, 3, 2}, 6));
        assertEquals(2, numRescueBoats(new int[]{5, 1, 4, 2}, 6));
        assertEquals(1, numRescueBoats(new int[]{1, 2}, 3));
        assertEquals(3, numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        assertEquals(4, numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }
}
