import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author connorredmon
 * @version 11/10/15
 */
public class BSTreeTest {
    /**
     * test left Tnode constructor
     */
    @Test
    public void testTnodeLeftConstructor() {
        TNode<Album> test = new TNode<Album>();
        assertEquals(null, test.left());
    }

    /**
     * test right Tnode constructor
     */
    @Test
    public void testTnodeRightConstructor() {
        TNode<Album> test = new TNode<Album>();
        assertEquals(null, test.right());
    }

    /**
     * test Tnode setElement
     */
    @Test
    public void testTnodeSetElement() {
        TNode<Album> test = new TNode<Album>();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        test.setElement(a);
        assertEquals(a, test.element());
    }

    /**
     * test left Tnode setLeft
     */
    @Test
    public void testTnodeSetLeft() {
        TNode<Album> test = new TNode<Album>(null, null, null);
        String[] songs = { "song1", "song2", "song3" };
        Album b = new Album("Lil Wayne", "No Ceilings", songs);
        TNode<Album> temp2 = new TNode<Album>(b);
        test.setLeft(temp2);
        assertEquals(temp2, test.left());
    }

    /**
     * test left Tnode setReft
     */
    @Test
    public void testTnodeSetReft() {
        TNode<Album> test = new TNode<Album>(null, null, null);
        String[] songs = { "song1", "song2", "song3" };
        Album b = new Album("Lil Wayne", "No Ceilings", songs);
        TNode<Album> temp2 = new TNode<Album>(b);
        test.setRight(temp2);
        assertEquals(temp2, test.right());
    }

    /**
     * test to see if empty
     */
    @Test
    public void testIsEmpty() {
        BST tree = new BST();
        assertEquals(true, tree.isEmpty());

    }

    /**
     * test to see if Notempty
     */
    @Test
    public void testIsNotEmpty() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album b = new Album("Lil Wayne", "No Ceilings", songs);
        tree.insert(b);
        assertEquals(false, tree.isEmpty());

    }

    /**
     * Test insert method
     */
    @Test
    public void testInsert() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        tree.insert(a);
        assertEquals(false, tree.isEmpty());
    }

    /**
     * Test insert method double tree
     */
    @Test
    public void testInsertDoubleTree() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        tree.insert(a);
        tree.insert(a);
        assertEquals(true, tree.find(a));
    }

    /**
     * test find with more than one album
     */
    @Test
    public void testInsertWithMoreThanOne() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        Album b = new Album("Lil Wayne", "No Ceilings", songs);
        Album c = new Album("Wiz Khalifa", "Taylorallderice", songs);
        Album d = new Album("Kevin Gates", "Luca Brasi", songs);
        tree.insert(a);
        tree.insert(b);
        tree.insert(c);
        tree.insert(d);
        assertEquals(true, tree.find(a));
        assertEquals(true, tree.find(b));
        assertEquals(true, tree.find(c));
        assertEquals(true, tree.find(d));
    }

    /**
     * test find method
     */
    @Test
    public void testFind() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        tree.insert(a);
        assertEquals(true, tree.find(a));
    }

    /**
     * test find with none method
     */
    @Test
    public void testFindWithNon() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        assertEquals(false, tree.find(a));
    }

    /**
     * test find with more than one album
     */
    @Test
    public void testFindWithMoreThanOne() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        Album b = new Album("Lil Wayne", "No Ceilings", songs);
        Album c = new Album("Wiz Khalifa", "Taylorallderice", songs);
        Album d = new Album("Kevin Gates", "Luca Brasi", songs);
        tree.insert(a);
        tree.insert(b);
        tree.insert(c);
        tree.insert(d);
        assertEquals(true, tree.find(a));
        assertEquals(true, tree.find(b));
        assertEquals(true, tree.find(c));
        assertEquals(true, tree.find(d));
    }

    /**
     * test retrieve null album
     */
    @Test
    public void testRetrieveNull() {
        BST tree = new BST();
        assertEquals(null, tree.retrieve("Drake", "Views From The 6"));

    }

    /**
     * test retrieve one album
     */
    @Test
    public void testRetrieveWithOne() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "Views From The 6", songs);
        tree.insert(a);
        assertEquals(a, tree.retrieve("Drake", "Views From The 6"));

    }

    /**
     * test retrieve more than one
     */
    @Test
    public void testRetrieveWithMoreThanOne() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        Album b = new Album("Lil Wayne", "No Ceilings", songs);
        Album c = new Album("Wiz Khalifa", "Taylorallderice", songs);
        Album d = new Album("Kevin Gates", "Luca Brasi", songs);
        tree.insert(a);
        tree.insert(b);
        tree.insert(c);
        tree.insert(d);
        assertEquals(a, tree.retrieve("Drake", "View From The 6"));
        assertEquals(b, tree.retrieve("Lil Wayne", "No Ceilings"));
        assertEquals(c, tree.retrieve("Wiz Khalifa", "Taylorallderice"));
        assertEquals(d, tree.retrieve("Kevin Gates", "Luca Brasi"));
    }

    /**
     * test inOrder none album
     */
    @Test
    public void testInOrderWithNone() {
        BST tree = new BST();
        assertEquals("", tree.inOrder());

    }

    /**
     * test inOrder one album
     */
    @Test
    public void testInOrderWithOne() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "Views From The 6", songs);
        tree.insert(a);
        assertEquals("|DrakeViews From The 6|", tree.inOrder());

    }

    /**
     * test remove method
     */
    @Test
    public void testRemove() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        tree.insert(a);
        tree.remove(a);
        assertEquals(false, tree.find(a));
    }

    /**
     * test remove method with non
     */
    @Test
    public void testRemoveWithNon() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        tree.remove(a);
        assertEquals(false, tree.find(a));
    }

    /**
     * test remove more than one
     */
    @Test
    public void testRemoveWithMoreThanOne() {
        BST tree = new BST();
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        Album b = new Album("Lil Wayne", "No Ceilings", songs);
        Album c = new Album("Wiz Khalifa", "Taylorallderice", songs);
        Album d = new Album("Kevin Gates", "Luca Brasi", songs);
        tree.insert(a);
        tree.insert(b);
        tree.insert(c);
        tree.insert(d);
        tree.remove(b);
        tree.remove(c);
        assertEquals(true, tree.find(a));
        assertEquals(false, tree.find(b));
        assertEquals(false, tree.find(c));
        assertEquals(true, tree.find(d));
    }

    /**
     * test getMin method
     */
    @Test
    public void testMin() {
        String[] songs = { "song1", "song2", "song3" };
        Album a = new Album("Drake", "View From The 6", songs);
        Album b = new Album("Lil Wayne", "No Ceilings", songs);
        Album c = new Album("Wiz Khalifa", "Taylorallderice", songs);
        TNode<Album> temp2 = new TNode<Album>(b);
        TNode<Album> temp3 = new TNode<Album>(c);
        TNode<Album> collect = new TNode<Album>(a, temp2, temp3);
        assertEquals(temp2, BST.getMin(collect));
    }
}
