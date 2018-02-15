import java.io.*;
import java.util.*;

public class CoinChange {
	private static final int MOD=1000000007;
	public static void main(String[] args) throws IOException {
		InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int T = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < T; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int M = Integer.valueOf(tokenizer.nextToken());
			int C = Integer.valueOf(tokenizer.nextToken());
			
			int[] coins=new int[C];
			
			tokenizer = new StringTokenizer(br.readLine());
			for(int j=0; j<C;j++)coins[j]=Integer.valueOf(tokenizer.nextToken());
			
			System.out.println(getCoinChange(M,coins));
		}
	}

	private static int getCoinChange(int m, int[] coins) {
		int[] money=new int[m+1];

		for(int i=0; i<coins.length && coins[i]<m;i++) {
			money[coins[i]]+=1;
			for(int j=coins[i];j<=m;j++) {
				money[j]+=money[j-coins[i]];
				money[j]%=MOD;
			}
		}
		return money[m];
	}
}
