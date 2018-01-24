import java.io.*;
import java.util.StringTokenizer;

public class Tiling2 {
	private static long[]canTile=new long[101];
	
	public static void main(String[] args) throws IOException {
		//InputStreamReader fr = new InputStreamReader(System.in);
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);

		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int t = Integer.valueOf(tokenizer.nextToken());
		
		canTile[1]=1;
		canTile[2]=2;
		
		for(int i=3; i<=100; i++){
			if(canTile[i]==0)
				canTile[i]=(canTile[i-2]+canTile[i-1])%((long)1000000007);
		}
		
		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(tokenizer.nextToken());
			System.out.println(canTile[n]);
		}
	}
}
