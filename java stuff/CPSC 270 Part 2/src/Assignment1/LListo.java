/**
       
  * @author ConnorRedmon
       
  * @version 10/7/15
       
  * @param
       
  */
       
 public class LListo implements Listo {
       
     private Link<Object> curr;
       
     private Link<Object> head;
       
     private Link<Object> tail;
      
     private int size;
      
 
      
     /**
      
      * creates an empty list
      
      */
      
     public LListo() {
      
         this.erase();
      
 
      
     }
      
 
      
     /**
      
      * Create empty list (ignore given size parameter).
      
      * 
      
      * @param size
      
      *            defines the number of elements in the list
      
      * 
      
      */
      
     public LListo(int size) {
      
         this();
      
     }
      
 
      
     /**
      
      * Determine if the list is empty.
      
      * 
      
      * @return true, if the list is empty; false, if not empty.
      
      */
      
     public boolean isEmpty() {
      
         boolean res = false;
      
         if (size == 0) {
      
             res = true;
      
         }
      
         else {
      
             res = false;
      
         }
      
         return res;
      
 
      
     }
      
 
      
     /**
      
      * Remove all elements from the list, so it is once again empty.
      
      */
      
     public void erase() {
      
         tail = new Link<Object>(null);
      
         curr = tail;
      
         head = new Link<Object>(tail);
      
         size = 0;
      
 
      
     }
      
 
      
     /**
      
      * Add the given parameter to this list AFTER the current location.
      
      * 
      
      * @param element
      
      *            element being added
      
      */
      
     public void add(java.lang.Object element) {
      
         if (tail == curr) { // New tail
      
             tail = curr.next();
      
             curr.setElement(element);
      
         }
      
         else {
      
             curr.setNext(new Link<Object>(element, curr.next())); // set element
      
                                                                   // after curr
      
             curr = curr.next(); // make curr.next current
      
         }
      
         size++; // increase the size of the linkedList
      
     }
      
 
      
     /**
      
      * Delete the element before the current element
      
      */
      
     public void delete() { // Could only figure out how to delete when list was
      
                            // empty.
      
         if (!this.isEmpty()) {
      
             if (curr.next() == tail) { // Nothing to Remove
      
                 this.erase();
      
                 size = 0;
      
             }
      
             else {
      
 
      
                 curr = head;
      
                 curr.setElement(curr.next().element()); // pull next element
      
                                                         // forward
      
                 curr.setNext(curr.next().next()); // point around unneeded link
      
                 size--; // decrement size
      
             }
      
         }
      
     }
      
 
      
     /**
         
      * Set the current position to the header of the list.
         
      */
         
     public void goToHead() {
         
         while (curr != head) { // Make sure curr doesn't = head
         
             curr = head; // set head to curr
         
         }
         
     }
         
 
         
     /**
         
      * Move the current position one step nearer the beginning of this list.
         
      * 
         
      * @return true if the current position was actually moved, false else
         
      */
         
     public boolean retreat() {
         
         if (this.isEmpty() || curr == head) { // if list isEmpty you cannot move
         
                                               // the position
         
             // closer and if current is at the top you can't move it anymore
         
             return false;
         
         }
         
         if (head.next() == curr) {
         
             curr = head;
         
             return true;
         
         }
         
         else {
         
             Link<Object> temp = head;
         
             while (temp.next() != curr) { // Moves down the list until found
         
                                           // previous element
         
                 temp = temp.next(); // set temp.next to temp
         
             }
         
             curr = temp; // moves curr closer
         
             return true;
         
         }
         
     }
         
 
         
     /**
         
      * Move the current position one step nearer the end of this list.
         
      * 
         
      * @return true if the current position was actually moved, false else
         
      */
         
     public boolean advance() {
         
         if (this.isEmpty() || curr.next() == tail) { // Cannot advance if empty
         
                                                      // and
         
             // can't if it's at end
         
             return false;        
         }
         
         else {
         
             curr = curr.next(); // Moves curr closer to end of list
         
             return true;
         
         }
         
     }
         
 
         
     /**
         
      * Return the number of elements in the list.
         
      * 
         
      * @return number of elements
         
      */
         
     public int numberOfElements() {
         
         return size;
         
     }
         
 
         
     /**
         
      * Return the current element. Throw an IllegalArgumentException if the list
         
      * is empty.
         
      * 
         
      * @return object at current position
         
      */
         
     public java.lang.Object element() {
         
         if (this.isEmpty()) {
             throw new IllegalArgumentException();  
         }
         else { 
             return curr.element();  
         }      
     }        
     /**
         
      * Presents a string representation of the list Empty list is noted "<|>"
        
      * Optional method
         
      * 
         
      * @return String version of the list
         
      */
         
     public java.lang.String asString() {
         
         return ""; // Optional method
         
     }
         
 
         
 }