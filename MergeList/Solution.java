public String addBinary(String a, String b) {

    if(a == null)
        return addBinary("", b);

    if(b == null)
        return addBinary(a, "");

    Stack<Character> stack = new Stack<Character>();

    int carry = 0;
    for( int left = a.length()-1,right = b.length()-1; left >=0 || right >=0;){
        if( left >=0 && right >= 0){
            int carry = (a.charAt(left--) - '0' + b.charAt(right--) - '0') + carry;
        } 
        else if( left >= 0){
            int carry = (a.charAt(left--) - '0') + carry;
        } else {
            int carry = (a.charAt(right--) - '0') + carry;
        } 
        stack.push(carry%2 + '0');
        carry = carry/2;
    }
    if(carry > 0)
        stack.push(carry%2 + '0');

    StringBuilder sb = new StringBuilder();
    while(!stack.isEmpty())
        sb.append(stack.pop());
    return sb.toString();
}
