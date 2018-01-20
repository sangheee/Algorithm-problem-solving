import java.util.*;
public class ValidParentheses {
	public boolean isValid(String s) {
		char[] sSet=s.toCharArray();
		LinkedList<Character> stack=new LinkedList<>();
		Map<Character,Character> correct=new HashMap<Character,Character>(){
			{put('(',')');put('[',']');put('{','}');}
		};

		for(int i=0; i<sSet.length;i++){
			if(correct.containsKey(sSet[i])){
				stack.add(sSet[i]);
			}else if(stack.isEmpty() ||sSet[i]!=correct.get(stack.peekLast())){
				return false;
			}else {
				stack.removeLast();
			}
		}
		return stack.isEmpty()?true:false;
	}
}
