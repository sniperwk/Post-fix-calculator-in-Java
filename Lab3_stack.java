
public class Lab3_stack {
	
	public static final int initialSize = 30;
	
	private int currentSize;
	private int[] stack;
	private int top;
	
	public Lab3_stack()
	{
		// use the input of the sizeArray to get extended size of array
		currentSize = initialSize;
		stack = new int[initialSize];
		top = 0;
		
	}
	
	public boolean isFull()
	{
		if (top >= currentSize)
		{
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmpty()
	{
		if (top <= 0)
		{
			return true;
		} else {
			return false;
		}
	}
	
	public void push(int operand)
	{
		if (isFull())
		{
			expandArray();
		} 
		stack[top] = operand;
		top++;
	}
	
	public String pop()
	{
		int popElement;
		
		if (isEmpty())
		{
			System.out.println("empty stack, no element to pop");
			return "";   // to be improved
		} else {
			popElement = stack[top - 1];
			top--;
			return "" + popElement;
		}
	}
	
	public int size()
	{
		return top;
	}
	
	
	public void expandArray()
	{
		
		int[] newStack = new int[currentSize * 2] ;
		// copy all the elements from the older stack to the new stack
		
		for (int j = 0; j < currentSize; j++)
		{
			newStack[j] = stack[j];
		}
		
		currentSize *= 2;
		// point stack to the newer bigger array newStack
		// System.out.println("size of the old stack: " + stack.length);
		stack = newStack;
		// System.out.println("size of the newer stack: " + stack.length);
	}
	
	public void reset()
	{
		top = 0;
	}
	
	
	public void showStack()
	{
		if (top <= 0)
		{
			System.out.println("it is an empty stack");
		}
		for (int j = 0; j < top; j++)
		{
			System.out.println("stack[" + j + "] : " +stack[j]);
		}
	}
	
	

}
