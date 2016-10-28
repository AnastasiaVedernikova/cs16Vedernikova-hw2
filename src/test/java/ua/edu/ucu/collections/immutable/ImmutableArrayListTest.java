package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.InputMismatchException;
import java.util.Objects;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testGet() {
        ImmutableArrayList array = new ImmutableArrayList();
        Object[] pop = new Object[]{1, 2, 3, 4, 5, 6};
        array.addAll(pop);
        Object actual = array.get(2);
        Object expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testAdd() {
        ImmutableArrayList array = new ImmutableArrayList();
        array.add(5);
        String actual = array.toString();
        String expected = "[5]";
        assertEquals(expected, actual);
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList array = new ImmutableArrayList();
        Object[] pop = new Object[]{1, 2, 3, 4, 5, 6};
        array.addAll(pop);
        String actual = array.toString();
        String expected = "[1, 2, 3, 4, 5, 6]";
        assertEquals(expected, actual);
    }

    @Test
    public void testSize() {
        ImmutableArrayList array = new ImmutableArrayList();
        Object[] pop = new Object[]{1, 2, 3, 4, 5, 6};
        array.addAll(pop);
        Object actual = array.size();
        Object expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        ImmutableArrayList array = new ImmutableArrayList();
        boolean actual = array.isEmpty();
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void testClear() {
        ImmutableArrayList array = new ImmutableArrayList();
        Object[] pop = new Object[]{1, 2, 3, 4, 5, 6};
        array.addAll(pop);
        array.clear();
        boolean actual = array.isEmpty();
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void testAddAllInd() {
        ImmutableArrayList array = new ImmutableArrayList();
        Object[] lst = new Object[]{11, 66};
        Object[] pop = new Object[]{1, 2, 3, 4, 5, 6};
        array.addAll(pop);
        array.addAll(3, lst);
        String actual = array.toString();
        String expected = "[1, 2, 3, 11, 66, 4, 5, 6]";
        assertEquals(actual, expected);

    }

    @Test
    public void testAddObInd() {
        ImmutableArrayList array = new ImmutableArrayList();
        Object[] pop = new Object[]{1, 2, 3, 4, 5, 6};
        array.addAll(pop);
        array.add(3, 77);
        String actual = array.toString();
        String expected = "[1, 2, 3, 77, 4, 5, 6]";
        assertEquals(actual, expected);

    }

    @Test
    public void testSet() {
        ImmutableArrayList array = new ImmutableArrayList();
        Object[] pop = new Object[]{1, 2, 3, 4, 5, 6};
        array.addAll(pop);
        array.set(3, 77);
        String actual = array.toString();
        String expected = "[1, 2, 3, 77, 5, 6]";
        assertEquals(actual, expected);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList array = new ImmutableArrayList();
        Object[] pop = new Object[]{1, 2, 3, 4, 5, 6};
        array.addAll(pop);
        array.remove(3);
        String actual = array.toString();
        String expected = "[1, 2, 3, 5, 6]";
        assertEquals(actual, expected);
    }

    @Test
    public void testIndexOf() {
        ImmutableArrayList array = new ImmutableArrayList();
        Object[] pop = new Object[]{1, 2, 3, 4, 5, 6};
        array.addAll(pop);
        Object actual = array.indexOf(3);
        Object expected = 2;
        assertEquals(actual, expected);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class) //         exception
    public void testGetExcep() {
        ImmutableArrayList array = new ImmutableArrayList();
        Object[] pop = new Object[]{1, 2, 3, 4, 5, 6};
        array.addAll(pop);
        array.get(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class) //         exception
    public void testRemoveExcep() {
        ImmutableArrayList array = new ImmutableArrayList();
        Object[] pop = new Object[]{1, 2, 3, 4, 5, 6};
        array.addAll(pop);
        array.remove(-1);

    }
}

