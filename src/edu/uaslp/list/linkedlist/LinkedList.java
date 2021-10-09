package edu.uaslp.list.linkedlist;
import edu.uaslp.list.List;
import edu.uaslp.list.Iterator;

public class LinkedList<H> implements List<H>{
    private Node<H> head;
    private Node<H> tail;
    private int size;


    public void add(H dato){
        Node<H> node = new Node<>();
        node.data = dato;

        if(head == null){
            head = node;
        }

        node.previous = tail;

        if(tail != null){
            tail.next = node;
        }

        tail = node;
        size++;
    }

    public int getSize(){
        return size;
    }

    public H getAt(int index){
        int counter = 0;
        Node<H> it = head;

        while(counter < index && it != null){
            counter++;
            it = it.next;
        }
        return it == null ? null : it.data;
    }

    public void delete(int index){
        int counter = 0;
        Node<H> it = head;

        if(index < 0 || index >= size){
            return;
        }

        while(counter < index && it != null){
            it = it.next;
            counter++;
        }

        if(it.previous == null){
            head = it.next;
        } else{
            it.previous.next = it.next;
        }

        if(it.next == null){
            tail = it.previous;
        } else {
            it.next.previous = it.previous;
        }

        size--;
    }


    public void insert(H data, int index){
        int counter = 0;
        Node<H> it = head;

        if(index < 0 || index > size){
            return;
        }

        if(index == size){
            add(data);
            return;
        }

        while (counter < index && it != null){
            it = it.next;
            counter++;
        }

        Node<H> node = new Node();
        node.data = data;
        node.next = it;
        node.previous = it.previous;

        if(it.previous == null){
            head = node;
        } else {
            it.previous.next = node;
        }
        it.previous = node;
    }

    public void print(){
        Node<H> it = head;

        while(it != null){
            System.out.println(it.data);
            it = it.next;
        }
    }

    public Iterator<H> getIterator(){
        return new LinkedListIterator<>(head);
    }
}
