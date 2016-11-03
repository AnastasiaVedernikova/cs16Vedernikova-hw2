package ua.edu.ucu.collections.immutable;



import java.util.InputMismatchException;

public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node last;
    private int size = 0;

    public ImmutableLinkedList() {
        head = last = new Node(null);
    }
    private ImmutableLinkedList(Node Head){
        this.head = Head;

        Node current = head.getNext();
        if (current != null){
            size+=1;
        }
        while (current != null){
            current = current.getNext();
            size +=1;
        }
    }

    public void addEl(Object s) {
        last.setNext(new Node(s));
        last = last.getNext();
        size++;
    }

    public ImmutableLinkedList addFirst(Object e) {
        if (isEmpty()) {
            addEl(e);
        } else {
            System.out.println("List is not empty");
        }
        return new ImmutableLinkedList(head);
    }

    public ImmutableLinkedList addLast(Object e) {
        addEl(e);
        return new ImmutableLinkedList(head);
    }



    public boolean isEmpty() {
        if (size != 0) {
            return false;
        }
        return true;
    }

    public Object getFirst() {
        if (!isEmpty()) {
            return head.getNext().getData();
        }
        return "";
    }

    public Object getLast() {
        if (!isEmpty()) {
            return last.getData();
        }
        return "";
    }

    public ImmutableLinkedList removeLast() {
        if (!isEmpty() && size > 1) {
            Node current = head.getNext();
            Node beforeLast = new Node(null);
            while (current != null) {
                if (current.getNext() == last) {
                    beforeLast = current;
                }
                current = current.getNext();
            }
            last = beforeLast;
            last.setNext(null);
            size -= 1;
        } else if (size == 1) {
            head.setNext(null);

        } else {
            System.out.println("List is empty");
        }
        return new ImmutableLinkedList(head);
    }

    public ImmutableLinkedList removeFirst() {
        if (!isEmpty()) {
            head.setNext(head.getNext().getNext());
        } else {
            System.out.println("List is empty");
        }
        return new ImmutableLinkedList(head);

    }

    @Override
    public String toString() {
        Node current = head.getNext();
        String output = " ";
        while (current != null) {
            output += current.getData() + ",";
            current = current.getNext();
        }
        return output + " ";
    }///implements of interface

    public ImmutableList add(Object e) {
        addEl(e);
        return new ImmutableLinkedList(head);
    }

    public ImmutableList add(int index, Object e) {//не replace
        Node Index = new Node(e);
        if (!isEmpty() && index <= size && index > 0) {
            Node beforeInd = head.getNext();//1el
            for (int i = 1; i < index; i++) {
                beforeInd = beforeInd.getNext();
            }
            Index.setNext(beforeInd.getNext());
            beforeInd.setNext(Index);

        } else if (index == 0) {
            Index.setNext(head.getNext());
            head.setNext(Index);
        } else {
            throw new InputMismatchException("index out of range");
        }
        size++;
        return new ImmutableLinkedList(head);
    }

    public ImmutableList addAll(Object[] c) {
        for (Object i : c) {
            this.add(i);
        }
        return new ImmutableLinkedList(head);
    }

    public ImmutableList addAll(int index, Object[] c) {
        if (!isEmpty() && index <= size && index > 0) {
            Node beforeInd = head.getNext();//1el
            for (int i = 1; i < index; i++) {
                beforeInd = beforeInd.getNext();
            }
            Node beforeLast = beforeInd.getNext();
            for (Object i : c) {
                Node node = new Node(i);
                beforeInd.setNext(node);
                beforeInd = node;
                size++;
            }
            beforeInd.setNext(beforeLast);
        } else if (index == 0) {
            Node beforeInd = head;
            Node beforeLast = head.getNext();
            for (Object i : c) {
                Node node = new Node(i);
                beforeInd.setNext(node);
                beforeInd = node;
                size++;
            }
            beforeInd.setNext(beforeLast);
        } else {
            throw new InputMismatchException("index out of range");
        }
        return new ImmutableLinkedList(head);
    }

    public Object get(int index) {
        if (!isEmpty() && index <= size) {
            Node current = head.getNext();
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        } else {
            throw new InputMismatchException("index out of range");
        }
    }

    public ImmutableList remove(int index) {
        if (!isEmpty() && index <= size && index > 0) {
            Node current = head.getNext();
            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());

        } else if (index == 0) {
            head.setNext(head.getNext().getNext());
        } else {
            throw new InputMismatchException("index out of range");
        }
        size-=1;
        return new ImmutableLinkedList(head);

    }

    public ImmutableList set(int index, Object e) {
        if (!isEmpty() && index < size && index > 0) {
            Node current = head.getNext();
            for (int i = 1; i <= index; i++) {
                current = current.getNext();
            }
            current.setData(e);
        }else if(index == 0){
            head.getNext().setData(e);
        }else{
            throw new InputMismatchException("index out of range");
        }

        return new ImmutableLinkedList(head);
    }
    public int indexOf(Object e){
        if (isEmpty()){
            return -1;
        }
        int ind = 0;
        Node current = head.getNext();
        while (current != null && current.getData()!= e) {
            current = current.getNext();
            ind += 1;
        }
        if (ind != 0 || head.getNext().getData() == e){
            return ind;
        }else{
            return -1;
        }

    }
    public int size(){
        return size;
    }
    public  ImmutableList clear(){
        head = last = new Node(null);
        size = 0;
        return new ImmutableLinkedList(head);
    }
    public Object[] toArray(){
        Object[] arr = new Object[size];
        Node current = head.getNext();
        for (int i = 0; i < size;i++){
            arr[i] = current.getData();
            current = current.getNext();
        }
        return arr;
    }

}


