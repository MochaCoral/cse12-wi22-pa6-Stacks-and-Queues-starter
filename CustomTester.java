/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    /**
     * Helper method to initialize all instance variables of MyDeque
     * @param deque The deque to initialize
     * @param data The data array
     * @param size The value for size
     * @param front The value for front
     * @param rear The value for rear
     */
    static void initDeque(MyDeque<String> deque, Object[] data, int size, 
            int front, int rear) {
        deque.data = data;
        deque.size = size;
        deque.front = front;
        deque.rear = rear;
    }
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when initialized with a negative number 
     */
    @Test
    public void testMyDequeConstructor() {
        boolean exceptionThrown = false;
        try {
            MyDeque<Boolean> badDeque = new MyDeque<Boolean>(-4);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Illegal Argument Exception should be thrown", 
            exceptionThrown);
    }

    /**
     * Test the expandCapacity method when initial capacity is 0
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<String> emptyDeque = new MyDeque<String>(0);
        emptyDeque.expandCapacity();
        assertEquals("emptyDeque should be initialized to default capacity", 
            10, emptyDeque.data.length);
        assertEquals("size should remain the same", 0, emptyDeque.size());
    }

    /**
     * Test the addFirst method when deque is of initial capacity
     * of 0
     */
    @Test
    public void testAddFirst() {
        MyDeque<String> emptyDeque = new MyDeque<String>(0);
        emptyDeque.addFirst("Arceus");
        assertEquals("emptyDeque should have been initialized",
            10, emptyDeque.data.length);
        assertEquals("size should be 1", 1,
            emptyDeque.size());
        assertEquals("front should be 'Arceus'",
            "Arceus", emptyDeque.peekFirst());
    }

    /**
     * Test the addLast method when element is null
     */
    @Test
    public void testAddLast() {
        MyDeque<Integer> defaultDeque = new MyDeque<Integer>(10);
        boolean exceptionThrown = false;
        try {
            defaultDeque.addLast(null);
        }
        catch (NullPointerException e) {
            exceptionThrown = true;
        }
        assertTrue("Null Pointer Exception should have been thrown",
            exceptionThrown);
    }

    /**
     * Test the removeFirst method when deque is empty
     */
    @Test
    public void testRemoveFirst() {
        String removed;
        MyDeque<String> emptyDeque = new MyDeque<String>(0);
        removed = emptyDeque.removeFirst();
        assertEquals("removeFirst should return null", null, removed);

    }

    /**
     * Test the removeLast method when final element is removed
     */
    @Test
    public void testRemoveLast() {
        String removed;
        MyDeque<String> defaultDeque = new MyDeque<String>(5);
        String[] orig = {"Rayquaza", null, null, null, null};
        initDeque(defaultDeque, orig, 1, 0, 0);

        removed = defaultDeque.removeLast();

        assertEquals("removed should be 'Rayquaza'", "Rayquaza", removed);
        assertEquals("front should remain unchanged", 0, defaultDeque.front);
        assertEquals("rear should remain unchanged", 0, defaultDeque.rear);

    }

    /**
     * Test the peekFirst method when deque is empty
     */
    @Test
    public void testPeekFirst(){
        String peeked;
        MyDeque<String> emptyDeque = new MyDeque<String>(0);
        
        peeked = emptyDeque.peekFirst();

        assertEquals("peeked should be null", null, peeked);

    }

    /**
     * Test the peekLast method when deque is at capacity
     */
    @Test
    public void testPeekLast(){
        String peeked;
        MyDeque<String> fourDeque = new MyDeque<String>(4);
        String[] orig = {"Virizion", "Terrakion", "Coballion", "Keldeo"};
        initDeque(fourDeque, orig, 4, 0, 3);

        peeked = fourDeque.peekLast();

        assertEquals("peeked should be 'Keldeo", "Keldeo", peeked);
        assertEquals("deque should remain the same capacity", 
            4, fourDeque.data.length);
        

    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when empty() is called on a stack of size 10
     */
    @Test
    public void testMyStack(){
        MyStack<String> fiveStack = new MyStack<String>(5);
        String[] orig = {"unown", "unown", "unown", "unown", "unown"};
        initDeque(fiveStack.theStack, orig, 5, 0, 4);

        assertFalse("empty() should return false", fiveStack.empty());
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue enqueuing and dequeuing when queue is full
     */
    @Test
    public void testMyQueue(){
        String eol;
        MyQueue<String> fiveQueue = new MyQueue<String>(5);
        String[] orig = {"unown1", "unown2", "unown3", "unown4", "unown5"};
        initDeque(fiveQueue.theQueue, orig, 5, 0, 4);

        fiveQueue.enqueue("unown6");
        eol = fiveQueue.dequeue();

        assertEquals("queue should be size 5", 
            5, fiveQueue.size());
        assertEquals("capacity should be 10",
            10, fiveQueue.theQueue.data.length);
        assertEquals("top should be 'unown4'", "unown4", fiveQueue.peek());
    }
}
