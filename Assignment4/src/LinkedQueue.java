
public class LinkedQueue<T> implements LinkedQueueInterface<T> {

	Node<T> rear;

	LinkedQueue() {
		rear = null;
	}
	
	LinkedQueue(T object) {
		rear = new Node<T>(object);
		rear.setNext(rear);
	}
	
	@Override
	public void add(T object) {
		// TODO Auto-generated method stub
		if (rear == null) {
			rear = new Node<T>(object);
			rear.setNext(rear);
		}
		else {
			Node<T> temp = new Node<T>(object);
			temp.setNext(rear.getNext());
			rear.setNext(temp);
			rear = temp;
		}
	}

	@Override
	public void remove() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if (rear == null)
			throw new QueueUnderflowException();
		Node<T> first = rear.getNext();
		if (rear.getNext() == rear)
			rear = null;
		else
			rear.setNext(first.getNext());
	}

	@Override
	public T examine() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if (rear == null)
			throw new QueueUnderflowException();
		return rear.getNext().getValue();
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return rear == null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		rear = null;
	}
	
	public String toString() {
		String s = "";
		Node<T> current;
		try {
		current = rear.getNext();
		} 
		catch (NullPointerException e) {
			return s;
		}
		do {
			s += current.getValue();
			current = current.getNext();
		} while (current != rear.getNext());
		
		return s;
}
	
}
