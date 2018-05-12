import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

public class RaceCar {
	public int racecar(int target) {
		
		Set<String> visited =new HashSet<>();
		visited.add(0+" "+1);
		
		Queue<int[]> queue=new LinkedList<>();
		queue.add(new int[] {0,1});
	
		for(int length=0;!queue.isEmpty();length++) {
			for(int i=queue.size()-1; i>=0;i--) {
				int[] val=queue.poll();
				
				if(val[0]==target)return length;
				
				int[]A= {val[0]+val[1],val[1]*2};
				String key=A[0]+" "+A[1];
				if(A[0]==target)return length+1;
				else if(!visited.contains(key) && Math.abs(A[0]-target)<target) {
					queue.add(A);
					visited.add(key);
				}
				int[]R= {val[0],val[1]>0?-1:1};
				key=R[0]+" "+R[1];
				if(!visited.contains(key) && Math.abs(R[0]-target)<target) {
					queue.add(R);
					visited.add(key);
				}
			}
		}
		return -1;
	}
	@Test
	public void test() {
		assertEquals(racecar(3),2);
		assertEquals(racecar(6),5);
	}
}
