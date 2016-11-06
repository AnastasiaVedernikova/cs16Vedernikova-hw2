package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;
import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    @Test(expected = InputMismatchException.class) //         exception
    public void testAddAllExcep() {
        ImmutableLinkedList T = new ImmutableLinkedList();
        ImmutableList P = T.add(9);
        Object [] lst = new Object[]{1,2,3,4,5,6};
        System.out.println(P.addAll(3,lst));
    }
    @Test(expected = InputMismatchException.class) //         exception
    public void testAddExcep() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        ImmutableList O = List.addLast(2);
        O.add(3,3);
    }

    @Test(expected = InputMismatchException.class) //         exception
    public void testGetExcep() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        ImmutableList O = List.addLast(2);
        O.get(3);
    }
    @Test(expected = InputMismatchException.class) //         exception
    public void testRemoveExcep() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        ImmutableList O = List.addLast(2);
        O.remove(3);
    }
    @Test(expected = InputMismatchException.class) //         exception
    public void testSetExcep() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        ImmutableList O = List.addLast(2);
        O.set(3,3);
    }
    
    @Test
    public void testAddFirst() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        String expected = " 78, ";
        String actual = List.addFirst(78).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        List.addFirst(78);
        List.clear();
        Object expected = 0;
        Object actual = List.size();
        assertEquals(expected,actual);
    }
    @Test
    public void testAddLast(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        String expected = " 90, ";
        String actual = List.addLast(90).toString();
        assertEquals(expected,actual);

    }

    @Test
    public void testIsEmpty(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        ImmutableList O = List.addLast(4);
        O.addAll(lst);
        boolean expected = false;
        boolean actual = O.isEmpty();
        assertEquals(actual,expected);

    }
    @Test
    public void testGetFirst(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        ImmutableLinkedList A = List.addLast(2);
        ImmutableLinkedList B = A.addLast(0);
        Object expected = 2;
        Object actual = B.getFirst();
        assertEquals(expected,actual);

    }
    @Test
    public void testGetLast(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        ImmutableLinkedList A = List.addLast(2);
        ImmutableLinkedList B = A.addLast(0);
        Object expected = 0;
        Object actual = B.getLast();
        assertEquals(expected,actual);

    }
    @Test
    public void testRemoveLast(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        ImmutableLinkedList A = List.addFirst(90);
        ImmutableLinkedList B = A.addLast(92);
        Object expected = " 90, ";
        Object actual = B.removeLast().toString();
        assertEquals(expected,actual);

    }
    @Test
    public void testRemoveFirst(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        ImmutableLinkedList A = List.addFirst(90);
        ImmutableLinkedList B = A.addLast(92);
        Object expected = " 92, ";
        Object actual = B.removeFirst().toString();
        assertEquals(expected,actual);

    }
    @Test
    public void testAddOb(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        ImmutableList A = List.add("operation");
        Object expected = " operation, ";
        Object actual = A.toString();
        assertEquals(expected,actual);

    }
    @Test
    public void testAddObIn(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        ImmutableList A = List.addAll(lst);
        ImmutableList B = A.add(3, "operation");
        Object expected = " 1,2,3,operation,4,5,6, ";
        Object actual = B.toString();
        assertEquals(expected,actual);


    }
    @Test
    public void testAddAll(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        ImmutableList A = List.addAll(lst);
        Object expected = " 1,2,3,4,5,6, ";
        Object actual = A.toString();
        assertEquals(expected,actual);

    }
    @Test
    public void testAddAllIn(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        ImmutableList A  = List.addAll(lst);
        Object [] lst1 = new Object[]{44,55};
        ImmutableList B  = A.addAll(2,lst1);
        Object expected = " 1,2,44,55,3,4,5,6, ";
        Object actual = B.toString();
        assertEquals(expected,actual);

    }
    @Test
    public void testGetIn(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        ImmutableList A = List.addAll(lst);
        Object actual = A.get(3);
        Object expected = 4;
        assertEquals(expected,actual);

    }
    @Test
    public void testRemoveInd(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        ImmutableList A = List.addAll(lst);
        Object actual = A.remove(3).toString();
        Object expected = " 1,2,3,5,6, ";
        assertEquals(expected,actual);

    }
    @Test
    public void testSetIndOb(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        ImmutableList A = List.addAll(lst);
        Object actual = A.set(3,77).toString();
        Object expected = " 1,2,3,77,5,6, ";
        assertEquals(expected,actual);


    }
    @Test
    public void testIndexOf(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        ImmutableList A = List.addAll(lst);
        Object actual = A.indexOf(3);
        Object expected = 2;
        assertEquals(expected,actual);

    }
    @Test
    public void testSize(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        ImmutableList A = List.addAll(lst);
        Object actual = A.size();
        Object expected = 6;
        assertEquals(expected,actual);

    }
    @Test
    public void testToArray(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        ImmutableList A = List.addAll(lst);
        Object actual = Arrays.toString(A.toArray());
        Object expected = "[1, 2, 3, 4, 5, 6]";
        assertEquals(expected,actual);

    }
}

