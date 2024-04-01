package com.dmlab.util.test;
import com.dmlab.util.MyQueue;

public class QueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        
    }
    
}


/*
 * You can implement as limited sized array-based stack. When test your result, TA will not push over 128 items to the stack at the same time. But you should think of that TA can do the more pushes after pops. (e.g. 100 pushes -> 90 pops -> 100 pushes)
 */