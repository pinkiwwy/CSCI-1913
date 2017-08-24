//Wing Yi Wong

package Lab10;

//ARRAY QUEUE. A fixed length queue implemented as a circular array.

class ArrayQueue<Base>
{
	private int     front;     //  Index of front object in OBJECTS.
	private int     rear;      //  Index of rear object in OBJECTS.
	private Base [] objects;   //  The objects in the queue.

	public class Iterator
	{
		private int size;
		private int currentPo;
		private Base[] elements;
		
		private Iterator(Base[] elements, int size)
		{
			this.elements = elements;
			this.size = size;
			currentPo = front;
		}
		
		public boolean hasNext()
		{
			return (!isEmpty() && currentPo-1 <= size && elements[(currentPo+1) % size] != null) ;
		}
		
		public Base next()
		{
			if (!hasNext())
				throw new IllegalStateException("No more elements can be visited");
			else
				currentPo+=1;
				return elements[(currentPo) % size];
		}
		
	}

	//Constructor. Make a new empty queue that can hold SIZE - 1 elements.
	public ArrayQueue(int size)
	{
		if (size >= 1)
		{
			front = 0;
			rear = 0;
			objects = (Base []) new Object[size];
		}
		else
		{
			throw new IllegalArgumentException("Size must be at least one.");
		}
	}

	//IS EMPTY. Test if the queue is empty.

	public boolean isEmpty()
	{
		return front == rear;
	}

	//IS FULL. Test if the queue can hold no more elements.

	public boolean isFull()
	{
		return front == (rear + 1) % objects.length;
	}

	//ENQUEUE. Add OBJECT to the rear of the queue.

	public void enqueue(Base object)
	{
		int nextRear = (rear + 1) % objects.length;
		if (front == nextRear)
		{
			throw new IllegalStateException("Queue is full.");
		}
		else
		{
			rear = nextRear;
			objects[rear] = object;
		}
	}

	//DEQUEUE. Remove an object from the front of the queue and return it.

	public Base dequeue()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Queue is empty.");
		}
		else
		{
			front = (front + 1) % objects.length;
			Base temp = objects[front];
			objects[front] = null;
			return temp;
		}
	}
	
	public Iterator iterator()
	{
		return new Iterator(objects,objects.length);
	}
}
class Driver
{	public static void main(String [] args)  
	{  
  
	//  Make an ARRAY QUEUE and enqueue some things.  
  
	ArrayQueue<String> queue = new ArrayQueue<String>(5);  
	queue.enqueue("A");  
	queue.enqueue("B");  
	queue.enqueue("C");  
  
	//  Make an ITERATOR for QUEUE.  
  
	ArrayQueue<String>.Iterator first = queue.iterator();  
	while (first.hasNext())  
	{  
		System.out.println(first.next());  //  Print A B C, one per line. 
	}  
  
	//  The iterator hasn’t changed QUEUE!.  
  
	System.out.println(queue.isEmpty());   //  Print false  
	System.out.println(queue.dequeue());   //  Print A  
	System.out.println(queue.dequeue());   //  Print B  
	System.out.println(queue.dequeue());   //  Print C  
	System.out.println(queue.isEmpty());   //  Print true  
  
	//  Let’s enqueue more things to QUEUE.  
  
	queue.enqueue("X");  
	queue.enqueue("Y");  
	queue.enqueue("Z");  
	queue.enqueue("A");
  
	//  Now make a SECOND ITERATOR for QUEUE. The FIRST one won’t work any more. 
  
	ArrayQueue<String>.Iterator second = queue.iterator();  
	while (second.hasNext())  
	{  
		System.out.println(second.next());  //  Print X Y Z, one per line. 
	}  
  
	//  The SECOND iterator hasn’t changed QUEUE either!  
  
	System.out.println(queue.isEmpty());   //  Print false  
	System.out.println(queue.dequeue());   //  Print X  
	System.out.println(queue.dequeue());   //  Print Y  
	System.out.println(queue.dequeue());   //  Print Z  
	System.out.println(queue.isEmpty());   //  Print false
	System.out.println(queue.dequeue());   //  Print A
	System.out.println(queue.isEmpty());   //  Print true
	}
}

///////////////////////////////////////////////////////////////////////////
//Result:
//A
//B
//C
//false
//A
//B
//C
//true
//X
//Y
//Z
//A
//false
//X
//Y
//Z
//false
//A
//true
