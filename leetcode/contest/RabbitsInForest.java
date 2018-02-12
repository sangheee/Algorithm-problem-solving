import java.util.*;

public class RabbitsInForest {
	public int numRabbits(int[] answers) {
	       int sum=0;
			Map<Integer,Integer> rabbits=new HashMap<>();
			for(int a:answers){
				int val=rabbits.getOrDefault(a, 0);
				if(val>a){
					sum+=a+1;
					val=0;
				}
				rabbits.put(a, val+1);
			}
			for(int r:rabbits.keySet())sum+=r+1;
			return sum;
	    }
}
