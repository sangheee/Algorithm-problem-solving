import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindDuplicateNumber {

	/*public int findDuplicate(int[] nums) {
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
	}*/
	public int findDuplicate(int[] nums) {
		int p1=0,p2=0;
		do{
			p1=nums[p1];
			p2=nums[nums[p2]];
		}while(p1!=p2);
		p1=0;
		while(p1!=p2) {
			p1=nums[p1];
			p2=nums[p2];			
		}
		return p1;
	}
	@Test
	public void test() {
		assertEquals(findDuplicate(new int[] {1,3,4,2,1}),1);
	}
}
