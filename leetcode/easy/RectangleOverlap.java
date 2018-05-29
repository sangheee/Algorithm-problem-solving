
public class RectangleOverlap {
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		return isOverlap(rec1[0],rec1[2],rec2[0],rec2[2]) && isOverlap(rec1[1],rec1[3],rec2[1],rec2[3]);
	}
	public boolean isOverlap(int v1,int v2, int v3, int v4) {
		int max=Math.min(Math.max(v1, v2), Math.max(v3, v4));
		int min=Math.max(Math.min(v1, v2), Math.min(v3, v4));
		return max>min;
	}
}
