//Wing Yi Wong

package Polygon;

class Shapes
{
	public static void main(String [] args)
	{
		Rectangle wrecked = new Rectangle(3,5);
		System.out.println(wrecked.area());
		System.out.println(wrecked.perimeter());
		
		Square box = new Square(7);
		System.out.println(box.area());
		System.out.println(box.perimeter());
	}
}

class Polygon 
{
	private int [] sideLengths;
	
	public Polygon(int sides, int ...lengths)
	{
		int index = 0;
		sideLengths = new int [sides];
		for (int length: lengths)
		{
			sideLengths[index] = length;
			index += 1;
		}
	}
	
	public int side(int number)
	{
		return sideLengths[number];
	}
	
	public int perimeter()
	{
		int total = 0;
		for (int index = 0; index < sideLengths.length; index += 1)
		{
			total += side(index);
		}
		return total;
	}
}

class Rectangle extends Polygon
{
	public Rectangle(int a, int b)
	{
		super(4, a, b, a, b);	//super with no dot.operator inherit constructor from Polygon
	}
	
	public int perimeter()	//inherit perimeter() from Polygon
	{
		return super.perimeter();
	}
	
	public int area()
	{
		return super.side(0)*super.side(1);	//inherit side() from Polygon
	}
	
}

class Square extends Rectangle
{
	public Square(int a)
	{
		super(a, a);	//inherit constructor from Rectangle
	}
	public int perimeter()
	{
		return super.perimeter();	//inherit perimeter() from Rectangle
	}
	
	public int area()
	{
		return super.area();	//inherit area() from Rectangle
	}
}

