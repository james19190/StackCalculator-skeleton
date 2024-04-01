package com.dmlab.util.test;
import com.dmlab.util.MyStack;

public class StackTest {
    public static void main(String[] args) {
        // Implement your test here
        MyStack<Integer> stack = new MyStack<Integer>();

        // //test 1- add up to 128 items
        for (int i = 0; i < 128; i++) {
            stack.push(i);
        }

        // //test 2 - add more than 128 items
        for (int i = 0; i < 129; i++) {
            stack.push(i);
        }

        // //test 3 - pop empty stack
        stack.pop();

        // //test 4 - peek empty stack
        stack.peek();

        //test 5 - clear stack
        for (int i = 0; i < 128; i++) {
            stack.push(i);
        }
        System.out.println(stack.pop());
        stack.clear();
        stack.push(1);
        stack.push(3);
        System.out.println(stack.pop());            
    }
}
