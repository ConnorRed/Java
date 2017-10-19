import static org.junit.Assert.*;


import org.junit.Test;


public class BSTreeTestMy {

   @Test
   public void testDelete() 
   {
       BSTree<Integer> tree = new BSTree<Integer>();
       tree.insert(3);
       tree.insert(4);
       tree.insert(5);
       tree.insert(6);
       tree.insert(7);
       tree.insert(8);
       tree.insert(9);
       tree.insert(10);
       tree.insert(11);
       tree.insert(12);
       tree.delete(7);
       tree.delete(8);
       tree.delete(6);
       tree.delete(5);
       tree.delete(3);
       tree.delete(4);
       tree.delete(12);
       tree.delete(10);
       tree.delete(11);
       boolean actual = tree.find(9);
       boolean expected = true;
       assertEquals("Not correct", expected, actual);
   }

   @Test
   public void testDeleteLeft()
   {
       BSTree<Integer> tree = new BSTree<Integer>();
       tree.insert(7);
       tree.insert(6);
       tree.insert(2);
       tree.delete(7);
       tree.delete(6);
       boolean actual = tree.find(6);
       boolean expected = false;
       assertEquals("Not correct", expected, actual);
   }

   @Test
   public void testDeleteRight() 
   {
       BSTree<Integer> tree = new BSTree<Integer>();
       tree.insert(7);
       tree.insert(6);
       tree.delete(7);
       tree.delete(6);
       boolean actual = tree.find(6);
       boolean expected = false;
       assertEquals("Not correct", expected, actual);
   }

   @Test
   public void testInsertRightLeft()
   {
       BSTree<Integer> tree = new BSTree<Integer>();
       tree.insert(5);
       tree.insert(6);
       tree.insert(3);
       boolean actual = tree.find(3);
       boolean expected = true;
       assertEquals("Not correct", expected, actual);
   }

   @Test
   public void testFindTree() 
   {
       BSTree<Integer> tree = new BSTree<Integer>();
       tree.insert(11);
       tree.insert(10);
       tree.insert(2);
       tree.insert(5);
       tree.insert(1);
       tree.insert(15);
       boolean actual = tree.find(1);
       boolean expected = true;
       assertEquals("Not correct", expected, actual);
   }
   
   @Test
   public void testNotEmpty()
   {
       BSTree<Integer> tree = new BSTree<Integer>();
       tree.insert(5);
       tree.insert(15);
       tree.insert(10);
       boolean actual = tree.find(5);
       boolean expected = true;
       assertEquals("Not correct", expected, actual);
   }
   
   @Test
   public void testEquals() 
   {
       BSTree<Integer> tree1 = new BSTree<Integer>();
       BSTree<Integer> tree2 = new BSTree<Integer>();
       tree1.insert(1);
       tree1.insert(2);
       tree1.insert(3);
       tree2.insert(1);
       tree2.insert(2);
       tree2.insert(3);
       boolean actual = tree1.equals(tree2);
       boolean expected = true;
       assertEquals("Not correct", expected, actual);
   }
   
   @Test
   public void testNotEquals() 
   {
       BSTree<Integer> tree1 = new BSTree<Integer>();
       BSTree<Integer> tree2 = new BSTree<Integer>();
       tree1.insert(1);
       tree1.insert(2);
       tree1.insert(3);
       tree2.insert(4);
       tree2.insert(5);
       tree2.insert(6);
       boolean actual = tree1.equals(tree2);
       boolean expected = false;
       assertEquals("Not correct", expected, actual);
   }

   @Test
   public void testIsEmpty()
   {
       BSTree<Integer> tree = new BSTree<Integer>();
       boolean actual = tree.isEmpty();
       boolean expected = true;
       assertEquals("Not correct", expected, actual);
   }
}
