import java.util.*;

public class excelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuilder builder = new StringBuilder();
		while (n > 26) {
			if (n % 26 == 0) {
				builder.insert(0, (char) 90);
				n -= 26;
			} else {
				builder.insert(0, (char) ((n % 26) + 64));
			}
			n = n / 26;
		}
		if (n > 0)
			builder.insert(0, (char) (n + 64));
		return builder.toString();
	}
}
