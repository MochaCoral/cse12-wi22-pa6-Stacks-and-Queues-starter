/**
 * TODO: Add your file header
 * Name:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * 
 * This file contains a MyQueue class, which is an implementation for the Queue
 * ADT based on MyDeque. Elements can be added/removed from the queue in a FIFO
 * ordering.
 */

/**
 * This class implements the Queue ADT using a MyDeque instance variable called
 * theStack.
 */
public class MyQueue<E> implements QueueInterface<E> {
    MyDeque<E> theQueue;

    /**
     * Constructor to create new MyQueue that holds a MyDeque.
     * 
     * @param capacity The max amount of elements this data structure can hold.
     */
    public MyQueue(int capacity) {
        this.theQueue = new MyDeque<E>(capacity);
    }

    /**
     * Checks whether or not the queue is empty.
     * 
     * @return True if there are no elements in the queue, false otherwise.
     */
    @Override
    public boolean empty() {
        if(this.theQueue.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Adds the specified element to the tail of this MyQueue.
     * 
     * @param element the element to add to the queue
     */
    @Override
    public void enqueue(E element) {
        this.theQueue.addFirst(element);
    }

    /**
     * Removes the element at the head of this MyQueue.
     * Returns the element removed, or null if there was no such
     * element.
     * 
     * @return the element removed, or null if the size was zero.
     */
    @Override
    public E dequeue() {
        return this.theQueue.removeLast();
    }

    /**
     * Returns the element at the head of this MyQueue,
     * or null if there was no such element.
     * 
     * @return the element at the head, or null if the size was zero.
     */
    @Override
    public E peek() {
        return this.theQueue.peekLast();
    }

    /**
     * Returns the number of elements in this queue.
     * 
     * @return the number of elements in the queue
     */
    public int size() {
        return this.theQueue.size();
    }

}
