package com.dmlab;

import com.dmlab.util.MyQueue;
import com.dmlab.util.MyStack;

public class StackCalculator {
 
	private MyStack<String> mStack;
	private MyQueue<String> mQueue;
	private MyStack<Integer> mStackCalc;

	private static final int TYPE_OPERATOR = 0;
	private static final int TYPE_BRACE = 1;
	private static final int TYPE_NUMBER = 2;

	public StackCalculator() {
		mStack = new MyStack<String>();
		mQueue = new MyQueue<String>();
		mStackCalc = new MyStack<Integer>();
	}

	/**
	 * Solve the given infix form of equation
	 * @param infix
	 * 			the infix form of an equation
	 * 			e.g. 1 + 2 - ( 3 - 4 )
	 * @return
	 * 			the result from the calculation of given equation
	 */

	 public String infixToPostfix(String infix) {
		/* Code Here */
		String[] tokens = infix.split(" ");
		for (String token : tokens) {
			int type = typeOf(token);
			if (type == TYPE_NUMBER) {
				mQueue.add(token);
			} else if (type == TYPE_OPERATOR) {
				while (!mStack.empty() && prior(mStack.peek()) >= prior(token)) {
					mQueue.add(mStack.pop());
				}
				mStack.push(token);
			} else if (token.equals("(")) {
				mStack.push(token);
			} else if (token.equals(")")) {
				while (!mStack.peek().equals("(")) {
					mQueue.add(mStack.pop());
				}
				mStack.pop();
			}
		}
		while (!mStack.empty()) {
			mQueue.add(mStack.pop());
		}
		String postfix = "";
		while (!mQueue.empty()) {
			postfix += mQueue.poll() + " ";
		}
		return postfix;
	 }

	public int solve(String infix) {
		/* Code Here */

			
		return 0;

	}

	private int typeOf(String entry) {
		if (entry.equals("+") || entry.equals("-") || entry.equals("*") || entry.equals("/")) {
			return TYPE_OPERATOR;
		} else if (entry.equals("(") || entry.equals(")")) {
			return TYPE_BRACE;
		} else {
			return TYPE_NUMBER;
		}
	}

	private int prior(String item) {
		if (item.equals("+") || item.equals("-")) {
			return 0;
		}
		return 1;
	}
}
