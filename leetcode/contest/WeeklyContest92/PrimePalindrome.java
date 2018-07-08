import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PrimePalindrome {
	public int primePalindrome(int N) {
		if(N==1)return 2;
		int digit=0,tmp=N;
		while(tmp>0) {
			tmp/=10;
			digit++;
		}

		while(true) {
			int n=digit>1?(int) Math.pow(10, digit/2-1):0;
			int tenToTheHalf=(int) Math.pow(10, digit/2);
			while(n<tenToTheHalf) {
				tmp=n*tenToTheHalf;
				int reverse=getReverse(n);
				if(digit%2==1) { // handle odd
					tmp*=10;
					for(int i=0; i<10; i++) {
						int val=tmp+i*tenToTheHalf+reverse;
						if(isPrimePalindrome(val,N))return val;
					}
				}else{
					tmp+=reverse;
					if(isPrimePalindrome(tmp,N))return tmp;
				}
				n++;
			}
			digit++;
		}
	}
	
	private boolean isPrimePalindrome(int x,int N) {
		return x>=N && isPrime(x);
	}
	
	private boolean isPrime(int N) {
		int i=2,d=(int) Math.sqrt(N);
		for(;i<=d;i++) {
			if(N%i==0)break;
		}
		return i==(d+1);
	}
	private int getReverse(int N) {
		int reverse=0;
		while(N>0) {
			reverse*=10;
			reverse+=N%10;
			N/=10;
		}
		return reverse;
	}
	
	@Test
	public void test() {
		assertEquals(primePalindrome(11),11);
		assertEquals(primePalindrome(3),3);
		assertEquals(primePalindrome(13),101);
		assertEquals(primePalindrome(51633903),100030001);
	}
}
