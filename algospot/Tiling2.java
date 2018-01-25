import java.io.*;
import java.util.StringTokenizer;

public class Tiling2 {
	private static long[]canTile=new long[101];
	private final static long mod=1000000007;
	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("input.txt");
		//InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);

		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int t = Integer.valueOf(tokenizer.nextToken());
		
		canTile[1]=1;
		canTile[2]=2;
		
		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(tokenizer.nextToken());
			System.out.println(getCanTile(n));
		}
	}
	public static long getCanTile(int n){
		if(canTile[n]>0)return canTile[n];
		return (canTile[n]=(getCanTile(n-2)+getCanTile(n-1))%mod);
	}
}
