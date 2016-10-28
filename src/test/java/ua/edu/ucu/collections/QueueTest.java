package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testPeek() {
        Queue queue = new Queue();
        queue.enqueue(6);
        queue.enqueue(5);
        Object actual = queue.peek();
        Object expected = 6;
        assertEquals(expected,actual);
    }
    @Test
    public void testDequeue() {
        Queue queue = new Queue();
        queue.enqueue(6);
        queue.enqueue(5);
        queue.dequeue();
        String actual = queue.toString();
        String expected = " 5, ";
        assertEquals(expected,actual);
    }
    @Test
    public void testEnqueue() {
        Queue queue = new Queue();
        queue.enqueue(6);
        queue.enqueue(5);
        String actual = queue.toString();
        String expected = " 6,5, ";
        assertEquals(expected,actual);
    }


    
}
