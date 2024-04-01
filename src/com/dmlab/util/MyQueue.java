package com.dmlab.util;

import com.dmlab.interfaces.Queue;

/**
 * Array-based Queue
 * The size of the internal array should be 128
 */
public class MyQueue<E> implements Queue<E>{

	private E[] mData;
	private int mCursor, mHead, count;
	
	public MyQueue() {
		clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		/* Code Here */
		mData = (E[]) new Object[128];
		mCursor = 0;
		mHead = 0;
		count = 0;
	}

	@Override
	public void add(E item) throws RuntimeException {
		/* Code Here */
		if (count == 128) {
			throw new RuntimeException("exceed the limitation of the internal array space");
		}
		else {
			mData[mCursor++] = item;
			count++;
		}

	}

	@Override
	public E poll() throws EmptyQueueException {
		/* Code Here */
		if(empty()){
			throw new EmptyQueueException();
		}
		E item = mData[mHead];
		mHead = (mHead + 1) % 128;
		count--;
		return item;
	}

	@Override
	public E peek() throws EmptyQueueException {
		/* Code Here */
		if (count == 0) {
			throw new EmptyQueueException();
		}
		return mData[mHead];

	}

	@Override
	public boolean empty() {
		/* Code Here */
		return count == 0;
	}

}
