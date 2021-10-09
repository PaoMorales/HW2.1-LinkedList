package edu.uaslp.list.Arraylist;

import edu.uaslp.list.Iterator;

public class ArraylistIterator<T> implements Iterator<T> {
    private int currentIndex = 0;
    private Arraylist<T> array;

    ArraylistIterator(Arraylist<T> array){
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.getSize();
    }

    @Override
    public T next() {
        return array.getAt(currentIndex++);
    }
}
