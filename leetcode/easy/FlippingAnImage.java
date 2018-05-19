
public class FlippingAnImage {
	public int[][] flipAndInvertImage(int[][] A) {
		int len=A[0].length;
		for(int[] row:A) {
			for(int i=0;i<(len+1)/2;i++) {
				int tmp=row[i]^1;
				row[i]=row[len-i-1]^1;
				row[len-i-1]=tmp;
			}
		}
		return A;
	}
}
