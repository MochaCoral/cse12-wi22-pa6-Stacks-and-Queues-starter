
public class MyDeque<E> implements DequeInterface<E>{
    static final int DEFAULT_CAPACITY = 10;
    static final int SCALING_FACTOR = 2;
    Object[] data;
    int size;
    int rear;
    int front;
    public MyDeque(int initialCapacity) throws IllegalArgumentException {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        data = new Object[initialCapacity];
        size = 0;
        rear = 0;
        front = 0;
    }

    /**
     * 
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * 
     */
    @Override
    public void expandCapacity() {
        if(this.data.length == 0) {
            data = new Object[DEFAULT_CAPACITY];
        }
        else {
            Object[] expandedData = new Object[this.data.length * SCALING_FACTOR];
            int idx = 0;
            if(front > rear) { //if deque is discontiguous
                for(int i = front; i < this.data.length - 1; i++) {
                    expandedData[idx] = data[i];
                    idx++;
                }
                for(int i = 0; i < rear; i++) {
                    expandedData[idx] = data[i];
                    idx++;
                }
            }
            else { //contiguous deque
                for(int i = front; idx < this.size(); i++) {
                    expandedData[idx] = data[i];
                    idx++;
                }
            }
            this.data = expandedData;
            this.front = 0;
            this.rear = this.size - 1;
        } 
    }

    /**
     * 
     */
    @Override
    public void addFirst(E element) throws NullPointerException {
        if(element == null) {
            throw new NullPointerException();
        }
        if(this.size() == this.data.length) {
            this.expandCapacity();
        }        
        if(this.front == 0 && this.size != 0) {
            this.front = this.data.length - 1;
        }
        else if(this.front != 0){
            this.front--;
        }
        data[this.front] = element;
        this.size++;
    
    }

    /**
     * 
     */
    @Override
    public void addLast(E element) throws NullPointerException{
        if(element == null) {
            throw new NullPointerException();
        }
        if(this.size() == this.data.length) {
            this.expandCapacity();
        }
        if(this.rear == this.data.length - 1
            && this.size != 0) 
        {
            this.rear = 0;
        }
        else if(this.rear != this.data.length - 1) {
            this.rear++;
        }
        data[this.rear] = element;
        this.size++;
        
    }
    
    /**
     * 
     */
    @SuppressWarnings("unchecked")
    @Override
    public E removeFirst() {
        E culled;
        if(this.size() == 0) {
            culled = null;
        }
        else {
            culled = (E) data[this.front];
            data[this.front] = null;
            if(size > 1) {
                this.front++;
            }
            this.size--;
        }
        return culled;
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    @Override
    public E removeLast() {
        E culled;
        if(this.size() == 0) {
            culled = null;
        }
        else {
            culled = (E) data[this.rear];
            data[this.rear] = null;
            if(size > 1) {
                this.rear--;
            }
            this.size--;
        }
        return culled;
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    @Override
    public E peekFirst() {
        if(this.size() == 0) {
            return null;
        }
        else {
            return (E) data[this.front];
        }
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    @Override
    public E peekLast() {
        if(size == 0) {
            return null;
        }
        else {
            return (E) data[this.rear];
        }
    }
}
