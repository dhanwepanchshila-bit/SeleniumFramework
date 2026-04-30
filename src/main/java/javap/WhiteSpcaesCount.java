package javap;

public class WhiteSpcaesCount {
	
	public static void main(String[] args) {
		
		String name = "P A N C H";
		int count = 0;
		char str;
		
		for(int i=0; i<=name.length()-1; i++)
		{
			str = name.charAt(i);
			
			if(str==' ') 
			{
				count++;
			}
		}
		
		System.out.println("number of white spaces in names = " + count);
	}
}
