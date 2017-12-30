import java.util.*;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		Map<Integer,Boolean> appear=new HashMap<>();
		for(int n:nums){
			if(appear.containsKey(n))appear.remove(n);
			else appear.put(n, true);
		}
		int result=0;
		for(int key:appear.keySet())result=key;
		return result;
	}
}
