
public class ClimbingStairs {

	public int climbStairs(int n) {		
		int first=1, second=1;
		int tmp;
		
		for(int i=2;i<=n;i++){
			tmp=second;
			second=first+second;
			first=tmp;
		}
		return second;
	}
}
