package com.dmlab.util;

import java.util.EmptyStackException;

import com.dmlab.interfaces.Stack;

/**
 * Array-based Stack
 * The size of the internal array should be 128
 */
public class MyStack<E> implements Stack<E> {
	
	private E[] mData;
	private int mCursor;
	
	public MyStack() {
		clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		/* Code Here */
		mData = (E[]) new Object[128];
		mCursor = 0;
	}

	@Override
	public void push(E item) throws RuntimeException {
		/* Code Here */
		mData[mCursor++] = item;
		
	}

	@Override
	public E pop() throws EmptyStackException {
		/* Code Here */
		if(empty()) {
			throw new EmptyStackException();
		}
		return mData[--mCursor];
	}
 
	@Override
	public E peek() throws EmptyStackException {
		/* Code Here */
		if (empty()) {
			throw new EmptyStackException();
		}
		return mData[mCursor - 1];

	}

	@Override
	public boolean empty() {
		/* Code Here */
		return mCursor == 0;
	}

}
