class Solution {
    public boolean isHappy(int n) {
		int[] decimal = new int[10];
		for (int i = 0; i < 10; i++)
			decimal[i] =(int) Math.pow(i, 2);
		//List<Integer> appeared = new ArrayList<>();
		Map<Integer,Boolean> appeared=new HashMap<>();
		appeared.put(n,true);

		while (true) {
			int sum = 0;
			char[] charN = ("" + n).toCharArray();
			for (char c : charN) {
				sum += decimal[c-48];
			}
			if (sum == 1)return true;
			if (appeared.containsKey(sum))return false;
			appeared.put(sum, true);
			n = sum;
		}
	}
}