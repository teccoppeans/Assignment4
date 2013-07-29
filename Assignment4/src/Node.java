
public class Node<T> {
	
	T value;
	Node<T> next;
	
	public Node(T object) {
		value = object;
		next = null;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
