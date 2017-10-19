/**
 * 
 * @author connorredmon
 *
 * @version 11/10/15
 * @param <Album>
 */
class TNode<Album> {
    private Album element;           // Element for this node
    private TNode<Album> left;     // Pointer to left child
    private TNode<Album> right;    // Pointer to right child

    /**
     * creates empty root node
     */
    public TNode() {
        left = null;
        right = null;
    }

    /**
     * creates root node with val
     * 
     * @param val
     *            val thats in the node
     */
    public TNode(Album val) {
        left = null;
        right = null;
        element = val;
    }

    /**
     * creates root node with left and right kid
     * 
     * @param val
     *            root val
     * @param l
     *            left kid
     * @param r
     *            right kid
     */
    public TNode(Album val, TNode<Album> l, TNode<Album> r) {
        left = l;
        right = r;
        element = val;
    }

    /**
     * gets element
     * 
     * @return the element
     */
    public Album element() {
        return element;
    }

    /**
     * set element
     * 
     * @param v
     *            what to be set too
     */
    public void setElement(Album v) {
        element = v;
    }

    /**
     * get left kid
     * 
     * @return left kid
     */
    public TNode<Album> left() {
        return left;
    }

    /**
     * set the left kid
     * 
     * @param p
     *            what to be set too
     */
    public void setLeft(TNode<Album> p) {
        left = p;
    }

    /**
     * get right kid
     * 
     * @return right kid
     */
    public TNode<Album> right() {
        return right;
    }

    /**
     * set right kid
     * 
     * @param p
     *            what to set too
     */
    public void setRight(TNode<Album> p) {
        right = p;
    }
}
