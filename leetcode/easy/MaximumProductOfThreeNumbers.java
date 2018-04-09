import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MaximumProductOfThreeNumbers {
	public int maximumProduct(int[] nums) {
		if(nums.length<3) {
			int res=nums.length>0?1:0;
			for(int n:nums) res*=n;
			return res;
		}
		Arrays.sort(nums);
		int length=nums.length;
		return Math.max(nums[0]*nums[1]*nums[length-1], nums[length-1]*nums[length-2]*nums[length-3]);
	}
	@Test
	public void test() {
		assertEquals(maximumProduct(new int[] {722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786}),943695360);
		assertEquals(maximumProduct(new int[] {-4,-3,-2,-1,60}),720);
		assertEquals(maximumProduct(new int[] {9,1,2,3,4,5,6,8,7}),504);
	}
}
