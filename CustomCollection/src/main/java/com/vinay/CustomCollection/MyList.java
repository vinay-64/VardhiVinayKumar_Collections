package com.vinay.CustomCollection;

import java.util.Arrays;

public class MyList {
	private int size=0;
	private static final int INITIAL_CAPACITY=10;
	private Object data[];
	
	public MyList() {
		data = new Object[INITIAL_CAPACITY];
	}
	
	public int size() {
        return size;
    }
	
	private void increaseCapacity() {
        int newSize = data.length * 2;
        data = Arrays.copyOf(data, newSize);
    }
	
	public <T> void add(T element) {
		if(size == data.length) {
			increaseCapacity();
		}
		data[size++] = element;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        return (T) data[index];
    }
	
	@SuppressWarnings("unchecked")
	public <T> T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        Object item = data[index];
        int numOfElements = data.length - ( index + 1 ) ;
        System.arraycopy( data, index + 1, data, index, numOfElements ) ;
        size--;
        return (T) item;
    }
	
	public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < size ;i++) {
             sb.append(data[i].toString());
             if(i<size-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();
    }
	

}
