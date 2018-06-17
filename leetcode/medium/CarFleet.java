import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

public class CarFleet {
	
	public int carFleet(int target, int[] position, int[] speed) {
		int ret = 0, len = position.length;
		TreeMap<Integer,Double> cars = new TreeMap<>(Collections.reverseOrder());

		for (int i = 0; i < len; i++)
			cars.put(position[i],(double)(target-position[i])/speed[i]);
		
		while(!cars.isEmpty()) {
			ret++;
			int pos=cars.firstKey();
			double time=cars.get(pos);
			cars.remove(pos);
			for(Object key:cars.keySet().toArray()) {
				if(cars.get(key)<=time)cars.remove(key);
			}
		}
		return ret;
	}

	@Test
	public void test() {
		assertEquals(6, carFleet(31, new int[] {5,26,18,25,29,21,22,12,19,6}, new int[] {7,6,6,4,3,4,9,7,6,4}));
		assertEquals(1, carFleet(10, new int[] { 0, 4, 2 }, new int[] { 2, 1, 3 }));
		assertEquals(6, carFleet(10, new int[] { 8,3,7,4,6,5 }, new int[] { 4,4,4,4,4,4 }));
	}
}
