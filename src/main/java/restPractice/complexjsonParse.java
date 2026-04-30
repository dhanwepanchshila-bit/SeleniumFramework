package restPractice;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class complexjsonParse {

	public static void main(String[] args) {
		
		int sum = 0;
		
		JsonPath js = new JsonPath(Payload.coursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		int amount = js.getInt("dashboard.purchaseAmount");
		System.out.println(amount);
		
		String Firsttitle = js.getString("courses[0].title");
		System.out.println(Firsttitle);
		
	
		for(int i=0; i<count; i++)
		{
			String CourseTitles = js.get("courses["+i+"].title");
			 int CoursePrice = js.get("courses["+i+"].price");
			 int copies = js.get("courses["+i+"].copies");

			System.out.println(CourseTitles);
			System.out.println(CoursePrice);
			
			
			int Totalamount = CoursePrice *copies;
			System.out.println(Totalamount);
			
			sum = sum + Totalamount;
			
			

//			if(CourseTitles.equalsIgnoreCase("RPA"))
//			{
//				
//				int copies = js.getInt("courses["+i+"].copies");
//				System.out.println("copies sold by RPA course are: " +copies);
//			}
//			
		}
		
		Assert.assertEquals(sum, amount);

		

		
	}
}
