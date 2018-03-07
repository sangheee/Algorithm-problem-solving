
public class UniqueBinarySearchTrees {
	/*public int numTrees(int n) {
		return getUniqTreeNums(1,n);
	}

	private int getUniqTreeNums(int l, int r) {
		if(l-r==1|| l==r)return 1;
		else if(r-l==1)return 2;
		
		int res=0;
		for(int i=l;i<=r;i++) {
			res+=getUniqTreeNums(l,i-1)*getUniqTreeNums(i+1,r);
		}
		return res;
	}*/
	
	public int numTrees(int n) {
		int[] arr=new int[n+2];
		arr[0]=1;
		arr[1]=2;
		return getUniqTreeNums(arr,1,n);
	}
	private int getUniqTreeNums(int[]arr,int l, int r) {
		if(l-r==1)return 1;
		if(arr[r-l]>0)return arr[r-l];
		else {
			int res=0;
			for(int i=l;i<=r;i++) {
				res+=getUniqTreeNums(arr,l,i-1)*getUniqTreeNums(arr,i+1,r);
			}
			arr[r-l]=res;
		}
		return arr[r-l];
	}
}
