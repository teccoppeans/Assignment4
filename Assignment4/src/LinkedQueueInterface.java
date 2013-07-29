
public interface LinkedQueueInterface<T> {
	
	public void add(T object);
	public void remove() throws QueueUnderflowException;
	public T examine() throws QueueUnderflowException;
	public boolean isEmpty();
	public void clear();
	
}
