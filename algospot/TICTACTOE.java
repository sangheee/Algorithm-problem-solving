import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class TICTACTOE {
	private static List<Integer> tictactoe=initTicTacToe();
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("input.txt");
		// InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int c = Integer.valueOf(tokenizer.nextToken());
		int[] cache=new int[(int) Math.pow(3, 9)];
		Arrays.fill(cache, -2);
		char[][]board=new char[3][3];
		
		for (int i = 0; i < c; i++) {
			int xCnt=0,oCnt=0;
			for(int x=0; x<3;x++) {
				tokenizer = new StringTokenizer(br.readLine());
				String line=tokenizer.nextToken();
				for(int y=0;y<3; y++) {
					board[x][y]=line.charAt(y);
					if(board[x][y]=='x')xCnt++;
					else if(board[x][y]=='o')oCnt++;
				}
			}
			char turn=xCnt==oCnt?'x':'o';
			int val=canWin(board,cache,turn);
			System.out.println(val==0?"TIE":val>0?turn:(char)('o'+'x'-turn));
		}
	}
	
	private static List<Integer> initTicTacToe() {
		List<Integer> ttt=new ArrayList<>();
		for(int x=0;x<9;x+=3) {
			ttt.add((1<<x)+(1<<(x+1))+(1<<(x+2)));
		}
		for(int x=0;x<3;x++) {
			ttt.add((1<<x)+(1<<(x+3))+(1<<(x+6)));
		}
		ttt.add((1<<0)+(1<<4)+(1<<8));
		ttt.add((1<<2)+(1<<4)+(1<<6));
		return ttt;
	}
	
	private static boolean isFinished(char[][] board,char turn) {
		int sum=0;
		for(int i=0;i<board.length;i++) {
			for(int j=0; j<board[i].length;j++) {
				if(board[i][j]==turn) {
					sum+=(1<<(3*i)+j);
				}
			}
		}
		for(int ttt:tictactoe) {
			if(Integer.bitCount(ttt&sum)==3)
				return true;
		}
		return false;
	}
	
	private static int canWin(char[][] board,int[] cache,char turn) {
		int cur=getCur(board);
		if(cache[cur]!=-2)return cache[cur];
		else if(isFinished(board,(char) ('o'+'x'-turn))) {
			cache[cur]=-1;
			return cache[cur];
		}
		
		int res=2;
		for(int x=0; x<3; x++) {
			for(int y=0;y<3;y++) {
				if(board[x][y]=='.') {
					board[x][y]=turn;
					res=Math.min(res,canWin(board,cache,(char) ('o'+'x'-turn)));
					board[x][y]='.';
				}
			}
		}
		cache[cur]=res<2?-res:0;
		return cache[cur];
	}

	private static int getCur(char[][] board) {
		int cur=0;
		for(int x=0;x<3;x++) {
			for(int y=0;y<3;y++) {
				int val=0;
				if(board[x][y]=='x') val++;
				else if(board[x][y]=='o') val+=2; 
				cur+=Math.pow(3, 3*x+y)*val;
			}
		}
		return cur;
	}
}
