import java.util.*;

import org.junit.Test;

public class AllPathsFromSourceTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res=new ArrayList<>();
		dfs(res,graph,new ArrayList<>(),0,graph.length-1);
		return res;
	}
	private void dfs(List<List<Integer>> res,int[][]graph,List<Integer> path,int cur,int des) {
		path.add(cur);
		if(cur==des) {
			res.add(new ArrayList<>(path));
		}
		
		for(int next:graph[cur]) {
				dfs(res,graph,path,next,des);
		}
		path.remove(path.size()-1);
	}
	
	@Test
	public void test() {
		int[][]graph=new int[4][];
		graph[0]= new int[]{1,2};
		graph[1]= new int[]{3};
		graph[2]= new int[]{3};
		graph[3]=new int[0];
		List<List<Integer>> res=allPathsSourceTarget(graph);
		for(List<Integer>r:res) {
			
			System.out.println(r.toString());
		}
	}
}
