package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;
import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    @Test(expected = InputMismatchException.class) //         exception
    public void testAddAllExcep() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(3,lst);
    }
    @Test(expected = InputMismatchException.class) //         exception
    public void testAddExcep() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        List.add(3,3);
    }

    @Test(expected = InputMismatchException.class) //         exception
    public void testGetExcep() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        List.get(3);
    }
    @Test(expected = InputMismatchException.class) //         exception
    public void testRemoveExcep() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        List.remove(3);
    }
    @Test(expected = InputMismatchException.class) //         exception
    public void testSetExcep() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        List.set(3,3);
    }
    
    @Test
    public void testAddFirst() {
        ImmutableLinkedList List = new ImmutableLinkedList();
        List.addFirst(78);
        String expected = " 78, ";
        String actual = List.toString();
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
        List.addLast(90);
        String expected = " 90, ";
        String actual = List.toString();
        assertEquals(expected,actual);

    }

    @Test
    public void testIsEmpty(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        boolean expected = false;
        boolean actual = List.isEmpty();
        assertEquals(actual,expected);

    }
    @Test
    public void testGetFirst(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object expected = 1;
        Object actual = List.getFirst();
        assertEquals(expected,actual);

    }
    @Test
    public void testGetLast(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object expected = 6;
        Object actual = List.getLast();
        assertEquals(expected,actual);

    }
    @Test
    public void testRemoveLast(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object expected = " 1,2,3,4,5, ";
        Object actual = List.removeLast().toString();
        assertEquals(expected,actual);

    }
    @Test
    public void testRemoveFirst(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object expected = " 2,3,4,5,6, ";
        Object actual = List.removeFirst().toString();
        assertEquals(expected,actual);

    }
    @Test
    public void testAddOb(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        List.add("operation");
        Object expected = " operation, ";
        Object actual = List.toString();
        assertEquals(expected,actual);

    }
    @Test
    public void testAddObIn(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        List.add(3, "operation");
        Object expected = " 1,2,3,operation,4,5,6, ";
        Object actual = List.toString();
        assertEquals(expected,actual);


    }
    @Test
    public void testAddAll(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object expected = " 1,2,3,4,5,6, ";
        Object actual = List.toString();
        assertEquals(expected,actual);

    }
    @Test
    public void testAddAllIn(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object [] lst1 = new Object[]{44,55};
        List.addAll(2,lst1);
        Object expected = " 1,2,44,55,3,4,5,6, ";
        Object actual = List.toString();
        assertEquals(expected,actual);

    }
    @Test
    public void testGetIn(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object actual = List.get(3);
        Object expected = 4;
        assertEquals(expected,actual);

    }
    @Test
    public void testRemoveInd(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object actual = List.remove(3).toString();
        Object expected = " 1,2,3,5,6, ";
        assertEquals(expected,actual);

    }
    @Test
    public void testSetIndOb(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object actual = List.set(3,77).toString();
        Object expected = " 1,2,3,77,5,6, ";
        assertEquals(expected,actual);


    }
    @Test
    public void testIndexOf(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object actual = List.indexOf(3);
        Object expected = 2;
        assertEquals(expected,actual);

    }
    @Test
    public void testSize(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object actual = List.size();
        Object expected = 6;
        assertEquals(expected,actual);

    }
    @Test
    public void testToArray(){
        ImmutableLinkedList List = new ImmutableLinkedList();
        Object [] lst = new Object[]{1,2,3,4,5,6};
        List.addAll(lst);
        Object actual = Arrays.toString(List.toArray());
        Object expected = "[1, 2, 3, 4, 5, 6]";
        assertEquals(expected,actual);

    }
}

