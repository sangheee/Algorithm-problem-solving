import java.util.*;
public class GlobalAndLocalInversions {
	public boolean isIdealPermutation(int[] A) {
		int global = 0;
		int local = 0;
		List<Integer> remain=new ArrayList<>();
		for(int i=0; i<A.length-1; i++){
			if(A[i]>A[i+1])local++;
			remain.add(i);
		}
		remain.add(A.length-1);
		
		
		for(int i=A.length-1;i>=0;i--){
			int idx=Collections.binarySearch(remain, A[i]);
			global+=remain.size()-idx-1;
			remain.remove(idx);
		}
		System.out.println(global + " " + local);
		return global == local;
	}
}
