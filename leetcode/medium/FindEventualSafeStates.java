import org.junit.Test;
import java.util.*;

public class FindEventualSafeStates {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		boolean[] visited=new boolean[graph.length];
		int[] isSafe=new int[graph.length];
		Set<Integer> res=new HashSet<>();
		for(int i=0; i<graph.length;i++) {
			res.add(i);
			dfs(visited,isSafe,graph,i);
		}
		
		for(int i=0; i<isSafe.length;i++) {
			if(isSafe[i]<0)res.remove(i);
		}
		return new ArrayList<>(res);
	}
	
	private int dfs(boolean[] visited,int[] isSafe, int[][] graph, int i) {
		if(visited[i])return -1;
		if(isSafe[i]!=0)return isSafe[i];
		if(graph[i].length==0) {
			isSafe[i]=1;
			return 1;
		}
		
		visited[i]=true;
		for(int next:graph[i]) {
			isSafe[i]=dfs(visited,isSafe,graph,next);
			if(isSafe[i]<0) {
				return -1;
			}
		}
		visited[i]=false;
		return isSafe[i];
	}
	@Test
	public void test() {
		eventualSafeNodes(new int[][] {{1,2},{2,3},{5},{0},{5},{},{}});
	}
}
