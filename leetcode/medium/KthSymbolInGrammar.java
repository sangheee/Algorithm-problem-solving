
public class KthSymbolInGrammar {
	/*public int kthGrammar(int N, int K) {
		int flag=1;
		while(N>=3) {
			int threshold=(int) Math.pow(2, N-2);
			if(K>threshold) {
				int k=K%threshold;
				K=k==0?threshold:k;
				flag*=-1;
			}
			N--;
		}
		int result=K==1?0:1;
		
		return flag>0?result:(result==0?1:0);
	}
	*/
	public int kthGrammar(int N, int K) {
	    return Integer.bitCount(K-1) & 1;
	}
}
