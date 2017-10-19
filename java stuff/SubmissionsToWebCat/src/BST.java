/**
 * @author ConnorRedmon
 * @version 11/4/15
 */
public class BST extends java.lang.Object {

    private TNode<Album> root;

    /**
     * A newly instantiated BST is empty (it contains no Tnodes).
     */
    public BST() {
        root = null;
    }

    /**
     * Determine if this BST is empty.
     * 
     * @return true if this BST is empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insert the specified value into this BST.
     * 
     * @param value
     *            value - is the Album to be inserted
     * @return
     */
    public void insert(Album value) {
        root = insertHelp(root, value);

    }

    /**
     * insert help
     * 
     * @param rt
     *            TNode
     * @param value
     *            value looking for
     * @return nothing
     */
    private TNode<Album> insertHelp(TNode<Album> rt, Album value) {
        if (rt == null) {
            return new TNode<Album>(value);
        }
        else if ((rt.element().compareTo(value) == 0)) {
            return rt;
        }
        else if (rt.element().compareTo(value) > 0) {
            rt.setLeft(insertHelp(rt.left(), value));
        }
        else {
            rt.setRight(insertHelp(rt.right(), value));

        }
        return rt;
    }

    /**
     * The inorder traversal consists of the keys of each node delimited by the
     * pipe (|) symbol. For example if this BST contained two Tnodes with the
     * following Albums:
     * 
     * @return String representation of the inorder traversal of this BST
     */
    public java.lang.String inOrder() {
        return inOrderHelp(root);
    }

    /**
     * helper for inOrder
     * 
     * @param rt
     *            tnode
     * @return returns the string
     */
    private String inOrderHelp(TNode<Album> rt) {
        if (rt != null) {
            String albumString = "";
            albumString += inOrderHelp(rt.left());
            albumString += "|" + rt.element().key() + "|";
            albumString += inOrderHelp(rt.right());
            return albumString;
        }
        else {
            return "";
        }
    }

    /**
     * Determine if the specified album is in this BST.
     * 
     * @param album
     *            album - is the Album to search for in this BST
     * @return true if album is in this BST, false otherwise
     */
    public boolean find(Album album) {
        return findHelp(root, album);

    }

    /**
     * helper for find
     * 
     * @param rt
     *            tnode
     * @param value
     *            value looking for
     * @return true if in BST, false if not
     */
    private boolean findHelp(TNode<Album> rt, Album value) {
        if (rt == null) {
            return false;
        }
        else if (rt.element().equals(value)) {
            return true;
        }

        else if (rt.element().compareTo(value) > 0) {
            return findHelp(rt.left(), value);
        }
        else {
            return findHelp(rt.right(), value);
        }

    }

    /**
     * 
     * @param artist
     *            artist - is the name of the artist of this album
     * @param title
     *            title - is the title of this album
     * @return he Album matching the given artist and title.
     */
    public Album retrieve(java.lang.String artist, java.lang.String title) {
        TNode<Album> temp = retrieveHelp(root, artist, title);
        if (temp != null) {
            return temp.element();
        }
        else {
            return null;
        }
    }

    /**
     * helper for retrieve
     * 
     * @param rt
     *            Tnode
     * @param artist
     *            artist to be retrieved
     * @param title
     *            title to be retrieved
     * @return the album
     */
    private TNode<Album> retrieveHelp(TNode<Album> rt,
            java.lang.String artist, java.lang.String title) {
        String temp = artist + title;

        while (rt != null) {
            if (rt.element().key().compareTo(temp) == 0) {
                return rt;
            }
            else if (rt.element().key().compareTo(temp) > 0) {
                return retrieveHelp(rt.left(), artist, title);
            }
            else {
                return retrieveHelp(rt.right(), artist, title);
            }

        }
        return null;
    }

    /**
     * Remove the specified album from this tree. If the Album was not in the
     * tree, do nothing.
     * 
     * @param a
     *            a - is the Album to remove
     */
    public void remove(Album a) {
        root = removeHelp(root, a);
    }

    /**
     * finds the min value
     * 
     * @param rt
     *            tnode
     * @return the min else rt
     */
    static TNode<Album> getMin(TNode<Album> rt) {
        if (rt.left() != null) {
            return getMin(rt.left());
        }
        else {
            return rt;
        }
    }

    /**
     * helper for remove method
     * 
     * @param rt
     *            tnode
     * @param value
     *            value looking for
     * @return return the tnode
     */
    private TNode<Album> removeHelp(TNode<Album> rt, Album value) {

        if (rt != null) {
            if (value.compareTo(rt.element()) < 0) {
                rt.setLeft(removeHelp(rt.left(), value));
            }
            else if (value.compareTo(rt.element()) > 0) {
                rt.setRight(removeHelp(rt.right(), value));
            }
            else {
                if (rt.left() == null) {
                    return rt.right();
                }
                else if (rt.right() == null) {
                    return rt.left();
                }
                else {
                    rt.setElement(getMin(rt.right()).element());
                    rt.setRight(removeHelp(rt.right(), rt.element()));
                }
            }
        }

        return rt;
    }
}
