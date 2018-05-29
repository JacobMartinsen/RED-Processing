/*
 * Contains the testing class for the RED processing function of the RED overlay
 * of the Queue class
 */
package Testing;
import RED_Implementation.RED_Queue;

/**
 *
 * @author PascalArlaan
 */
public class TestingClass {
    
    interface penso{
        void println(String s);
    }
    
    
    public static void main(String[] argv){
        
       RED_Queue<Integer> redQueue = new RED_Queue(100, 60, 0.05);
       
       for(int x = 0; x < 1000; x++)
           redQueue.enqueue(x);
       
       for(int x = 0; x < 50; x++)
           System.out.println(redQueue.dequeue());
       
       for(int x = 1000; x < 2000; x++ )
           redQueue.enqueue(x);
       
       System.out.println(redQueue);
       System.out.println(redQueue.size());
       
    }
    
}
