package edu.uaslp.list;

public interface List<T> {

    void add(T dato);

    int getSize();

    T getAt(int index);

    void delete(int index);

    Iterator<T> getIterator();

    void insert(T data, int index);

    void print();


}
