import java.io.*;
import java.util.*;

public class Leave {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("input.txt");
		// InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(tokenizer.nextToken());

		int[][]consulting=new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int t=Integer.valueOf(tokenizer.nextToken());
			int p=Integer.valueOf(tokenizer.nextToken());
			consulting[i]=new int[] {t,p};
		}
		System.out.println(getMaxBenefit(consulting,0,1,N));
	}

	private static int getMaxBenefit(int[][] consulting, int sum, int cur,int n) {
		if(cur>n)return sum;
		int max=sum;
		for(int i=cur;i<=n;i++) {
			if(i+consulting[i][0]-1>n)continue;
			max=Math.max(getMaxBenefit(consulting,sum+consulting[i][1],i+consulting[i][0],n),  max);
		}
		return max;
	} 
}
