package Linked_List;

/**
 *
 * @author PascalArlaan
 */
public class Linked_List<T> {

    
    private class Node<T>{
    
        public Node next;
        public Node last;
        public T obj;
        
        Node(){
            next = null;
            last = null;
            obj = null;
        }
        
        public boolean equals(Node<T> node){
            return obj.equals((node.obj));
        }
        
            
    }
    
    private Node<T> front;
    private Node<T> end;
    private int size;
    
    public Linked_List()
    {
        front = new Node<>();
        end = new Node<>();
        front.next = end;
        front.last = null;
        
        end.last = front;
        end.next = null;
        size = 0;
    }
    
    /**
     @param obj Puts the object at the front of the Linked List
     */
    public void push(T obj)
    {
        Node<T> newNode = new Node<>(); /*Create new Node object*/
        newNode.obj = obj; /*Set new Node's payload*/
        
        /*Connect the new Node to the front */
        newNode.last = front; 
        newNode.next = front.next;
        
        /*Insert into linked list */
        front.next.last = newNode; 
        front.next = newNode;
        
        size++;
        
    }
   
    /**
     @param obj Puts the object at the end of the Linked List
     */
    public void pushEnd(T obj)
    {
        Node<T> newNode = new Node<>(); /*Create new Node object*/
        newNode.obj = obj; /*Set new Node's payload*/
        
        /*Connect the new Node to the end */
        newNode.last = end.last; 
        newNode.next = end;
        
        /*Insert into linked list */
        end.last.next = newNode; 
        end.last = newNode;
        
        size++;
        
    }
    
    
    /**
     * Removes the first object from the front of the Linked List
     * @return The object at the front of the Linked List
     */
    public T pop(){
        
        if(size() <= 0)
            throw new RuntimeException("Index " + size() + " is out of bounds.");
        
        T obj = (T)front.next.obj;

        /*Remove the first Node*/
        front.next.next.last = front;
        front.next = front.next.next;
        size--;
        
        return obj;
    }
    
    
     /**
     * Removes the first object from the front of the Linked List
     * @return The object at the front of the Linked List
     */
    public T popEnd(){
        
        if(size() <= 0)
            throw new RuntimeException("Index " + size() + " is out of bounds.");
        
        T obj = (T)end.last.obj;

        /*Remove the first Node*/
        end.last.last.next = end;
        end.last = end.last.last;
        size--;
        
        return obj;
    } 
    
    /**
     * Look at the first object on the Linked List
     * @return the object held in the first place in the linked list
     */
    public T peek(){
        
        if(size() <= 0)
           throw new RuntimeException("LinkedList empty"); 
        
        return (T)front.next.obj;
    }
    
    /**
     * Look at the last object on the Linked List
     * @return the object held in the last place in the linked list
     */
    public T peekEnd(){
        
        if(size() <= 0)
           throw new RuntimeException("LinkedList empty"); 
        
        return (T)end.last.obj;
    }    
    
    /**
     * Adds an item to the Linked List at a certain index
     * @param index the index into which the object <b>obj</b> should be placed
     * @param obj the object to place in index <b>index</b>
     */
    public void add(int index, T obj)
    {
        /*Invalid input index*/
        if(index < 0)
            throw new RuntimeException("Index " + index + " is out of bounds.");
    
        /*Special case where add() == push()*/
        if(index == 0)
            push(obj);
        
        int size = size();
        
        /*If the insertion index is greater than the size, add enough nodes*/
        if(index > size - 1){
           
            /*push size - index - 1 nodes to make up for potential overshot*/
            int i = index - size;
            while(i-- > 0)
                pushEnd(null);
           
            pushEnd(obj);
            
        }
        else{
           
            Node<T> nextNode = front;
            int i = 1;
            while(i++ < index)
                nextNode = nextNode.next;

            Node<T> newNode = new Node<>();
            newNode.obj = obj;
            
            /*Insert the new Node*/
            nextNode.next.last = newNode;
            nextNode.next = newNode;
        
        }
        
        size++;
       
        
    }
    
    
    /**
     * Get the object in position <i>index</i>
     * @param index the index of the object to get
     * @return the object at position <b>index</b>
     */
    public T get(int index){
        
        if(index >= size())
            throw new RuntimeException("Index " + index + " is out of bounds.");

        Node<T> currNode = front.next;
        int i = 0;
        while(i++ < index)
            currNode = currNode.next;
        
        return currNode.obj;
        
    }
        /**
     * remove and return the object in position <i>index</i>
     * @param index the index of the object to remove
     * @return the object at position <b>index</b>
     */
    public T remove(int index){
        
        if(index >= size())
            throw new RuntimeException("Index " + index + " is out of bounds.");

        Node<T> currNode = front.next;
        int i = 0;
        while(i++ < index)
            currNode = currNode.next;
       
        currNode.last.next = currNode.next;
        currNode.next.last = currNode.last;
        
        return currNode.obj;
        
    }
    
    
    /**
     * Gets the number of objects in the Linked List
     *@return The number of objects in the Linked List
     */
    public int size(){
        
        return size;
    }
    
  
    public boolean equals(Linked_List<T> list){
        
        if(size() != list.size())
            return false;
        
        Node nodeA = front.next;
        Node nodeB = list.front.next;
        
        while(nodeA.next != null){
            if(!nodeA.equals(nodeB))
                return false;
       
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        return true;
    }
    
    /**
     * Convert the Linked List to an array
     * @return Array containing the objects from the LinkedList
     */
    public T[] toArray(){
        
        Object[] array = new Object[size()];
        System.out.println("size: " + size());
        Node<T> node = front.next;
        int i = 0;
        while(node.next != null){
            array[i++] = node.obj;
            node = node.next;
        }
        
        return (T[])array;
    }
    
    
    
    @Override
    public String toString(){
        
        if(size() == 0)
            return "[]";
        
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        
        Node<T> currNode = front.next;
        while(currNode.next != null){
            
            sb.append(currNode.obj);
            sb.append(',');
            currNode = currNode.next;
        }
        sb.delete(sb.length()-1, sb.length());
        sb.append(']');
        return sb.toString();
    }
    
    
}
