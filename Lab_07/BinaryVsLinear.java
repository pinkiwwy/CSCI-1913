//Wing Yi Wong

package BinaryVsLinear;

class BinaryVsLinear 
{
	public static int linearSearch(int key, int [] array)
	{
		int count = 0;
		for (int index=0; index<array.length; index+=1)
		{
	        count += 1;  
			if (array[index] == key)          //array element comparison: how many times do we do this? 
	          {
	        	  return count;     //return an comparison and stop when found the key
		      }     
		}
		return count; //if not found, return total comparison         
		

	}
	
	public static int binarySearch(int key, int [] array)
	{
			int left = 0;
		    int middle;
		    int right = array.length -1;
		    int count = 0;
		    while (true)
		    {
		    	if (left > right)     //failure case
		         {
		             middle = -1;     //-1 is the indictor
		             break;     //break stops the loop
		         }
		         else
		         { 
		        	 count += 1;		//first comparison (key<middle)
		        	 
		        	 middle = (left + right) / 2;     //divide the array into half
		             if (key < array[middle])
		             {
		            	 right = middle - 1;
		             }
		             else if (key > array[middle])
		             {
		                 count += 1; 		//second comparison (key>middle)
		            	 left = middle +1;
		             }
		             else     //no more other possibility instead of key = array[middle], so use else
		             {
		                 count += 1;		//add back the second comparison
		            	 break;     //stop the loop
		             }
		         }
		    }
		    return count;

	}
	
	public static void main(String [] args)
	{
		for (int length = 1; length <= 30; length += 1)
		{
			int[] array = new int[length];
			for (int index = 0; index < length; index += 1)
			{
				array[index] = index;
			}
			
			double linearTotal = 0.0;
			double binaryTotal = 0.0;
			for (int element = 0; element < length; element += 1)
			{
				linearTotal += linearSearch(element, array);
				binaryTotal += binarySearch(element, array);
			}
			
			double linearAverage = linearTotal / length;
			double binaryAverage = binaryTotal / length;
			System.out.println(length + " " + linearAverage + " " + binaryAverage);
		}
	}
}
