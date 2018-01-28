import java.io.*;
import java.util.*;

public class TRIPATHCNT {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("input.txt");
		BufferedReader br=new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int C= Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < C; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int n=Integer.valueOf(tokenizer.nextToken());
			List<int[]> tri=new ArrayList<>();
			for(int j=0; j<n; j++) {
				tri.add(new int[j+1]);
				tokenizer=new StringTokenizer(br.readLine());
				for(int k=0;k<j+1;k++) {
					tri.get(j)[k]=Integer.valueOf(tokenizer.nextToken());
				}
			}
			System.out.println(getTriPathCnt(tri));
		}
	}

	private static int getTriPathCnt(List<int[]> tri) {
		List<List<Integer>>cur=new ArrayList<>();
		List<List<Integer>>pre;
		
		if(tri.size()>0) {
			cur.add(Arrays.asList(tri.get(0)[0],1));
		}
		
		for(int i=1; i<tri.size();i++) {
			pre=cur;
			cur=new ArrayList<>();
			for(int j=0;j<tri.get(i).length;j++) {
				int key = 0,val = 0;
				if(j>0 && j<tri.get(i).length-1) {
					if(pre.get(j-1).get(0)==pre.get(j).get(0)) {
						key=pre.get(j-1).get(0)+tri.get(i)[j];
						val=pre.get(j-1).get(1)+pre.get(j).get(1);
					}else {
						int maxIdx=pre.get(j-1).get(0)>pre.get(j).get(0)?j-1:j;
						key=pre.get(maxIdx).get(0)+tri.get(i)[j];
						val=pre.get(maxIdx).get(1);
					}
					
				}else {
					if(j==0) key=pre.get(j).get(0)+tri.get(i)[j];
					else key=pre.get(j-1).get(0)+tri.get(i)[j];
					val=1;
				}
				cur.add(Arrays.asList(key,val));
			}
		}
		int cnt=0;
		int max=Integer.MIN_VALUE;
		for(List<Integer> cnts:cur) {
			if(cnts.get(0)>max) {
				max=cnts.get(0);
				cnt=cnts.get(1);
			}else if(cnts.get(0)==max)
				cnt+=cnts.get(1);
		}
		return cnt;
	}
}
