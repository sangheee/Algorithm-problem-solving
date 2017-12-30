
public class HammingDistance {
	public int hammingDistance(int x, int y) {
		//return Integer.bitCount(x^y);
		int nor=x^y;
		
		int result=0;
		for(int i=0; i<32;i++){
			result+=nor&1;
			nor=nor>>1;
		}
		return result;
	}
}
