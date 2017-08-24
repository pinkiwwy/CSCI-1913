//Name: Wing Yi Wong

package Project3;

class HashedBST<Key, Value>
{
	private class TreeNode	//implement the nodes of BST
	{
		private Key key;
		private ValueNode next;
		private TreeNode left;
		private TreeNode right;
		
		private TreeNode(Key key)
		{
			this.key = key;
			this.next = null;
			this.left = null;
			this.right = null;
		}
	}
	
	private TreeNode root;
	
	private class ValueNode	//implement the nodes of association lists
	{
		private Key key;
		private Value value;
		private ValueNode next;
		
		private ValueNode(Key key, Value value)
		{
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	public HashedBST()	//Constructor. Make a new, empty HBST.
	{
		root = new TreeNode(null);
	}

	public Value get(Key key) 	//return the value associated with key
	{
		if (key == null)	//Note that key maybe null
			throw new IllegalArgumentException("Key is null");
		
		TreeNode subtree = root;
		while (subtree !=null)	//refer to BST posted on moodle
		{
			if (hash(key) < hash(subtree.key))
				subtree = subtree.left;

			else if (hash(key) > hash(subtree.key))
				subtree = subtree.right;
			
			else
				break;
		}
		
		ValueNode temp = subtree.next; 
		while (temp!=null)		//refer to lab11
		{
			if (temp.key.equals(key))
				return temp.value;
			else
				temp = temp.next;
		}
		throw new IllegalArgumentException("key is not in the list.");
		//throw exception if no value is associated with key in the HBST 
	}


	private int hash(Key key)	//Return the hash value of key using hashCode()
	{
		if (key != null)
		{
			return key.hashCode();
		}
		else
		{
			return 0;
		}
	}
	

	public int height()		//Refer to BST posted on Moodle
	{
		return height(root);
	}
	
	private int height(TreeNode subtree)	//Refer to BST posted on Moodle
	{
	    if (subtree == null)
	    {
	    	return 0;
	    }
	    else
	    {
	    	int left  = height(subtree.left);
	    	int right = height(subtree.right);
	    	if (left > right)
	        {
	    		return left + 1;
	    	}
	    	else
	    	{
	    		return right + 1;
	    	}
	     }
	} 

	public void put(Key key, Value value)	//Associate key with value in the HBST.
	{	
		if (key == null)	//Note that key maybe null
			throw new IllegalArgumentException("Key is null");
		
		else if (root == null)
			root = new TreeNode(key);
		
		else
	    {
			TreeNode subtree = root;
			while (true)
			{
				if (hash(key) < hash(subtree.key))
				{
					if (subtree.left == null)
					{
						subtree.left = new TreeNode(key);
						subtree.left.next = new ValueNode(key,value);
						return;
					}
					else
						subtree = subtree.left;
				}
				else if (hash(key) > hash(subtree.key))
				{
					if (subtree.right == null)
					{
						subtree.right = new TreeNode(key);
						subtree.right.next = new ValueNode(key,value);
						return;
					}
					else
						subtree = subtree.right;
				}
				else
				{
					ValueNode temp = subtree.next;
					
					while (true)
					{
						if (subtree.next == null)
						{
							temp.next = new ValueNode(key,value);
							return;
						}
						temp = temp.next;
					}
				}
			}
	    }
	}
}

class Driver  
{  
  private final static String[] reserved =  
   { "abstract",     "assert",    "boolean",     "break",  
     "byte",         "case",      "catch",       "char",  
     "class",        "const",     "continue",    "default",  
     "do",           "double",    "else",        "extends",  
     "final",        "finally",   "float",       "for",  
     "goto",         "if",        "implements",  "import",  
     "instanceof",   "int",       "interface",   "long",  
     "native",       "new",       "package",     "private",  
     "protected",    "public",    "return",      "short",  
     "static",       "super",     "switch",      "synchronized",  
     "this",         "throw",     "throws",      "transient",  
     "try",          "void",      "volatile",    "while" };  
  
  public static void main(String [] args)  
  {  
    HashedBST<String, Integer> hbst = new HashedBST<String, Integer>();  
  
    for (int index = 0; index < reserved.length; index += 1)  
    {  
      hbst.put(reserved[index], index);  
    }  
  
    System.out.println(hbst.height());  
  
    for (int index = 0; index < reserved.length; index += 1)  
    {  
      System.out.format("%02d %s", hbst.get(reserved[index]), reserved[index]);  
      System.out.println();  
    }  
  }
  
}

///////////////////////////////////////////////////////////////////////////////////
//Result:
//16
//00 abstract
//01 assert
//02 boolean
//03 break
//04 byte
//05 case
//06 catch
//07 char
//08 class
//09 const
//10 continue
//11 default
//12 do
//13 double
//14 else
//15 extends
//16 final
//17 finally
//18 float
//19 for
//20 goto
//21 if
//22 implements
//23 import
//24 instanceof
//25 int
//26 interface
//27 long
//28 native
//29 new
//30 package
//31 private
//32 protected
//33 public
//34 return
//35 short
//36 static
//37 super
//38 switch
//39 synchronized
//40 this
//41 throw
//42 throws
//43 transient
//44 try
//45 void
//46 volatile
//47 while

