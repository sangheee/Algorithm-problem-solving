import java.util.*;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<>();
		parenthesis(ret, new StringBuilder(), n, n);
		return ret;
	}

	public void parenthesis(List<String> ret, StringBuilder builder, int n, int m) {
		if (n > m)
			return;

		if (n == 0) {
			while (m > 0) {
				builder.append(')');
				m--;
			}
			ret.add(builder.toString());
			return;
		}
		parenthesis(ret, new StringBuilder(builder).append('('), n - 1, m);
		parenthesis(ret, new StringBuilder(builder).append(')'), n, m - 1);
	}
}
