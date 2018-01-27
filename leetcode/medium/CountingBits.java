import org.junit.Test;

public class CountingBits {
	public int[] countBits(int num) {
		int[] result=new int[num+1];
		result[0]=0;
		int mul=1;
		int idx=1;
		while(idx<num+1) {
			result[idx++]=1;
			for(int i=1;i<mul;i++) {
				if(idx>=num+1)break;
				result[idx++]=result[mul]+result[i];
			}
			mul*=2;
		}
		return result;
	}
	@Test
	public void test() {
		System.out.println(new CountingBits().countBits(5));
	}
}
