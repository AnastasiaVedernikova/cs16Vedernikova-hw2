package ua.edu.ucu.collections.immutable;

/**
 * Created by cs.ucu.edu.ua on 27.10.2016.
 */

class Node {
    final private Object data;
    private Node next;

    public Node(Object data){
        this.data = data;
    }
    public Node(Object data, Node node){
        this.data = data;
        this.next = node;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node clone() {
        return new Node(data);
    }
}
