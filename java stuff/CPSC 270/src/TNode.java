	

public class TNode<Object>{ 
	private T value;
	private BSTNode<T> left;
	private BSTNode<T> right;
	
	BSTNode(T value, BSTNode<T> left, BSTNode<T> right){
		this.value = value;
		this.left = left;
		this.right = right;
	}
	public T getValue(){
		return value;
	}
	public void setValue(T value){
		this.value = value;
	}
	public BSTNode<T> getLeft(){
		return left;
	}
	public void setLeft(BSTNode<T> left){
		this.left = left;
	}
	public void setRight(BSTNode<T> right){
		this.right = right;
	}
	public BSTNode<T> getRight(){
		return right;
	}
	
}
