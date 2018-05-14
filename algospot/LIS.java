import java.io.*;
import java.util.StringTokenizer;

public class LIS {
	public static void main(String[] args) throws IOException {
		//InputStreamReader fr = new InputStreamReader(System.in);
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int C = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < C; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(tokenizer.nextToken());
			
			int[] r=new int[n];
			tokenizer = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)r[j]=Integer.valueOf(tokenizer.nextToken());
					
			System.out.println(getLIS(n,r));
		}
	}

	private static int getLIS(int n,int[] r) {
		int[] LIS=new int[100001];
		int ret=0;
		for(int i=0; i<n; i++) {
			int val=r[i];
			for(int j=0;j<val;j++) {
				LIS[val]=Math.max(LIS[val], LIS[j]);
			}
			LIS[val]+=1;
			ret=Math.max(ret, LIS[val]);
		}
		return ret;
	}
}
