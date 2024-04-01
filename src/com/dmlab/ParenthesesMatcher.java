package com.dmlab;

import com.dmlab.util.MyStack;

public class ParenthesesMatcher {

    public boolean isValid(String s) {
		/* Code Here */
        MyStack<Character> stack = new MyStack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.empty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }
    }
    
    return stack.empty();
    }
}
