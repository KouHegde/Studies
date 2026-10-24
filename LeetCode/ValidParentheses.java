package org.example.Study.LeetCode;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String input = "[(]){})(";
        Boolean out = isValidParentheses(input);

    }

    private static Boolean isValidParentheses(String input) {
        if (input.length() % 2 != 0) return false;


        if (!(input.charAt(0) == '(' || input.charAt(0) == '[' || input.charAt(0) == '{')) return false;

        Stack<Character> stack = new Stack<>();

        for (Character c : input.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();

                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }








    public static  boolean validParenthesis(String s){
        if(s.length() %2 != 0){
            return false;
        }
        if(s.charAt(0) != '(' || s.charAt(0) == '{' || s.charAt(0) == '[') return false;
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c=='{' || c== '['){
               stack.push(c);
            } else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) return false;
            }
        }
        return stack.isEmpty();
    }




}
