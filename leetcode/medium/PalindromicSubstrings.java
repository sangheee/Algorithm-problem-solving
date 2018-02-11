
public class PalindromicSubstrings {
/*  //cache를 사용한 dp solution
	public int countSubstrings(String s) {
		char[] c=s.toCharArray();
		boolean[][] isPalin=new boolean[c.length][c.length];

		int result=0;

		for(int i=0; i<c.length;i++) {
			for(int l=0,r=i;l<c.length-i && r<c.length;l++,r++) {
				if(c[l]==c[r]) {
					if(l==r || (r-l)==1 || isPalin[l+1][r-1]) {
						isPalin[l][r]=true;
						result++;
					}
				}
			}
		}
		return result;
	}
	*/
	public int countSubstrings(String s) {
		int res=0,length=s.length();
		char[]c =s.toCharArray();
		for(int i=0;i<length;i++) {
			for(int j=0;i-j>=0 && i+j<length && c[i-j]==c[i+j];j++)res++; //odd case, middle is i
			for(int j=0;i-j-1>=0 && i+j<length && c[i-j-1]==c[i+j];j++)res++; //even case, middle is [i-1,i]
		}
		return res;
	}
}
