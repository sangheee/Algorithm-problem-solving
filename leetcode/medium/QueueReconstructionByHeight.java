import java.util.*;


public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people,new Comparator<int[]>(){
			@Override
			public int compare(int[] a0, int[] a1) {
				if(a0[0]>a1[0])return -1;
				else if(a0[0]<a1[0])return 1;
				else return a0[1]-a1[1];
			}
		});
		List<int[]>result=new LinkedList<>();

		for(int i=0;i<people.length;i++) {
            result.add(people[i][1], people[i]);
		}
		return result.toArray(new int[0][0]);
	}
}
