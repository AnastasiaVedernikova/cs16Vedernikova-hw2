package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.util.Objects;

public class Queue {
    private ImmutableLinkedList myList = new ImmutableLinkedList();

    public Object peek(){

        return myList.getFirst();
    }
    public Object dequeue(){
        Object it = myList.getFirst();
        myList = myList.removeFirst();
        return it;
    }
    public void enqueue(Object e){
        myList = myList.addLast(e);
    }
    public String toString(){
        return myList.toString();
    }
}
