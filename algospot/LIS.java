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
					
			//System.out.println(getLIS(n,r));
			int[] cache=new int[n+1];
			int ret=0;
			for(int j=0;j<n;j++) {
				ret=Math.max(ret, getLIS(r,cache,j));
			}
			System.out.println(ret);
		}
	}

	private static int getLIS(int[] r,int[]cache,int begin) {
		if(cache[begin]>0)return cache[begin];
		cache[begin]=1;
		for(int i=begin+1; i<r.length;i++) {
			if(r[begin]<r[i])
				cache[begin]=Math.max(cache[begin], getLIS(r,cache,i)+1);
		}
		return cache[begin];
	}
}
