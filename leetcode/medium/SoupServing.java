import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SoupServing {

	public double soupServings(int N) {
		if(N>4800)return 1;
	
		double[][] cache=new double[200][200];
		return getProb(cache,(N+24)/25,(N+24)/25);
	}
	
	public double getProb(double[][]cache, int A,int B) {
		if(A<=0 && B<=0) return 0.5;
		else if(A<=0) return 1;
		else if(B<=0) return 0;
		
		if(cache[A][B]>0) return cache[A][B];
		cache[A][B]=(getProb(cache,A-1,B-3)+getProb(cache,A-2,B-2)+getProb(cache,A-3,B-1)+getProb(cache,A-4,B))/4;
		return cache[A][B];
	}
	@Test
	public void test() {
		assertEquals(soupServings(50),0.625,0.0000001);
	}
}
