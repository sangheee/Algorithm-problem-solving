
public class NumberOfLinesToWriteString {
	public int[] numberOfLines(int[] widths, String S) {
		int l1=0,l2=100;
		for(int i=0;i<S.length();i++) {
			int val=widths[S.charAt(i)-97];
			if(l2+val>100) {
				l1++;
				l2=val;
			}else {
				l2+=val;
			}
		}
		return new int[] {l1,Math.max(l2,0)};
	}
}
