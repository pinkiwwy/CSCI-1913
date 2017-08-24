package lab12;	//building and traversing binary trees

class FamilyTree 
{
	private class Node
	{
		private String name;
		private Node father;
		private Node mother;
		
		private Node(String name, Node father, Node mother)
		{
			this.name = name;
			this.father = father;	//left slot
			this.mother = mother;	//right slot
		}
	}
	private Node root;
	
	public FamilyTree(String ego)
	{
		root = new Node(ego, null, null);
	}
	
	private Node find(String name)	//return two argument version of find
	{
		return find(name, root);
	}
	
	private Node find(String name, Node root)	//recursion here
	{
		if (root !=null)	//use == when compare nodes
		{
			if (root.name.equals(name))	//use equals when compare contents inside node
				return root;
			else
			{
				if (find(name, root.father) == null)
					return (find(name, root.mother));
				else if (find(name, root.mother) == null)
					return (find(name, root.father));
			}
		}
		return null;
	}
	
	public void addParents(String ego, String father, String mother)
	{
		if (find(ego) == null)
			throw new IllegalArgumentException("no such node");
		else
		{
			Node temp = find(ego);
			temp.father = new Node(father, null, null);
			temp.mother = new Node(mother, null, null);
		}
	}
	
	public boolean isDescendant(String ego, String ancestor)
	{
		if (find(ego) == null || find(ancestor) == null)
			return false;
		else
		{
			return isDescendant(find(ego), find(ancestor));
		}
	}
	private boolean isDescendant(Node root, Node ancestor)
	{
		if (root != null)
		{
			if (root != ancestor)
				return (isDescendant(root.father, ancestor)||isDescendant(root.mother, ancestor));
			else
				return (root == ancestor);
		}
		return false; 
	}
}

class Pottery  
{  
  public static void main(String [] args)  
  {  
    FamilyTree family = new FamilyTree("Al");  
    family.addParents("Al", "Harry", "Ginny");  
    family.addParents("Harry", "James", "Lily");  
    family.addParents("Ginny", "Arthur", "Molly");  
  
    System.out.println(family.isDescendant("Al", "Molly"));       //  true  
    System.out.println(family.isDescendant("Ginny", "James"));    //  false  
    System.out.println(family.isDescendant("Harry", "Salazar"));  //  false  
  }  
}