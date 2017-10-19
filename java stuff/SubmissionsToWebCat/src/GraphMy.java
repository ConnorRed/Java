/**
 * 
 * @author connorredmon
 * @version 11/23/15
 */
public interface GraphMy {

    /**
     * see if graph has no nodes
     * 
     * @return true if does, false if doesnt
     */
    public boolean isEmpty();

    /**
     * returns size of graph
     * 
     * @return size of graph
     */
    public int numOfNodes();

    /**
     * returns number of edges
     * 
     * @return num of edges
     */
    public int numOfEdges();

    /**
     * Insert a node into the graph. Note: inserted node must not be a duplicate
     * of any node in graph.
     * 
     * @param myName
     *            node to insert
     */
    public void insertNode(java.lang.String myName);

    /**
     * Insert edge from first specified node to second specified node. Nodes
     * MUST be present in graph, else this operation fails. Remember that this
     * is a graph, not a multigraph. Any problems with inserting an edge must
     * result in an IllegalArgumentException being thrown. You may, however,
     * assume that the two nodes exist in the graph.
     * 
     * @param name1
     *            the from node
     * @param name2
     *            to the node
     */
    public void insertEdge(java.lang.String name1, java.lang.String name2);

    /**
     * Report if there is an edge from first specified node to second specified
     * node. This method throws NO exceptions. It always returns true or false.
     * 
     * @param name1
     *            from the node
     * @param name2
     *            to the node
     * @return true if edge exists from name1 to name2, false in all other cases
     */
    public boolean hasEdge(java.lang.String name1, java.lang.String name2);

    /**
     * Report if the given node is in the graph.
     * 
     * @param node
     *            to look for in the graph
     * @return true if node is in graph, false else
     */
    public boolean hasNode(java.lang.String node);

    /**
     * Depth first traversal of this graph from the given node. If graph is not
     * connected, only the sub-graph reachable from given node is traversed.
     * Note that the order of node traversal should reflect the order in which
     * nodes are inserted into the graph. For example, if "a", "b", "c" are
     * inserted in that order, and the edges are (a, b) (a, c) and (c, b), then
     * the array returned should be {"a", "b", "c"}.
     * 
     * @param myName
     *            name of starting node
     * @return array of node names in depth first order
     */
    public java.lang.String[] depthFirstTraversal(java.lang.String myName);
}
