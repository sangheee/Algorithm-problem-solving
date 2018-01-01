
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if(prices.length<1)return 0;
		int min=prices[0];
		int diff=0;
		for(int p:prices){
			if(min>=p)min=p;
			else diff=Math.max(diff, p-min);
		}
		return diff;
	}
}
