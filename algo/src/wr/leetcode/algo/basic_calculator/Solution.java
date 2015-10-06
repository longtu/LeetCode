package wr.leetcode.algo.basic_calculator;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * https://en.wikipedia.org/wiki/Shunting-yard_algorithm
 */

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.calculate("1 + 1"));
        System.out.println(sol.calculate(" 2-1 + 2 "));
        System.out.println(sol.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(sol.calculate("3+2*2"));
        System.out.println(sol.calculate("3/2 "));
        System.out.println(sol.calculate("3+5 / 2"));

    }

    public int calculate(String s) {
        Tokenizer tokenizer = new Tokenizer(s);
        List<Token> infix = new LinkedList<>();
        while(tokenizer.hasNext()){
            infix.add(tokenizer.nextToken());
        }
        return evalPostfix(generatePosifix(infix));
    }

    public int evalPostfix(List<Token> postfix) {
        Stack<Integer> stack = new Stack<>();
        for(Token token : postfix ) {
            int op1, op2;
            switch (token.value){
                case "+":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1+op2);
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1-op2);
                    break;
                case "*":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1*op2);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1/op2);
                    break;
                default:
                    stack.push(Integer.valueOf(token.value));
            }
        }
        return (stack.isEmpty())?(0):(stack.peek());
    }

    public boolean isPrecedenceGreaterOrEqual(Token lhs, Token rhs) {
        String r = rhs.value;
        String l = lhs.value;
        return !((r.equals("/")||r.equals("*")) && (l.equals("+")||l.equals("-")));
    }


    public List<Token> generatePosifix(List<Token> prefix) {
        Stack<Token> stack = new Stack<>();
        List<Token> output = new LinkedList<>();

        for (Token token: prefix) {
            if(token.type.equals(Token.TokenType.OPERAND)) {
                output.add(token);
            } else if(token.type.equals(Token.TokenType.LEFT_PARENTHESIS)) {
                stack.push(token);
            } else if(token.type.equals(Token.TokenType.RIGHT_PARENTHESIS)) {
                while(!stack.peek().type.equals(Token.TokenType.LEFT_PARENTHESIS)) {
                    output.add(stack.pop());
                }
                stack.pop();
            } else if(token.type.equals(Token.TokenType.OPERATOR)) {
                if(stack.isEmpty()) {
                    stack.push(token);
                } else {
                    while(!stack.isEmpty()&& stack.peek().type.equals(Token.TokenType.OPERATOR)
                            && isPrecedenceGreaterOrEqual(stack.peek(), token)) {
                        output.add(stack.pop());
                    }
                    stack.push(token);
                }
            } else {
                throw new IllegalStateException("Illegal Input token");
            }
        }
        while (!stack.isEmpty()){
            output.add(stack.pop());
        }
        return output;
    }

}

class Token{
    String value;
    TokenType type;
    public enum TokenType {
        LEFT_PARENTHESIS, RIGHT_PARENTHESIS, OPERATOR, OPERAND
    }
    @Override
    public String toString(){
        return value;
    }
}

class Tokenizer {

    String str;
    int index;

    public Tokenizer (String str) {
        if(null != str) {
            str = str.replaceAll("\\s", "");
        }
        this.str = str;
        this.index = 0;
    }

    public boolean hasNext() {
        return (null != str) && (index < str.length());
    }

    public Token nextToken() {
        Token token = null;
        if( !hasNext()) {
            return token;
        }
        boolean stop = false;
        while(index < str.length() && !stop) {
            char ch = str.charAt(index);
            token = new Token();
            token.value = Character.toString(ch);
            switch (ch) {
                case '(':
                    token.type = Token.TokenType.LEFT_PARENTHESIS;
                    index++;
                    break;
                case ')':
                    token.type = Token.TokenType.RIGHT_PARENTHESIS;
                    index++;
                    break;
                case '+':
                    token.type = Token.TokenType.OPERATOR;
                    index++;
                    break;
                case '-':
                    token.type = Token.TokenType.OPERATOR;
                    index++;
                    break;
                case '*':
                    token.type = Token.TokenType.OPERATOR;
                    index++;
                    break;
                case '/':
                    index++;
                    token.type = Token.TokenType.OPERATOR;
                    break;
                default: {
                    if( isDigit(ch) ){
                        int num = 0;
                        while(index < str.length()){
                            ch = str.charAt(index);
                            if(!isDigit(ch)) {
                                break;
                            }
                            num = num * 10 + ch - '0';
                            index++;
                        }
                        token.type = Token.TokenType.OPERAND;
                        token.value = Integer.toString(num);
                    }
                }
            }
            stop = true;
        }
        return token;
    }

    private boolean isDigit(char ch) {
        return ch <='9' && ch >='0';
    }

}
