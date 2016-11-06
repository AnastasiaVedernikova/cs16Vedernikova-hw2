package ua.edu.ucu.collections.immutable;



import java.util.InputMismatchException;

public class ImmutableLinkedList implements ImmutableList {
    private final Node head;
    private int size = 0;

    public ImmutableLinkedList() {
        head = new Node(null);
    }
    private ImmutableLinkedList(Node Head){
        this.head = Head;
        Node current = this.head;
        while (current.getNext() != null){
            current = current.getNext();
            size +=1;
        }

    }

    public ImmutableLinkedList addFirst(Object e) {
        Node newHead = this.head.clone();
        if (isEmpty()) {
            newHead.setNext(new Node(e));
        } else {
            System.out.println("List is not empty");
        }
        return new ImmutableLinkedList(newHead);
    }

    public ImmutableLinkedList addLast(Object e) {
        Node newHead = this.head.clone();
        Node newCurrent = newHead;//1
        Node current = this.head;
        if (this.head.getNext() != null) {
            while (current.getNext() != null) {
                Node n = current.getNext().clone();
                newCurrent.setNext(n);
                newCurrent = n;
                current = current.getNext();
            }
            newCurrent.setNext(new Node(e));
        } else {
            newHead.setNext(new Node(e));
        }
        return new ImmutableLinkedList(newHead);
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
            Node current = this.head.getNext();
            while (current.getNext()!= null){
                current = current.getNext();
            }
            Node last = current.clone();
            return last.getData();
        }
        return "";
    }

    public ImmutableLinkedList removeLast() {
        Node newHead = this.head.clone();
        Node newCurrent = newHead;
        Node current = this.head;
        if (!isEmpty()){
            while (current.getNext().getNext()!=null){
                Node n = current.getNext().clone();
                newCurrent.setNext(n);
                newCurrent = n;
                current = current.getNext();
            }
        }
        return new ImmutableLinkedList(newHead);
    }

    public ImmutableLinkedList removeFirst() {
        Node newHead = this.head.clone();
        if (!isEmpty() && size>1) {
            Node newFirst = this.head.getNext().getNext().clone();
            newHead.setNext(newFirst);
            Node NotCloneFirst = this.head.getNext().getNext();
            while (NotCloneFirst.getNext()!= null){
                NotCloneFirst = NotCloneFirst.getNext();
                Node n  = NotCloneFirst.clone();
                newFirst.setNext(n);
                newFirst = n;
            }
        } else {
            System.out.println("List is empty");
        }
        return new ImmutableLinkedList(newHead);

    }

    @Override
    public String toString() {
        Node current = this.head.getNext();//1
        String output = " ";
        while (current != null) {
            output += current.getData() + ",";
            current = current.getNext();
        }
        return output + " ";
    }///implements of interface

    public ImmutableList add(Object e) {
        Node newHead = this.head.clone();
        Node newCurrent = newHead;//1
        Node current = this.head;
        if (this.head.getNext() != null) {
            while (current.getNext() != null) {
                Node n = current.getNext().clone();
                newCurrent.setNext(n);
                newCurrent = n;
                current = current.getNext();
            }
            newCurrent.setNext(new Node(e));
        } else {
            newHead.setNext(new Node(e));
        }
        return new ImmutableLinkedList(newHead);
    }

    public ImmutableList add(int index, Object e) {//не replace
        Node Index = new Node(e);
        Node NewHead = this.head.clone();
        Node newCurrent = this.head.getNext().clone();
        Node current = this.head.getNext();
        NewHead.setNext(newCurrent);
        if (!isEmpty() && index <= size && index > 0) {
            int i = 0;
            while (i < index - 1) {
                Node n = current.getNext();
                Node newN = current.getNext().clone();
                newCurrent.setNext(newN);
                newCurrent = newN;
                current = n;
                i += 1;
            }
            newCurrent.setNext(Index);
            if (index < size) {
                current = current.getNext();
                newCurrent = current.clone();
                Index.setNext(newCurrent);
                while (current.getNext() != null) {
                    Node n = current.getNext();
                    Node newN = current.getNext().clone();
                    newCurrent.setNext(newN);
                    newCurrent = newN;
                    current = n;
                }
            }
        }else if (index == 0){
            NewHead.setNext(Index);
            if (current!=null){
                Index.setNext(newCurrent);
            }
            while (current.getNext()!= null){
                Node n = current.getNext();
                Node newN = current.getNext().clone();
                newCurrent.setNext(newN);
                current = n;
                newCurrent = newN;
            }
        } else {
            throw new InputMismatchException("index out of range");
        }
        return new ImmutableLinkedList(NewHead);
    }

    public ImmutableList addAll(Object[] c) {

            Node newHead = this.head.clone();
            Node newCurrent = newHead;//1
            Node current = this.head;
            if (this.head.getNext() != null) {
                while (current.getNext() != null) {
                    Node n = current.getNext().clone();
                    newCurrent.setNext(n);
                    newCurrent = n;
                    current = current.getNext();
                }
                for (Object i:c){
                    Node n = new Node(i);
                    newCurrent.setNext(n);
                    newCurrent = n;
                }
            } else {
                newCurrent = newHead;
                for (Object i:c) {
                    Node n = new Node(i);
                    newCurrent.setNext(n);
                    newCurrent = n;
                }
        }
        return new ImmutableLinkedList(newHead);
    }

    public ImmutableList addAll(int index, Object[] c) {
        Node NewHead = this.head.clone();
        Node newCurrent = this.head.getNext().clone();
        Node current = this.head.getNext();
        NewHead.setNext(newCurrent);
        if (!isEmpty() && index <= size && index > 0) {
            if (!isEmpty() && index <= size && index > 0) {
                int i = 0;
                while (i < index - 1) {
                    Node n = current.getNext();
                    Node newN = current.getNext().clone();
                    newCurrent.setNext(newN);
                    newCurrent = newN;
                    current = n;
                    i += 1;
                }
                Node before = newCurrent;
                for (Object l : c) {
                    Node n = new Node(l);
                    before.setNext(n);
                    before = n;
                }

                if (index < size) {
                    current = current.getNext();
                    newCurrent = current.clone();
                    before.setNext(newCurrent);
                    while (current.getNext() != null) {
                        Node n = current.getNext();
                        Node newN = current.getNext().clone();
                        newCurrent.setNext(newN);
                        newCurrent = newN;
                        current = n;
                    }
                }

            }
        }else if (!isEmpty() && index == 0){
            Node n = NewHead;
            for (Object l:c){
                Node newN = new Node(l);
                n.setNext(newN);
                n = newN;
            }
            n.setNext(newCurrent);
            while (current.getNext()!= null){
                Node k = current.getNext();
                Node newK = current.getNext().clone();
                newCurrent.setNext(newK);
                current = k;
                newCurrent = newK;
            }
        } else {
            throw new InputMismatchException("index out of range");
        }
        return new ImmutableLinkedList(NewHead);
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

        Node NewHead = this.head.clone();
        Node newCurrent = this.head.getNext().clone();//1
        Node current = this.head.getNext();
        NewHead.setNext(newCurrent);
        if (!isEmpty() && index < size-1 && index > 0) {
            int i = 0;
            while (i < index - 1) {
                Node n = current.getNext();
                Node newN = current.getNext().clone();
                newCurrent.setNext(newN);
                newCurrent = newN;
                current = n;
                i += 1;
            }
            System.out.println(current.getData());
            current = current.getNext().getNext();
            Node NodePast = current.clone();
            newCurrent.setNext(NodePast);

            if (index < size-2) {
                current = current.getNext();
                newCurrent = current.clone();
                NodePast.setNext(newCurrent);
                while (current.getNext() != null) {
                    Node n = current.getNext();
                    Node newN = current.getNext().clone();
                    newCurrent.setNext(newN);
                    newCurrent = newN;
                    current = n;
                }
            }
        }else if (index == 0) {
                current = current.getNext();
                newCurrent = current.clone();
                NewHead.setNext(newCurrent);
                while (current.getNext()!=null){
                    current = current.getNext();
                    Node n  = current.clone();
                    newCurrent.setNext(n);
                    newCurrent = n;

                }


        } else if(index == size-1){
            while (current.getNext().getNext()!= null) {
                Node n = current.getNext();
                Node newN = current.getNext().clone();
                newCurrent.setNext(newN);
                newCurrent = newN;
                current = n;
            }

        }
        else {
            throw new InputMismatchException("index out of range");
        }

        return new ImmutableLinkedList(NewHead);

    }

    public ImmutableList set(int index, Object e) {

        Node Index = new Node(e);
        Node NewHead = this.head.clone();
        Node newCurrent = this.head.getNext().clone();
        Node current = this.head.getNext();
        NewHead.setNext(newCurrent);
        if (!isEmpty() && index < size-1 && index > 0) {

            int i = 0;
            while (i < index - 1) {
                Node n = current.getNext();
                Node newN = current.getNext().clone();
                newCurrent.setNext(newN);
                newCurrent = newN;
                current = n;
                i += 1;
            }

            newCurrent.setNext(Index);
            if (index < size) {
                current = current.getNext().getNext();
                newCurrent = current.clone();
                Index.setNext(newCurrent);
                while (current.getNext() != null) {
                    Node n = current.getNext();
                    Node newN = current.getNext().clone();
                    newCurrent.setNext(newN);
                    newCurrent = newN;
                    current = n;
                }
            }
        }else if (index == 0) {
            NewHead.setNext(Index);
            if (current != null) {
                Index.setNext(newCurrent);
            }
            while (current.getNext() != null) {
                Node n = current.getNext();
                Node newN = current.getNext().clone();
                newCurrent.setNext(newN);
                current = n;
                newCurrent = newN;
            }
        }else if(index == size-1){
            while (current.getNext().getNext()!= null){
                Node n = current.getNext();
                Node newN = current.getNext().clone();
                newCurrent.setNext(newN);
                newCurrent = newN;
                current = n;
            }
            newCurrent.setNext(Index);
        }else{
            throw new InputMismatchException("index out of range");
        }


        return new ImmutableLinkedList(NewHead);
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
        size = 0;
        return new ImmutableLinkedList();
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


