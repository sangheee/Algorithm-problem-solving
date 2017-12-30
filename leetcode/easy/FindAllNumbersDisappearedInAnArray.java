import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int[] appear = new int[nums.length + 1];

		for (int n : nums) {
			appear[n] = 1;
		}
		
		for (int i = 1; i <= nums.length; i++)
			if (appear[i] == 1)
				result.add(i);

		return result;
	}
}
