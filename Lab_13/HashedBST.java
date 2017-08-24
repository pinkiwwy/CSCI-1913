package lab13;
//implement BST algorithm using hashing, which is HBST

class HashedBST<Key, Value> 
{
	private class TreeNode	//implement nodes of binary search tree
	{
		private Key key;
		private TreeNode left;	//For BST, always a left and right node
		private TreeNode right;
		private ValueNode next;	//ValueNode for hashing
		
		private TreeNode(Key key)
		{
			this.key = key;
			this.left = null;
			this.right = null;
			this.next = null;
		}
	}
	private TreeNode root;
	
	private class ValueNode	//implement the nodes of association list
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
	
	public HashedBST()
	{
		root = new TreeNode(null);
	}
	
	public Value get(Key key)
	{
		
	}
}
