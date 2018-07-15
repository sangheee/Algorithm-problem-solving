import org.junit.Test;
import java.util.*;

public class AdvantageShuffle {
	public int[] advantageCount(int[] A, int[] B) {
		int[]ret=new int[A.length];
		Arrays.sort(A);
		
		PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->{return o1[0]-o2[0];});
		for(int i=0; i<B.length;i++) {pq.add(new int[] {B[i],i});}
		
		Queue<Integer>remain=new LinkedList<>();
		for(int i=0;i<A.length && !pq.isEmpty();) {
			int[] cur=pq.peek();
			if(A[i]>cur[0]) {
				ret[cur[1]]=A[i];
				pq.poll();
			}else {
				remain.add(A[i]);
			}
			i++;
		}
		
		while(!pq.isEmpty()) {
			int[]cur=pq.poll();
			ret[cur[1]]=remain.poll();
		}
		return ret;
	}
	@Test
	public void test() {
		advantageCount(new int[] {8,2,4,4,5,6,6,0,4,7},new int[] {0,8,7,4,4,2,8,5,2,0});
		advantageCount(new int[] {2,0,4,1,2},new int[] {1,3,0,0,2});
		
	}
}
