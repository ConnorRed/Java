	import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Dr. Flores this assignment was so hard. Why.

public class BSTree<T extends java.lang.Comparable<? super T>> {

	/**
	 * Binary Search Tree stores references to BSTNodes
	 * 
	 * @param <T>
	 */
	private BSTNode<T> root;

	public BSTree() {

	}

	public BSTNode<T> getRoot() {
		return root;
	}

	public void delete(T value) {
		root = delete(value, root);
	}

	private BSTNode<T> getMin(BSTNode<T> node) {
		if (node.getLeft() != null) {
			return getMin(node.getLeft());
		} else {
			return node;
		}
	}

	private BSTNode<T> delete(T value, BSTNode<T> node) {

		if (node != null) {
			if (value.compareTo(node.getValue()) < 0) {
				node.setLeft(delete(value, node.getLeft()));
			} else if (value.compareTo(node.getValue()) > 0) {
				node.setRight(delete(value, node.getRight()));
			} else {
				if (node.getLeft() == null) {
					return node.getRight();
				} else if (node.getRight() == null) {
					return node.getLeft();
				} else {
					node.setValue(getMin(node.getRight()).getValue());
					node.setRight(delete(node.getValue(), node.getRight()));
				}
			}
		}

		return node;
	}

	/**
	 * Delete the given value from this tree.
	 */
	public boolean equals(java.lang.Object o) {
		if(o instanceof BSTree){
			BSTree<?> test = (BSTree<?>) o;
			Iterator<T> thisIt = this.iterator();
			Iterator<?> obj = test.iterator();
			while(thisIt.hasNext()){
				if(!obj.hasNext()){
					return false;
				}
				if(!thisIt.next().equals(obj.next())){
					return false;
				}
			}
			if(obj.hasNext()){
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @param value
	 * @return
	 */
	public boolean find(T value) {

		return find(value, root);
	}

	private boolean find(T value, BSTNode<T> node) {
		if (node == null) {
			return false;
		}

		else {
			if (node.getValue().equals(value)) {
				return true;
			} else {
				if (find(value, node.getLeft())) {
					return find(value, node.getLeft());
				} else if (find(value, node.getRight())) {
					return find(value, node.getRight());
				} else {
					return false;
				}
			}
		}
	}

	/**
	 * Find out if the given parameter is in the tree.
	 * 
	 * @param value
	 */
	public void insert(T value) {
		root = insert(value, root);
	}

	private BSTNode<T> insert(T value, BSTNode<T> node) {
		if (node == null) {
			return new BSTNode<T>(value, null, null);
		} else if (value.compareTo(node.getValue()) == 0) {
			throw new IllegalArgumentException();
		} else if (value.compareTo(node.getValue()) > 0) {
			node.setRight(insert(value, node.getRight()));
			return node;
		} else {
			node.setLeft(insert(value, node.getLeft()));
			return node;
		}
	}

	/**
	 * Report if this tree is empty.
	 * 
	 * @return if tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Returns an iterator over elements of type T.
	 * 
	 * @return iterator
	 */
	public java.util.Iterator<T> iterator() {
		return iteratorInorder();
	}

	/**
	 * Returns an in-order iterator over elements of type T.
	 * 
	 * @return in order
	 */
	public java.util.Iterator<T> iteratorInorder() {
		return new IteratorInOrder();
	}

	/**
	 * Returns an level-order iterator over elements of type T.
	 * 
	 * @return level order
	 */
	public java.util.Iterator<T> iteratorLevelorder() {
		return new IteratorLevelOrder();
	}

	/**
	 * Returns an post-order iterator over elements of type T.
	 * 
	 * @return
	 */
	public java.util.Iterator<T> iteratorPostorder() {
		return new IteratorPostOrder();
	}

	/**
	 * Returns an pre-order iterator over elements of type T.
	 * 
	 * @return pre order
	 */
	public java.util.Iterator<T> iteratorPreorder() {
		return new IteratorPreOrder();
	}

	private abstract class IteratorAbstract implements Iterator<T> {
		Queue<T> queue;

		public IteratorAbstract() {
			queue = new LinkedList<T>();
		}

		public boolean hasNext() {
			return !queue.isEmpty();
		}

		public T next() {
			return queue.remove();
		}
	}

	private class IteratorPreOrder extends IteratorAbstract {

		public IteratorPreOrder() {
			super();
			preOrder(root);
		}

		// #rekt.
		private void preOrder(BSTNode<T> node) {
			if (node != null) {
				queue.offer(node.getValue());
				preOrder(node.getLeft());
				preOrder(node.getRight());
			}
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}

	private class IteratorPostOrder extends IteratorAbstract {

		public IteratorPostOrder() {
			super();
			postOrder(root);
		}

		// #rekt.
		private void postOrder(BSTNode<T> node) {
			if (node != null) {
				postOrder(node.getLeft());
				postOrder(node.getRight());
				queue.offer(node.getValue());
			}
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}

	private class IteratorInOrder extends IteratorAbstract {

		public IteratorInOrder() {
			super();
			inOrder(root);
		}

		// #rekt.
		private void inOrder(BSTNode<T> node) {

			if (node != null) {
				inOrder(node.getLeft());
				queue.offer(node.getValue());
				inOrder(node.getRight());
			}
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}

	private class IteratorLevelOrder extends IteratorAbstract {

		public IteratorLevelOrder() {
			super();
			levelOrder();
		}

		// #rekt.
		private void levelOrder() {
			Queue<BSTNode<T>> level = new LinkedList<BSTNode<T>>();
			level.offer(root);
			while(!level.isEmpty()){
				BSTNode<T> current = level.remove();
				queue.offer(current.getValue());
				if(current.getLeft() != null)
					level.offer(current.getLeft());
				if(current.getRight() != null)
					level.offer(current.getRight());
			}
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}

}
