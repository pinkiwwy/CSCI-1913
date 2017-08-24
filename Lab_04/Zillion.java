//Author: Wing Yi (Pinki) Wong

package Zillion;

class Zillion 
{
	private int[] digit;	//create a private array of integers
	
	public Zillion(int size)	//Constructor
	{
		if (size >= 0)
		{
			digit = new int[size];	//create an array of size integer	
		}
	}
	
	public void increment()		//Increment the counter, no return with void
	{
		int counter = digit.length - 1;
		while (counter>=0 && digit[counter]==9)
		{
			digit[counter] = 0;
			
			counter = counter - 1;
		}
		
		if (counter >= 0)
		{
			digit[counter] = digit[counter] +1;
		}
		
	}
	public String toString()	//convert everything to String
	{
		String str ="";
		for (int i=0; i<digit.length; i++)
		{
			str = str + digit[i];
		}
		return str;
	}
}

class Driver
{
	public static void main (String [] arg)
	{
		Zillion z = new Zillion(3);
		z.increment();
		z.increment();
		System.out.println(z);
		
		Zillion n = new Zillion(3);
		for (int i = 1; i <= 99; i++)
		{
			n.increment();
		}
		System.out.println(n);
		n.increment();
		System.out.println(n);
	}
}
