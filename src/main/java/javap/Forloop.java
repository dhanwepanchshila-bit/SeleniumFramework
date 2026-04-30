package javap;

public class Forloop {
	
	public static void main(String[] args) {
		
    int arr[] = {10,20,50,40,30};
    
    int firstLargest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    
    for(int num:arr)
    {
    	if(num>firstLargest)
    	{
	    	secondLargest = firstLargest;
	    	firstLargest = num;
    	}
    	
    	else if(num>secondLargest && num!=firstLargest)
    	{
    		secondLargest = num;
    	}
    	
    }
    
    System.out.println("SecondLargest= " +secondLargest);
    System.out.println("FirstLargest= " +firstLargest);

    
 }
	
}
