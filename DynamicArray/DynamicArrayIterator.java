import java.util.Iterator;
import java.lang.UnsupportedOperationException;

public class DynamicArrayIterator<E> implements Iterator<E> {
    private Integer length;
    private Integer index;
    private E[] array; 	

    public DynamicArrayIterator(DynamicArray<E> dynamicArray, E[] arr) {
	this.length = dynamicArray.getLength();
	this.index = 0;
	this.array = arr;
    }

    @Override
    public boolean hasNext() {
	return length > index;
    }

    @Override
    public E next() {
	if(this.hasNext())
	    return array[index++];
    	return null;
    }
    
    @Override
    public void remove() {
	throw new UnsupportedOperationException();
    }
}
