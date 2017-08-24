//Wing Yi Wong

package Pathname;

class Pathname 
{
	private int depth;
	private String [] directories;
	private String name;
	private String type;
	
	public Pathname(String name)	//constructor with given name
	{
		depth = 0;
		directories = new String[10];
		type = "";
		this.name = name;
	}
	
	public Pathname(String name, String type)	//constructor with given name and type
	{
		depth =0 ;
		directories = new String[10];
		this.name = name;
		this.type = type;
	}
	
	public void addDirectory(String directory)	//add directory to array if depth not exceed 10
	{
		if (depth <= 10)
		{			
			directories[depth] = directory;
			depth++;
		}
		else
		{
			
		}
	}
	
	public boolean equals(Object object)	//test if object equals to pathname
	{
		if (object instanceof Pathname ) 
		{
			Pathname path = (Pathname) object;
			return this.directories.equals(path.directories);
		}
		return false;
	}
	
	public String toString()	//convert everything to String
	{
		String str = "/";
		for (int i = 0; i <= directories.length -1; i++)
		{
			if (directories[i] != null)
				str += directories[i] + "/";
		}
		if (type != "")
		{
				str += name + "." + type;
		}
		else
		{
			str += name;
		}
		return str;
	}
}

class Pathfinder  
{  
  public static void main(String [] args)  
  {  
    Pathname p0 = new Pathname("coffee", "java");  
    p0.addDirectory("home");  
    p0.addDirectory("Desktop");  
    p0.addDirectory("labs");  
    System.out.println(p0);    
  
    Pathname p1 = new Pathname("cola");  
    p1.addDirectory("home");  
    p1.addDirectory("hax");  
    System.out.println(p1);  
  
    Pathname p2 = new Pathname("tea");  
    System.out.println(p2);   
  
    System.out.println(p0.equals(p0));                
    System.out.println(p0.equals(p1));                 
    System.out.println(p1.equals(p2));                 
    System.out.println(p0.equals("Not a pathname"));  
  }  
}
