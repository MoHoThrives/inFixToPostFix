
/**
 * This Stack class represents a last-in-first-out (LIFO) stack of objects.
 * The usual push and pop operations are provided, as well as a method to peek 
 * at the top item on the stack, and a method to test for whether the stack is empty.
 * When a stack is first created, it contains no items.
 */
public class Stack<T> implements StackADT<T> {
	/**
	 * The array into which the objects of the stack are stored.
	 */
	private T[] data;
	/**
	 * The number of objects in this stack.
	 */
	private int size;
	/**
	 * The default capacity of this stack.
	 */
	private static final int MAX_SIZE = 100;
	/**
	 * Constructs a new Stack with capacity for 100 objects
	 */
	public Stack(){
		data = (T[]) new Object[MAX_SIZE];
		size = 0;
	}
	/**
	 * Constructs a new Stack with capacity specified by user
	 * @param size the size of the Stack
	 */
	public Stack(int size){
		data = (T[]) new Object[size];
		this.size = 0;
	}
	/**
	 * Returns the number of objects on the stack.
	 * @return The number of objects on the stack.
	 */
	public int getSize(){
		return size;
	}
	/**
	 * Returns the current state of this stack. 
	 * @return String representation of this stack.
	 */
	public String toString() {
		String str = "Stack Size: " + size + "\n--\n";
		for (int i = size-1; i >= 0 ; i--) {
			str = str + data [i] + "\n";
		}
		return str + "--\n";
	}
	/**
	 * Pushes an object onto the top of this stack.
	 * @param x The object to be stored onto the stack.
	 * @throws StackFullException - if this stack is full
	 */
	public void push( T x ) throws StackFullException //put item on the stack
	{ 
		if(isFull()) 
		{
			throw new StackFullException("Stack is Full");
		}
		else
			data[size++] = x;
	}
	/**
	 * Removes and returns the object at the top of this stack.
	 * @return The object at the top of the stack.
	 * @throws StackEmptyException - if this stack is full
	 */
	public T pop() throws StackEmptyException {
		if(isEmpty()) {
			throw new StackEmptyException("Stack is Empty");
		}		
		return data[--size];
	}
	/**
	 * Returns the object at the top of this stack without removing it.
	 * @return The object at the top of the stack.
	 * @throws StackEmptyException - if this stack is full
	 */
	public T peek() throws StackEmptyException { // The last item you put in
		if(isEmpty()) {
			throw new StackEmptyException("Stack is Empty");
		}
		return data[size-1];
	}
	/**
	 * Tests if this stack is empty.
	 * @return <i>true</i> if and only if this stack is empty; <i>false</i> otherwise.
	 */
	public boolean isEmpty(){ 
		return (size == 0);
	}
	/**
	 * Tests if this stack is full.
	 * @return <i>true</i> if and only if this stack is full; <i>false</i> otherwise.
	 */
	public boolean isFull() {
		return (size == data.length);
	}
}