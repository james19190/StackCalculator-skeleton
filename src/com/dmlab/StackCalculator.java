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


	public int solve(String infix) {
		/* Code Here */

		String[] token = infix.split(" ");

		for(int i=0; i<token.length; i++){
			
			if(typeOf(token[i])==TYPE_OPERATOR){
			
				while(!mStack.empty() && !mStack.peek().equals("(")){
					
					if(prior(token[i]) <= prior(mStack.peek())) {
						mQueue.add(mStack.pop());
					}
					
					else {
						break;
					}
				}

				mStack.push(token[i]);
			}

			else if(typeOf(token[i])==TYPE_BRACE){
				
				if(token[i].equals("(")) {
					mStack.push(token[i]);
				}

				else if(token[i].equals(")")){
						try {
							while(!mStack.empty() && !mStack.peek().equals("(")) mQueue.add(mStack.pop());
							if(mStack.peek().equals("(")) mStack.pop();
						} catch (Exception EmptyStackException) {
							System.out.println("EmptyStackException");
						}
				}
			}

			else if(typeOf(token[i])==TYPE_NUMBER) {
				mQueue.add(token[i]);
			}
		}

		while (!mStack.empty()){
			mQueue.add(mStack.pop());
		}


		while (true){
			try{
				String token_postfix = mQueue.poll();
				
				if(typeOf(token_postfix)==TYPE_OPERATOR){
                    int sc1 = mStackCalc.pop();
                    int sc2 = mStackCalc.pop();
                    if(token_postfix.equals("+")) mStackCalc.push(sc2+sc1);
                    else if(token_postfix.equals("-")) mStackCalc.push(sc2-sc1);
                    else if(token_postfix.equals("*")) mStackCalc.push(sc2*sc1);
                    else if(token_postfix.equals("/")) mStackCalc.push(sc2/sc1);
                }
				
				else if(typeOf(token_postfix)==TYPE_NUMBER){
				    int int_item = Integer.parseInt(token_postfix);
                    mStackCalc.push(int_item);
                }

			}catch(Exception EmptyQueueException){
				break;
			}
		}
        return mStackCalc.pop();

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
