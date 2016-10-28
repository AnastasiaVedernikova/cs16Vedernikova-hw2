package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testPeek() {
        Stack stack = new Stack();
        stack.pop(9);
        stack.pop(5);
        Object actual = stack.peek();;
        Object expected = 5;
        assertEquals(expected,actual);

    }

    @Test
    public void testPop() {
        Stack stack = new Stack();
        stack.pop(9);
        stack.pop(5);
        Object actual = stack.pop();;
        Object expected = 5;
        assertEquals(expected,actual);
    }

    @Test
    public void testPopObj() {
        Stack stack = new Stack();
        stack.pop(9);
        stack.pop(5);
        String actual = stack.toString();
        String expected = " 9,5, ";
        assertEquals(expected,actual);
    }
    
}
