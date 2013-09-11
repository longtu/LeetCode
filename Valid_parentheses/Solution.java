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
}
