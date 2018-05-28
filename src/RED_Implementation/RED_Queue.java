package RED_Implementation;
import Queue.Queue;
import java.util.Random;


/**
 *
 * @author PascalArlaan
 */
public class RED_Queue<T> extends Queue<T> {
    
    private double p;
    private int instantAdmitCapacity;
    private int capacity;
    private Random check;
    
    
   /**
    * Construct a RED_Queue object with a definite capacity, an instant
    * admission capacity, and a threshold probability for admission into the 
    * queue
    */
   public RED_Queue(int capacity, int instantAdmit, double p){
        super(capacity);
        this.p = p;
        this.capacity = capacity;
        this.instantAdmitCapacity = instantAdmit;
        check = new Random();
    }
    
   
   /**
    * Enqueue the object if it meets the requirements to enqueue
    * 
    * @param t the object to enqueue
    * @returns success of the enqueue operation: true if <b>t</b> the object
    * was enqueued; false otherwise
    */
    public boolean enqueue(T t){
     if(enqueue_check()){
        pushEnd(t);
        return true;
     }
     else
         return false;
    }
    
    
    public T dequeue(){
        return pop();
    }
    
    public static int count = 0;
      
    /**
     * Check if an object should be enqueued or not
     * 
     * Conditions for enqueueing: size has not reached capacity yet, and 
     * the probability threshold has been met to enqueue
     * 
     * @return true if the object should be enqueued
     */
    private boolean enqueue_check(){
        
        count++;
        int size = size();
        
        if(size < instantAdmitCapacity)
            return true;
        else if((size < capacity) && (check.nextDouble() < p))
                return true;
        else 
            return false;
        
        }
    
    
    
    
}
