package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList myStack = new ImmutableLinkedList();
    public Object peek(){
        return myStack.getLast();
    }
    public Object pop(){
        Object it = myStack.getLast();
        myStack.removeLast();
        return it;
    }
    public void pop(Object e){
        myStack.addLast(e);
    }
    public  String toString(){
        return myStack.toString();
    }

}
