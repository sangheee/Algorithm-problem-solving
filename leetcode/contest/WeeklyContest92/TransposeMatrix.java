
public class TransposeMatrix {
	public int[][] transpose(int[][] A) {
		if (A.length < 1)
			return A;
		int[][] ret = new int[A[0].length][A.length];

		for(int i=0; i<A.length;i++) {
			for(int j=0; j<A[0].length;j++)
				ret[j][i]=A[i][j];
		}
		return ret;
	}

	public static void main(String[]args) {
		new TransposeMatrix().transpose(new int[][] {{1,2,3},{4,5,6}});
	}
}
