import java.util.*;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret=new ArrayList<>();
		for(int i=1;i<=numRows; i++) {
			List<Integer> tmp=new ArrayList<>();
			long num=1;
			tmp.add(1);
			for(int j=1;j<i;j++) {
				num=num*(i-j)/j;
				tmp.add((int) num);
			}
			ret.add(tmp);
		}
		return ret;
	}
}
