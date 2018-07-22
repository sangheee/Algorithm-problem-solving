import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int H) {
		Arrays.sort(piles);
		int min=0, max=piles[piles.length-1];
		
		while(min<max) {
			int speed=(max-min)/2+min;
			int time=getTime(piles,speed);
			if(time<=H)max=speed;
			else min=speed+1;
		}
		
		return max;
	}
	private int getTime(int[] piles, int speed) {
		int time=0;
		for(int pile:piles) {
			time+=Math.ceil(pile/(double)speed);
		}
		return time;
	}
	@Test
	public void test() {
		assertEquals(30,minEatingSpeed(new int[] {30,11,23,4,20},5));
		assertEquals(23,minEatingSpeed(new int[] {30,11,23,4,20},6));
	}
}
