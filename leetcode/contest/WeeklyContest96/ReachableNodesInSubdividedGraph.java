package contest.WeeklyContest96;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ReachableNodesInSubdividedGraph {
    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer, Integer>> nodes = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> moves = new HashMap<>();

        for (int[] edge : edges) {
            if (!nodes.containsKey(edge[0])) nodes.put(edge[0], new HashMap<>());
            nodes.get(edge[0]).put(edge[1], edge[2]);
            if (!nodes.containsKey(edge[1])) nodes.put(edge[1], new HashMap<>());
            nodes.get(edge[1]).put(edge[0], edge[2]);
        }

        int[] max = new int[N];
        max[0] = M;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        pq.add(new int[]{0, M});

        boolean[] visited = new boolean[N];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0];
            int remain = cur[1];
            if (!moves.containsKey(i)) moves.put(i, new HashMap<>());
            visited[i] = true;
            for (int j : nodes.getOrDefault(i, new HashMap<>()).keySet()) {
                int val = moves.get(i).getOrDefault(j, 0);
                int node = nodes.get(i).getOrDefault(j, -1);
                moves.get(i).put(j, Math.max(val, Math.min(remain, node)));

                int newRemain = remain - node - 1;
                if (newRemain >= max[j]) {
                    max[j] = newRemain;
                    pq.add(new int[]{j, newRemain});
                }
            }
        }
        int ret = 1;
        visited[0]=false;
        for (int[] edge : edges) {
            ret += (visited[edge[0]] ? 1 : 0) + (visited[edge[1]] ? 1 : 0);
            visited[edge[0]] = false;
            visited[edge[1]] = false;
            int val1 = moves.getOrDefault(edge[0], new HashMap<>()).getOrDefault(edge[1], 0);
            int val2 = moves.getOrDefault(edge[1], new HashMap<>()).getOrDefault(edge[0], 0);
            ret += Math.min(val1 + val2, nodes.get(edge[0]).get(edge[1]));
        }

        return ret;
    }


    @Test
    public void test() {
        assertEquals(43, reachableNodes(new int[][]{{3, 4, 8}, {0, 1, 3}, {1, 4, 0}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {1, 3, 3}, {2, 4, 3}, {2, 3, 3}, {0, 2, 10}}, 7, 5));
       // assertEquals(13, reachableNodes(new int[][]{{1, 2, 5}, {0, 3, 3}, {1, 3, 2}, {2, 3, 4}, {0, 4, 1}}, 7, 5));
        assertEquals(18, reachableNodes(new int[][]{{2, 4, 2}, {3, 4, 5}, {2, 3, 1}, {0, 2, 1}, {0, 3, 5}}, 14, 5));
        assertEquals(1, reachableNodes(new int[][]{{1, 2, 4}, {1, 4, 5}, {1, 3, 1}, {2, 3, 4}, {3, 4, 5}}, 17, 5));
        assertEquals(13, reachableNodes(new int[][]{{0, 1, 10}, {0, 2, 1}, {1, 2, 2}}, 6, 3));
        assertEquals(23, reachableNodes(new int[][]{{0, 1, 4}, {1, 2, 6}, {0, 2, 8}, {1, 3, 1}}, 10, 4));
    }
}
