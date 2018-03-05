
public class BestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit(int[] prices) {
		int n=prices.length;
		if(n<1)return 0;
		int have=-prices[0],prehave=0;
		int nothave=0,prenothave=0;
		
		for(int i=2; i<n+1;i++) {
			int tmp=have;
			have=Math.max(have, prenothave-prices[i-1]);
			prehave=tmp;
			tmp=nothave;
			nothave=Math.max(nothave, prehave+prices[i-1]);
			prenothave=tmp;
		}
		return nothave;
	}
}
