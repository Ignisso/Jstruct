import java.lang.StringBuilder;
import java.lang.IndexOutOfBoundsException;
import java.lang.IllegalArgumentException;

import java.util.Iterator;

@SuppressWarnings("unchecked")

public class DynamicArray<E> implements Iterable<E> {
    private final int INITIAL_SIZE = 8;
    private final int EXPAND_RATIO = 2;
    
    private E[] array;
     
    private int length;
    private int capacity;
    
    
    public DynamicArray() {
        this.array = (E[]) new Object[INITIAL_SIZE];
        
        this.length = 0;
        this.capacity = 8;
    }
    
    public DynamicArray(int customSize) {
        this.array = (E[]) new Object[customSize];
        
        this.length = 0;
        this.capacity = customSize;
    }
    
    public DynamicArray(E[] initialArray) {
        this.array = (E[]) new Object[initialArray.length];
        
        for(int i = 0; i < initialArray.length; i++) {
            this.array[i] = initialArray[i];
        }
        
        this.length = initialArray.length;
        this.capacity = initialArray.length;
    }


    private void expandArray() {
        this.capacity = this.capacity * EXPAND_RATIO;
        
        E[] oldArray = this.array;
        this.array = (E[]) new Object[this.capacity];
        
        for(int i = 0; i < this.length; i++) {
            this.array[i] = oldArray[i];
        }
    }
    
    private void shrinkArray() {
        this.capacity = this.capacity / EXPAND_RATIO ;
        
        E[] oldArray = this.array;
        this.array = (E[]) new Object[this.capacity];
        
        for(int i = 0; i < this.length; i++) {
            this.array[i] = oldArray[i];
        }
    }

    private boolean checkBounds(int index) {
    	if(0 <= index && index < this.length) {
		return true;
	}

	return false;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void add(E element) {
        this.length++;
        if(this.length >= this.capacity) {
            this.expandArray();
        }
        this.array[this.length - 1] = element;
    }
    
    public E set(int index, E element) {
        if(checkBounds(index)) {
            E oldValue = this.array[index];
            this.array[index] = element;
            return oldValue;
        } else {
	    throw new IndexOutOfBoundsException("Index " + index + "out of bounds for length " + this.length);
	}
    }
    
    public void insert(int index, E element) {
        if(checkBounds(index)) {
	    this.add(this.array[this.length - 1]);
	    
	    for(int i = this.length - 2; i > index; i--) {
    		this.array[i] = this.array[i - 1];
	    }
	
            this.array[index] = element;
	} else {
	    throw new IndexOutOfBoundsException("Index " + index + "out of bounds for length " + this.length);
	}
        
    }
    
    public E get(int index) {
        if(checkBounds(index)) {
            return this.array[index];
        } else {
	    throw new IndexOutOfBoundsException("Index " + index + "out of bounds for length " + this.length);
	}
    }
    
    public int indexOf(E element) {
        for(int i = 0; i < this.length; i++) {
            if(this.get(i) == element) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean contains(E element) {
        return this.indexOf(element) != -1;
    }
    
    public void remove(int index) {
        for(int i = index; i <= this.length; i++) {
            this.array[i] = this.array[i+1];
        }
        
        this.length--;
        if(this.length * EXPAND_RATIO <= this.capacity) {
            this.shrinkArray();
        }
    }
    
    public void remove(E element) {
        int index = indexOf(element);
        for(int i = index; i <= this.length; i++) {
            this.array[i] = this.array[i+1];
        }
        
        this.length--;
        if(this.length * EXPAND_RATIO <= this.capacity) {
            this.shrinkArray();
        }
    }
    
    public E[] subarray(int fromIndex, int toIndex) {
        if(checkBounds(fromIndex)) {
	    throw new IndexOutOfBoundsException("Index " + fromIndex + "out of bounds for length " + this.length);
	}

	if(checkBounds(toIndex)) {
	    throw new IndexOutOfBoundsException("Index " + toIndex + "out of bounds for length " + this.length);
	}

	if(fromIndex > toIndex) {
	    throw new IllegalArgumentException("Endpoint indices are out of order");
	}

	E[] subarray = (E[]) new Object[toIndex - fromIndex + 1];
        for(int i = fromIndex; i <= toIndex; i++) {
            subarray[i - fromIndex] = this.array[i];
        }
        
        return subarray;
    }
    
    public void clear() {
        this.array = (E[]) new Object[INITIAL_SIZE];
        
        this.length = 0;
        this.capacity = 8;
    }
    
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[");
        for(int i = 0; i < this.length - 1; i++) {
            text.append(this.array[i].toString());
            text.append(", ");
        }
        text.append(this.array[this.length - 1].toString());
        text.append("]");
        
        return text.toString();
    }
    
    @Override
    public Iterator<E> iterator() {
	return new DynamicArrayIterator<E>(this, array);
    }
}
