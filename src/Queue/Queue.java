package Queue;
import Linked_List.*;

/**
 * basic queue class
 * @author PascalArlaan
 */
public class Queue<T> extends Linked_List<T>{

    
    private Object[] obj;
    private int size;
    private int bound;
    private boolean bounded;
    
    /**
     * Constructs an unbounded Queue Object
     */
    public Queue(){
        super();
        bounded = false;
    }  
    
    /**
     * Constructs a bounded Queue object of size <b>bound</b>
     * @param bound - the maximum number of elements in the structure
     */
    public Queue(int bound){
        super();
        this.bound = bound;
        bounded = true;
    }
    
    /**
     * Peeks at the first element in the Queue
     * @return the first element in the Queue
     */
    public T element(){
        return super.peek();
    }
    
    /**
     * Removes and returns the first element in the Queue
     * @return The first element in the Queue
     */
    public T poll(){
        return super.pop();
    }
    
    /**
     * Removes and returns the first element in the Queue - equivalent to poll()
     * @return the first element in the Queue
     */
    public T remove(){
        return super.pop();
    }
    
    /**
     * Places the element <b>T</b> in the Queue, and if bounded, then throws 
     * RuntimeException if conditions for addition are not met
     * @param t  the object to add to enqueue
     * @throws RuntimeException
     */
    public void add(T t){
        /*Checks if there is a bound And if it has been breached*/
        if(!bounded || (bounded && (size() < bound)))
            super.pushEnd(t);
        else 
            throw new RuntimeException("capacity already reached");

    }
    
    
    /**
     * Safe add, returning true if the enqueuing was successful
     * @return true if enqueuing was successful
     * @param t the object to enqueue
     */
    public boolean offer(T t){
        /*Checks if there is a bound and if it has been breached*/
        if(!bounded || (bounded && (size() < bound))){
            super.pushEnd(t);
            return true;
        }
        else 
            return false;

    }
  
}
