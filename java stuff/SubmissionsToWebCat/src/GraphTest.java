import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author connorredmon
 * @version 11/23/15
 */
public class GraphTest {

    /**
     * test constructor
     */
    @Test
    public void testNodes() {
        Graph test = new Graph();
        assertEquals(0, test.numOfNodes());
        assertEquals(0, test.numOfEdges());
        // Test is empty
        assertEquals(true, test.isEmpty());
    }

    /**
     * test insert node
     */
    @Test
    public void testInsertNode() {
        Graph test = new Graph();
        test.insertNode("Hello");
        assertEquals(1, test.numOfNodes());
        // Test ifEmpty is false
        assertEquals(false, test.isEmpty());
    }

    /**
     * test insert multiple node
     */
    @Test
    public void testInsertMultipleNode() {
        Graph test = new Graph();
        test.insertNode("Hello");
        test.insertNode("how");
        test.insertNode("are");
        test.insertNode("you");
        test.insertNode("it's");
        test.insertNode("me");
        test.insertNode("you're");
        assertEquals(7, test.numOfNodes());

    }

    /**
     * test illegal Arg
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIllArgNode() {
        Graph test = new Graph();
        test.insertNode("Hello");
        test.insertNode("Hello");
        assertEquals(1, test.numOfNodes());
    }

    /**
     * test insert hasnode
     */
    @Test
    public void testHasNode() {
        Graph test = new Graph();
        test.insertNode("Hello");
        test.insertNode("how");
        test.insertNode("are");
        test.insertNode("you");
        test.insertNode("it's");
        test.insertNode("me");
        test.insertNode("you're");
        assertEquals(true, test.hasNode("you"));

    }

    /**
     * test insert cap 10 has
     */
    @Test
    public void testHas10Node() {
        Graph test = new Graph();
        test.insertNode("Hello");
        test.insertNode("how");
        test.insertNode("are");
        test.insertNode("you");
        test.insertNode("it's");
        test.insertNode("me");
        test.insertNode("you'r");
        test.insertNode("you'");
        test.insertNode("yo");
        test.insertNode("u're");
        test.insertNode("'re");
        assertEquals(10, test.numOfNodes());

    }

    /**
     * test trav
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testTrav() {
        Graph test = new Graph();
        assertEquals(null, test.depthFirstTraversal("hello"));

    }

    /**
     * test hasEdge
     */
    @Test
    public void testEdge() {
        Graph test = new Graph();
        assertEquals(false, test.hasEdge("this is", "wrong"));

    }

    /**
     * test insertEdge
     */
    @Test
    public void testInsertEdge() {
        Graph test = new Graph();
        test.insertEdge("this is", "wrong");
        assertEquals(0, test.numOfNodes());

    }

    /**
     * test hasNode
     */
    @Test
    public void testHasNodeNonExist() {
        Graph test = new Graph();
        assertEquals(false, test.hasNode("hello"));

    }
}
