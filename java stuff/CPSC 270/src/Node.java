public final class Node<T> {
	public T       value;
	public Node<T> next;
	
	/**
	 * Constructs a new Node storing a value and referring to null.
	 * @param value Value to store in the node.
	 */
	public Node(T value) {
		this( value, null );
	}
	/**
	 * Constructs a new Node storing a value and referring to a next node.
	 * @param value Value to store in the node.
	 * @param next Node following this node in the list.
	 */
	public Node(T value, Node<T> next) {
		this.value = value;
		this.next  = next;
	}
	/**
	 * Creates a string representation of this node.
	 * @return String representation of the node.
	 */
	@Override
	public String toString() {
		return String.format( "%s", value );
	}
}