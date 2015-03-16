public class Solution{
    boolean matches( char src, char dest){
        return (src == '(' && dest ==')') || (src == '[' && dest ==']') ||
            (src == '{' && dest =='}');
    }
    public boolean isValid(String s) {

        if(s == null)
            return true;
        Stack<Character> stack = new Stack<Character>();
        char [] arr =s.toCharArray();

        for(int i= 0; i < s.length(); ++i){
            char ch = arr[i];
            if(ch== '(' || ch=='[' || ch== '{'){
                stack.push(ch);
                continue;
            }
            if(!stack.isEmpty() && matches(stack.peek(),ch)){
                stack.pop();
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }

    //generate parenthesis
	public LinkedList<String> genAllParenth(int n){

		LinkedList<String> res = new LinkedList<String>();
		if(n==0){
			res.add(new String(""));
			return res;
		}
		if(n==1){
			res.add(new String("()"));
			return res;
		}
		for(int k = 0; k<n; ++k){
			LinkedList<String> leftSub = genAllParenth(k);
			LinkedList<String> rightSub = genAllParenth(n-k-1);
			for (String left: leftSub)
				for(String right: rightSub){
					StringBuilder sb = new StringBuilder(2*n);
					sb.append("(");
					sb.append(left);
					sb.append(")");
					sb.append(right);
					res.add(sb.toString());
				}
		}
		return res;
	}
	public LinkedList<String> genAllParenthDP(int n){

		Map<Integer,LinkedList<String>> prevResults = new HashMap<Integer,LinkedList<String>>();
		for(int i = 0; i<=n; ++i){
			LinkedList<String> res = new LinkedList<String>();
			if(i == 0){
				res.add("");
			}else{
				for(int k = 0; k<i; ++k){
					LinkedList<String> leftSub = prevResults.get(k);
					LinkedList<String> rightSub = prevResults.get(i-k-1);
					for (String left: leftSub)
						for(String right: rightSub){
							String sb = "(" +left+right+")";
							res.add(sb);
						}
				}
			}
			prevResults.put(i, res);
		}
		return prevResults.get(n);
	}
    
}
