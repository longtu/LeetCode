//wild card matching
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
		// DO NOT write main() function
		if(s == null && p == null)
			return true;
		if(s == null)
			return p.isEmpty();
		if(p == null)
			return s.isEmpty();

		int []prev = new int[s.length()+1];
		int [] next = null;
		char[] src = s.toCharArray();
		char[] pattern = p.toCharArray();
		prev[0] = 1;
		for(int i = 1;i<=p.length();++i){
			next = new int[s.length()+1];
			for(int j = 0; j<= s.length();++j){
				if(pattern[i-1] == '*') {
					if(j > 0 ) {
						for(int k = 0; k<=j; ++k){
							if(prev[k] == 1){
								next[j] =1;
								break;
							}
						}
					}
					else
						next[j]=prev[j];
				}
				else if(pattern[i-1] == '?'){
					if(j == 0)
						continue;
					next[j]=prev[j-1];
				}
				else {
					if( j == 0)
						continue;
					if(prev[j-1] == 1 && pattern[i-1] == src[j-1])
						next[j] = 1;
				}
			}
			prev = next;
		}
		return prev[s.length()]==1;
    }
}
