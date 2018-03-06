import java.util.*;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res=new ArrayList<>();
		getNQueens(res,0,n,new ArrayList<>());
		return res;
	}

	private void getNQueens(List<List<String>> res, int level, int n, List<Integer>pos) {
		if(level==n) {
			List<String>tmp=new ArrayList<>();
			for(int i=0; i<n; i++) {
				char[] t=new char[n];
				Arrays.fill(t, '.');
				t[pos.get(i)]='Q';
				tmp.add(String.valueOf(t));
			}
			res.add(tmp);
		}
		
		for(int i=0; i<n;i++) {
			boolean flag=true;
			for(int j=0;j<pos.size();j++) {
				int val=pos.get(j);
				int gap=level-j;
				if(i==val || i==val-gap || i==val+gap) {
					flag=false;
					break;
				}
			}
			if(flag) {
				pos.add(i);
				getNQueens(res,level+1,n,pos);
				pos.remove(pos.size()-1);
			}
		}
	}
}
