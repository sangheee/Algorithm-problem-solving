class Solution {
   public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())return false;
		int[] alpabet=new int[26];
		for(int i=0; i<s.length(); i++){
			alpabet[s.charAt(i)-97]++;
			alpabet[t.charAt(i)-97]--;
		}
		for(int i=0; i<alpabet.length;i++){
			if(alpabet[i]!=0)return false;
		}
		return true;
	}
}