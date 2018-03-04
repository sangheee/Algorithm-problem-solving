import static org.junit.Assert.*;

import org.junit.Test;

public class ValidTicTacToeState {
	public boolean validTicTacToe(String[] board) {
		int xCnt=0,oCnt=0;
		int[] appear=new int[8];
		
		for(int i=0; i<board.length;i++) {
			char[] b=board[i].toCharArray();
			for(int j=0; j<b.length;j++) {
				int c=b[j];
				
				if(c!=' ') {
					if(c=='X')xCnt++;
					else oCnt++;
					appear[i]+=c=='X'?1:-1;
					appear[3+j]+=c=='X'?1:-1;
					if(i+j==2) {
						appear[7]+=c=='X'?1:-1;
					}
					if(i==j){
						appear[6]+=c=='X'?1:-1;
					}
				}
			}
		}
		int cnt=0,diff=xCnt-oCnt;
		for(int a:appear) {
			if(a==-3 ||a==3) {
				if(cnt!=0)return false;
				else if(a==-3)cnt--;
				else if(a==3)cnt++;
			}
		}
		
		if(diff>1 || diff<0)return false;
		if(cnt!=0) {
			if(cnt>0)return diff==1?true:false;
			else return diff==0?true:false;
		}
		return true;
	}

	@Test
	public void test() {
		//assertTrue(validTicTacToe(new String[] { "XOX","OXO","XOX"}));
		assertFalse(validTicTacToe(new String[] { "XXX","XOO","OO " }));
		assertFalse(validTicTacToe(new String[] { "O  ", "   ", "   " }));
		assertFalse(validTicTacToe(new String[] { "XOX", " X ", "   "}));
		assertFalse(validTicTacToe(new String[] { "XXX", "   ", "OOO"}));
		assertTrue(validTicTacToe(new String[] { "XOX", "O O", "XOX" }));
	}
}
