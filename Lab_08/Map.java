//Name: Wing Yi Wong


package lab8;

class Map<Key, Value> 
{
	private Key[] keys;
	private Value[] values;
	private int count;
	private int likeIncrement;
	
	//Constructor
	public Map(int length, int increment)
	{
		if (length <0 || increment <=0)
		{
			throw new IllegalArgumentException("Values cannot be less than 0");
		}
		
		else
		{
			count = 0;
			likeIncrement = increment;
			keys = (Key[]) new Object[length];
			values = (Value[]) new Object[length];
		}
	}
	
	//Constructor
	public Map()
	{
		this(64,8);
	}
	
	public Value get(Key key)
	{
		if (where(key) != -1)
		{
			return values[where(key)];	//return value associate with key
		}
		
		else
		{
			throw new IllegalArgumentException("not found");
		}
	}
	
	private boolean isEqual(Key leftKey, Key rightKey)
	{
		if (leftKey == null || rightKey == null)	//either or both may be null
		{
			return leftKey == rightKey;
		}
		else
		{
			return leftKey.equals(rightKey);	//use equals method when both not null
		}
	}

	public boolean isIn(Key key)
	{
		if (where(key) >= 0)
		{
			return true;
		}
		return false;
	}
	
	public void put(Key key, Value value)
	{
		if (where(key) != -1)	//object is at some index in keys
		{
			values[where(key)] = value;
		}
		else	//object not in keys 
		{
			if (count < keys.length)	
			{
				keys[count] = key;
				values[count] = value;
				count++;
			}
			else	//if the array is full, make them longer
			{
				Key[] likeKeys = (Key[]) new Object[(keys.length + likeIncrement)];	
				Value[] likeValues = (Value[]) new Object[(values.length + likeIncrement)];
				for (int i=0; i<keys.length;i++)
				{
					likeKeys[i] = keys[i];
					likeValues[i] = values[i];
				}
				for (int i=0; i<values.length;i++)
				{
					if (likeKeys[i] == null)
					{
						likeKeys[i] = key;
						likeValues[i] = value;
						break;
					}
				}
				keys = likeKeys;
				values = likeValues;

			}
		}
	}
	
	private int where(Key key)
	{
		for (int i =0; i< keys.length; i++)
		{
			if (isEqual(key,keys[i]))
			{
				return i;
			}
		}
		return -1;
	}


	public static void main(String[] args)
	{
		Map<String, Integer> map=new Map<>(3,2);
		map.put("one",1);
		map.put("two",2);
		map.put("three",3);
		System.out.println(map.isIn("one"));
		System.out.println(map.isIn("five"));
		System.out.println(map.get("five"));
		//System.out.println(map.get("one"));
	}
}

////////////////////////////////////////////
//true
//false
//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -1
//at lab8.Map.get(Map.java:40)
//at lab8.Map.main(Map.java:131)
