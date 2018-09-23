package contest.WeeklyContest103;

import java.util.Arrays;

public class OnlineElection {
    class TopVotedCandidate {
        private int[] leader;
        private int[] times;
        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            this.leader=new int[times.length];
            int[] appear = new int[5000];
            int maxIdx = 0;
            for (int i = 0; i < persons.length; i++) {
                appear[persons[i]]++;
                maxIdx = appear[maxIdx] <= appear[persons[i]] ? persons[i] : maxIdx;
                leader[i] = maxIdx;
            }
        }

        public int q(int t) {
            int idx = Arrays.binarySearch(times, t);
            idx = idx < 0 ? -idx - 2 : idx;
            return leader[idx];
        }
    }
}
