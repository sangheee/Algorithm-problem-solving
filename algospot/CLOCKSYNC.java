import java.io.*;
import java.util.*;

public class CLOCKSYNC {
	public static int[][] buttons=new int [][]{
		{0,1,2},
		{3,7,9,11},
		{4,10,14,15},
		{0,4,5,6,7},
		{6,7,8,10,12},
		{0,2,14,15},
		{3,14,15},
		{4,5,7,14,15},
		{1,2,3,4,5},
		{3,4,5,9,13}
	};
	public static final int buttonNum=10;
	public static final int clockNum=16;
	
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("input.txt");
		BufferedReader br=new BufferedReader(fr);
		
		StringTokenizer tokenizer=new StringTokenizer(br.readLine());
		
		int t=Integer.valueOf(tokenizer.nextToken());
	
		for(int i=0; i<t;i++){
			tokenizer=new StringTokenizer(br.readLine());
			int[] clocks=new int[clockNum];
			for(int j=0; tokenizer.hasMoreTokens();j++){
				clocks[j]=Integer.valueOf(tokenizer.nextToken());
			}
			int res=clockSync(clocks,0);
			System.out.println(res<Integer.MAX_VALUE?res:-1);
		}
	}
	
	public static void pushButton(int[] clocks,int button){
		for(int i=0; i<buttons[button].length;i++){
			int c=buttons[button][i];
			clocks[c]+=3;
			if(clocks[c]==15)clocks[c]=3;
		}
	}
	
	public static int clockSync(int[] clocks,int button){
		if(button==buttonNum){
			boolean flag=true;
			for(int clock:clocks){
				if(clock!=12){flag=false;break;}
			}
			return flag==true?0:Integer.MAX_VALUE;
		}
		
		int min=Integer.MAX_VALUE;
		for(int cnt=0; cnt<4;cnt++){
			int tmp=clockSync(clocks,button+1);
			min=Math.min(min, tmp==Integer.MAX_VALUE?tmp:tmp+cnt);
			pushButton(clocks,button);
		}
		return min;
	}
}
