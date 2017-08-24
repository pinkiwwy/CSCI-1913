//Name: Wing Yi Wong


package Lab9;

class RunnyStack<Base>	//using linked list of nodes
{
	private class Run
    {
         private Base object;	//points to the Base object
         private Run next;	//points to the Run that is immediately below the one on the stack
         private int length;	//length of the run
         
         private Run(Base object, Run next, int length)
         {
              this.object = object; // this.element means the “private Base element” and element means the “Base element"
              this.next = next;
              this.length = length;
         }
    }
	
	private Run top;
	private int count;	
	
	public RunnyStack()	//make a new empty instance of RunnyStack
	{
		top = new Run(null, null, 0);
		count =0 ;
	}
	
	public int depth()	//return the depth of the stack or sum of the lengths of all runs it holds
	{
		return count;
	}
	
	public boolean isEmpty()	//test if the stack holds no object
	{
		return top.object == null;
	}
	
	private boolean isEqual(Base object, Base ob)
	{
		if (object == null || ob == null)
		{
			return object == ob;	//== only test for null objects
		}
		return object.equals(ob);	//test for non-null objects
	}
	
	public Base peek()	//return object at the top
	{
		if (isEmpty()) 
		{
			throw new IllegalStateException("Stack is empty.");
		} 
		else 
		{	
			return top.object;
		}
	}
	
	public void pop()	//decrement the length of the run on top of stack
	{
		if(isEmpty())
		{
			throw new IllegalStateException("Stack is empty.");
		}
		else
		{
			count--;
			top.length --;
			top = top.next;
		}
	}
	
	public void push(Base object)	//add a new run of object at the top of stack
	{
		
		if (!isEmpty())
		{
			if(isEqual(object, top.object))
			{
				count++;
				top = new Run(object, top, top.length);
			}
			else
			{
				top = new Run(object, top, top.length);
				top.length++;
				count++;
			}
		}	
		else
		{
			top = new Run(object, top, top.length);	
			top.length ++;
			count ++;
		}
	}
	
	public int runs()	// return the numbers of runs in the stack
	{
		return top.length;
	}
}

class RunnyDriver  
{  
  public static void main(String[] args)  
  {  
    RunnyStack<String> s = new RunnyStack<String>();  
  
    s.push("A");  
    System.out.println(s.peek() + " "  + s.depth() + " " +s.runs());  //  A 1 1 
  
    s.push("B");  
    System.out.println(s.peek() + " " + s.depth() + " " +s.runs());  //  B 2 2 
  
    s.push("B");  
    System.out.println(s.peek() + " " + s.depth() + " " +s.runs());  //  B 3 2 
  
    s.pop();  
    System.out.println(s.peek() + " " + s.depth() + " " +s.runs());  //  B 2 2 
  
    s.pop();  
    System.out.println(s.peek() + " " + s.depth() + " " +s.runs());  //  A 1 1 
    
    s.push("C");
    System.out.println(s.peek() + " " + s.depth() + " " +s.runs());	 //  C 2 2
    
    s.push("B");  
    System.out.println(s.peek() + " " + s.depth() + " " +s.runs());
    
    s.pop();  
    System.out.println(s.peek() + " " + s.depth() + " " +s.runs());	//A 1 1
    
    s.pop();  
    System.out.println(s.peek() + " " + s.depth() + " " +s.runs());  //  Throw exception since stack is empty

  }  
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	Result:
//	A 1 1
//	B 2 2
//	B 3 2
//	B 2 2
//	A 1 1
//	C 2 2
//	A 1 1
//	Exception in thread "main" java.lang.IllegalStateException: Stack is empty.
//		at Lab9.RunnyStack.peek(RunnyStack.java:51)
//		at Lab9.RunnyDriver.main(RunnyStack.java:126)
