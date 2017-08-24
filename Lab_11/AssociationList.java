package lab11;	//Singular linear list

class AssociationList<Key, Value> 	//Using Object types Key and Value
{
	private class Node
	{
		private Key key;
		private Value value;
		private Node next;
		
		private Node(Key key, Value value, Node next)
		{
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	private Node head;	//assign after created inner class Node
	
	public AssociationList()
	{
		head = new Node(null, null, head);
	}
	
	public Value get(Key key)
	{
		Node temp = head.next;
		while (temp != null)
		{
			if (temp.key.equals(key))
				return temp.value;
			else
				temp = temp.next;
		}
		throw new IllegalArgumentException("key is not in the list");
	}
	
	public boolean isEmpty()
	{
		return (head.next == null);
	}
	
	public void put(Key key, Value value)
	{
		if (key == null)
			throw new IllegalArgumentException("Key is null");
		else
		{
			Node temp = head.next;
			while (temp !=null)
			{	
				if (temp.key.equals(key))
				{
					temp.value = value;
					return;	//ends the method here with return
				}
				else
					temp = temp.next;
			}
			Node newTemp = new Node(key, value, head.next);
			head.next = newTemp;
			return;
		}
	}
	public void remove(Key key)
	{
		Node temp = head;
		while (temp.next != null)
		{
			if (temp.next.key.equals(key))
			{
				temp.next = temp.next.next;
				return;
			}
			else
				temp = temp.next;
		}
		return;
	}
	
}

class SmallMediumLarge  
{  
  public static void main(String [] args)  
  {  
    AssociationList<String, Integer> a = new AssociationList<String, Integer>();  
  
    a.put("small",  0);  
    a.put("medium", 1);  
    a.put("large",  2);  
  
    System.out.println(a.get("small"));   //  0  
    System.out.println(a.get("medium"));  //  1  
    System.out.println(a.get("large"));   //  2  
  
    a.put("large", 1000);  
  
    System.out.println(a.get("small"));   //  0  
    System.out.println(a.get("medium"));  //  1  
    System.out.println(a.get("large"));   //  1000  
  
    a.remove("large");  
  
    System.out.println(a.get("small"));   //  0  
    System.out.println(a.get("medium"));  //  1  
    System.out.println(a.get("large"));   //  Throw an exception.  
  }  
}


