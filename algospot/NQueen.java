import java.io.*;
import java.util.*;

public class NQueen {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("input.txt");
		// InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int c = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < c; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int n=Integer.valueOf(tokenizer.nextToken());
			System.out.println(getNQueens(0,n,new int[n]));
		}
		
	}
	private static int getNQueens(int row, int n, int[] pos) {
		if(row==n) return 1;
		int res=0;
		for(int i=0; i<n;i++) {
			boolean flag=true;
			for(int j=0;j<row;j++) {
				int val=pos[j];
				int gap=row-j;
				if(i==val || i==val-gap || i==val+gap) {
					flag=false;
					break;
				}
			}
			if(flag) {
				pos[row]=i;
				res+=getNQueens(row+1,n,pos);
			}
		}
		return res;
	}
}
