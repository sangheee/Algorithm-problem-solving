import java.util.*;
public class UniqueMorseCodeWords {
	private static final String[] morse= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	public int uniqueMorseRepresentations(String[] words) {
		Set<String> resSet=new HashSet<>();
		StringBuilder builder=new StringBuilder();
		for(String word:words) {
			builder.setLength(0);
			for(int i=0; i<word.length();i++) {
				builder.append(morse[word.charAt(i)-97]);
			}
			resSet.add(builder.toString());
		}
		return resSet.size();
	}
}
