package contest.WeeklyContest97;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(N==1)return true;
        Map<Integer, Set<Integer>> dislikeMap = new HashMap<>();

        Set<Integer> g1 = new HashSet<>();
        Set<Integer> g2 = new HashSet<>();
        g1.add(dislikes[0][0]);
        g2.add(dislikes[0][1]);

        for (int[] dislike : dislikes) {
            int d1 = dislike[0], d2 = dislike[1];
            if ((g1.contains(d1) && g1.contains(d2)) || (g2.contains(d1) && g2.contains(d2)))
                return false;

            if ((!g1.contains(d1) && !g2.contains(d2)) && (!g1.contains(d2) && !g2.contains(d1))) {
                dislikeMap.putIfAbsent(d1,new HashSet<>());
                dislikeMap.putIfAbsent(d2,new HashSet<>());

                dislikeMap.get(d1).add(d2);
                dislikeMap.get(d2).add(d1);
            } else if (!(g1.contains(d1) && g2.contains(d2)) && !(g1.contains(d2) && g2.contains(d1))) {
                Set<Integer>group=g1,othergroup=g2;

                if(g2.contains(d1) || g2.contains(d2)){
                    group=g2;
                    othergroup=g1;
                }

                Queue<Integer> queue = new LinkedList<>();
                int val=(g1.contains(d1)||g2.contains(d1))?d2:d1;
                queue.add(val);

                boolean flag = true;

                while (!queue.isEmpty()) {
                    Queue<Integer> newQ = new LinkedList<>();
                    while (!queue.isEmpty()) {
                        int v = queue.poll();
                        if (flag) {
                            othergroup.add(v);
                        } else {
                            group.add(v);
                        }
                        newQ.addAll(new LinkedList<>(dislikeMap.getOrDefault(v,new HashSet<>())));
                        dislikeMap.put(v, new HashSet<>());
                    }
                    flag=!flag;
                    queue = newQ;
                }
            }
        }
        return true;
    }

//    public boolean possibleBipartition(int N, int[][] dislikes) {
//        if(N==1)return true;
//        Map<Integer, Set<Integer>> dislikeMap = new HashMap<>();
//
//        for (int[] dislike: dislikes){
//            dislikeMap.putIfAbsent(dislike[0],new HashSet<>());
//            dislikeMap.putIfAbsent(dislike[1],new HashSet<>());
//
//            dislikeMap.get(dislike[0]).add(dislike[1]);
//            dislikeMap.get(dislike[1]).add(dislike[0]);
//        }
//
//        Set<Integer>group=new HashSet<>(),othergroup=new HashSet<>();
//        group.add(dislikes[0][0]);
//        boolean flag = true;
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.addAll(dislikeMap.get(dislikes[0][0]));
//
//        while (!queue.isEmpty()) {
//            Queue<Integer> newQ = new LinkedList<>();
//            while (!queue.isEmpty()) {
//                int v = queue.poll();
//                if (flag) {
//                    if (group.contains(v))return false;
//                    othergroup.add(v);
//                }else{
//                    if (othergroup.contains(v))return false;
//                    group.add(v);
//                }
//                newQ.addAll(new LinkedList<>(dislikeMap.getOrDefault(v,new HashSet<>())));
//                dislikeMap.put(v,new HashSet<>());
//            }
//            flag=!flag;
//            queue=newQ;
//        }
//        return true;
//    }

    @Test
    public void test() {
        assertTrue(possibleBipartition(10, new int[][]{{4, 7}, {4, 8}, {2, 8}, {8, 9}, {1, 6}, {5, 8}, {1, 2}, {6, 7}, {3, 10}, {8, 10}, {1, 5}, {7, 10}, {1, 10}, {3, 5}, {3, 6}, {1, 4}, {3, 9}, {2, 3}, {1, 9}, {7, 9}, {2, 7}, {6, 8}, {5, 7}, {3, 4}}));
        assertTrue(possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        assertFalse(possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }


}
