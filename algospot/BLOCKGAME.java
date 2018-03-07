import java.io.*;
import java.util.*;

public class BLOCKGAME {
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("input.txt");
		// InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		
		
		int c = Integer.valueOf(tokenizer.nextToken());
		Map<Integer,Boolean> canWin=new HashMap<>();
		List<Integer> preCal=getPreCal();
		canWin.put(0, false);

		
		for (int i = 0; i < c; i++) {
			int state=0;
			for(int y=0;y<5;y++) {
				tokenizer = new StringTokenizer(br.readLine());
				String line=tokenizer.nextToken();
				for(int x=0;x<5;x++)
					if(line.charAt(x)=='#')
						state+=1<<5*y+x;
			}
			System.out.println(calculIsWin(preCal,canWin,state)?"WINNING":"LOSING");
		}
	}
	
	private static List<Integer> getPreCal() {
		List<Integer> pre=new ArrayList<>();
		for(int i=0;i<4;i++) {
			for(int j=0; j<4;j++) {
				int sum=(1<<(5*i+j))+(1<<(5*(i+1)+j))+(1<<(5*(i+1)+j+1))+(1<<(5*i+j+1));
				for(int k=0;k<2;k++) {
					pre.add(sum-(1<<5*i+j+k));
					pre.add(sum-(1<<5*(i+1)+j+k));
				}
			}
		}
		
		for(int i=0;i<5;i++) {
			for(int j=0; j<4;j++) {
				pre.add((1<<5*i+j)+(1<<5*i+j+1));
				pre.add((1<<5*j+i)+(1<<5*(j+1)+i));
			}
		}
		return pre;
	}

	private static boolean calculIsWin(List<Integer> preCal,Map<Integer, Boolean> canWin, int state) {
		if(canWin.containsKey(state))
			return canWin.get(state);
		
		canWin.put(state, false);
		for(int pre:preCal) {
			if((state&pre)==0) {
				if(!calculIsWin(preCal,canWin,state|pre)) {
					canWin.put(state, true);
					break;
				}
			}
		}
		return canWin.get(state);
	}

}
