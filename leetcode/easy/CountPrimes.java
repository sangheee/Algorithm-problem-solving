
public class CountPrimes {
	public int countPrimes(int n) {
		boolean[] isPrime=new boolean[n+1];
		int res=0;
		for(int i=2;i<n;i++) {
			if(!isPrime[i]) {
				res++;
				for(int j=1;i*j<n;j++) {
					isPrime[i*j]=true;
				}
			}
		}
		return res;
	}
}
