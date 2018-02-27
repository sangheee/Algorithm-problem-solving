import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindDuplicateNumber {

	public int findDuplicate(int[] nums) {
		int l=1,r=nums.length-1;
		
		while(r-l>1) {
			int numl=0,numr=0;
			int m=(r-l)/2+l;
			for(int n:nums) {
				if(n<=m && n>=l)numl++;
				if(n>m && n<=r)numr++;
			}
			if(numl>numr)r=m;
			else l=m+1;
		}
		int i=0,j=0;
		for(int n:nums) {
			if(n==l)i++;
			if(n==r)j++;
		}
		return i>j?l:r;
	}
	@Test
	public void test() {
		assertEquals(findDuplicate(new int[] {1,3,4,2,1}),1);
	}
}
