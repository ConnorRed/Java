import java.util.Iterator;

public class LinkedLast<T> extends java.lang.Object implements
		java.lang.Iterable<T> {
	private Node<T> tail;
	private int size;

	public LinkedLast() {
		tail = null;
		size = 0;
	}

	public void add(T o) {
{
		Node<T> current;
			if(size < 1){
				current = new Node<T>(o, null);
				current.next = current;
				tail = current;
			}
			else{
				current = new Node<T>(o, tail.next);
				tail = current;
				tail.next = current;
			}
			size++;
		}
	}

	public void add(int index, T o) {
//can't figure it out
		
	}

	public void clear() {
		tail = null;
		size = 0;

	}

	public boolean contains(T o) {
		boolean res = false;
		Node<T> temp = tail.next;
		int i = 0;
		while(i< size){
			temp = temp.next;
			i++;
			if (temp.value.equals(o)) {
				res =  true;
			}
			else{
				res = false;
			}
		}
		return res;
	}

	public boolean equals(java.lang.Object obj) {
		boolean res = false;
		if(obj == null){
			res = false;
			}
		if(obj instanceof LinkedLast){
			
		}
		return res;
	}

	public T get(int index) {
		if (index>= size  || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Node<T> temp = tail.next;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.value;
	}

	public int getSize() {
		return size;

	}

	public int indexOf(T o) {
		Node<T> tempa = tail.next;
		if(o.equals(tempa.value)){
			return size;
		}
		else{
			return -1;
	}
		
	}

	public boolean isEmpty() {
		boolean res = false;
		if (size == 0) {
			res = true;
		} else {
			res = false;
		}
		return res;
	}

	public Iterator<T> iterator() {
		//can't figure out
		return null;

	}

	public T remove(int index) {
		//can't figure out
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return null;

	}

	public T remove(T o) {
		Node<T> temp = tail.next;
		while (temp.next != null) {
			if (temp.next.value.equals(o)) {
				Node<T> temp2 = temp.next;
				temp.next = temp.next.next;
				temp2.next = null;
				return o;
			}
			temp = temp.next;
		}
		return null;
	}

	public T set(int index, T o) {
		Node<T> temp = tail.next;
		int i = 0;
		while(i < index){
			temp = temp.next;
			i++;
		}
		temp.value = o;
		return o;
	}
}
