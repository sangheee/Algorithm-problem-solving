
public class BestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit(int[] prices) {
		int n=prices.length;
		if(n<1)return 0;
		int[] have=new int[n+1];
		int[] nothave=new int[n+1];
		have[1]=-prices[0];
		for(int i=2; i<n+1;i++) {
			have[i]=Math.max(have[i-1], nothave[i-2]-prices[i-1]);
			nothave[i]=Math.max(nothave[i-1], have[i-1]+prices[i-1]);
		}
		return nothave[n];
	}
}
