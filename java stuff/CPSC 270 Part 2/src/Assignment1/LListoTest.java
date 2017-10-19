 public class Link<Object> {
     /**
      * @param value
      *            object being added
      */
     public Object value;
     /**
      * @param next
      *            point to next node in the list
      */
     public Link<Object> next;
     /**
      * Creates a new list with a value
      * 
      * @param it
      *            value in the node
      * @param inn
      *            the next value
      */
     Link(Object it, Link<Object> inn) {
         this.value = it;
         this.next = inn;  
     }
     /**
      * Creates a new list without valu
      * 
      * @param inn
      *            object in the node
      */
     Link(Link<Object> inn) {
         this.value = null;
         this.next = inn;  
     }
     /**
      * return the value
      * 
      * @return returns the value
      */
     Object element() {
         return value;  
     }
     /**
      * set element value
      *    
      * @param it
      *            element value
      * @return returns object as value
      */
     Object setElement(Object it) {
         value = it;
         return value;  
     }
     /**
      * returns the next link
      * 
      * @return returns next link
      */
     Link<Object> next() {
         return this.next;     
 }
     /**
      * Set next
      * 
      * @param inn
      *            object setting as next
      * @return returns next link
      */
     Link<Object> setNext(Link<Object> inn) {
         next = inn;
         return next;  
     }     
 }