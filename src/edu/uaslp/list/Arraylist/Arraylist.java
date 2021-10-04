package edu.uaslp.list.Arraylist;

import java.util.List;

public class Arraylist<T>{

    private static final  int INITIAL_SIZE = 2;
        private Object[] array;
        private int nextValid;


        public Arraylist(){
            array = new Object [INITIAL_SIZE];
        }

        public void add(T data) {
            if(nextValid >= array.length) {
                increaseArrayCapacity();
            }

            array[nextValid] = data;
            nextValid++;
        }

        public void delete(int index) {
            if (index < 0 || index >= nextValid) {
                return;
            }
            for (int i = index; i < nextValid - 1; i++) {
                array[i] = array[i + 1];
            }
            nextValid--;
        }

        public void insert(T data, int index) {
            if (index < 0 || index > nextValid) {
                return;
            }
            if (nextValid >= array.length) {
                increaseArrayCapacity();
            }
            for (int i = nextValid; i > index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = data;
            nextValid++;
        }

        public int getSize() {
            return nextValid;
        }

        public T getAt(int index) {
            if (index < 0 || index > nextValid) {
                return null;
            }
            return (T) array[index];
        }

        public void print() {
            for (int i = 0; i < nextValid; i++) {
                System.out.println(array[i]);
            }
        }


        private void increaseArrayCapacity() {
            Object[] newArray = new Object[array.length * 2];

            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    /*
    private Node<G> head;
    private Node<G> tail;
    private int size;

    public void add(G data){
        Node<G> node = new Node<>(data);
        node.previous = tail;

        if(tail != null){
            tail.next = node;
        }

        if (head == null){
            head = node;
        }

        tail = node;
        size++;
    }

    public G get (int index){
        Node<G> currentNode = head;
        int currentIndex = 0;

        while (currentIndex < index){
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode.data;
    }

    public void delete (int index){
        Node<G> currentNode = head;
        int currentIndex = 0;

        if (index < 0 || index >= size){
            return;
        }
        size--;

        if (size == 0){
            head = null;
            tail = null;
            return;
        }

        if (index == size){
            tail = tail.previous;
            tail.next = null;
        }

        if(index == 0){
            head = head.next;
            head.previous = null;
        }

        if (index > 0 && index < size){
            while (currentIndex < index){
                currentNode = currentNode.next;
                currentIndex++;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
    }

    public int getSize(){
        return size;
    }


}*/
