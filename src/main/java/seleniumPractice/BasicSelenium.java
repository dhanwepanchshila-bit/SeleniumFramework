package seleniumPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicSelenium {
	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeSuite
	public void setUpDB()
	{
		System.out.println("DB Connected");
	}
	@BeforeClass
	public void BrowserConfiguration()
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ec1003au\\Documents\\SeleniumServer\\chromedriver.exe");
		 driver = new ChromeDriver();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@BeforeMethod
	public void loginToApp()
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/dropdown");

		driver.manage().window().maximize();
		
	}
	
	
	
	@Test(enabled=false)
	public void testApp()
	{
		System.out.println("App open Succesfully");
		driver.getTitle();
		driver.getCurrentUrl();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com");
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
		
//		//Set Size
//	    Dimension d = new Dimension(1280, 890);
//	    driver.manage().window().setSize(d);
//	    
//	    //Set Position
//	    
//	    Point p = new Point(200, 78);
//	    driver.manage().window().setPosition(p);
//	    
	    System.out.println(driver.manage().window().getSize());
	    System.out.println(driver.manage().window().getPosition());
	    
	}
	
	@Test(enabled=false)
	public void loginToFb() {
	   
	   WebElement email =  driver.findElement(By.xpath("//input[@name='email']"));
	   WebElement pass =  driver.findElement(By.xpath("//input[@name='pass']"));
	   WebElement loginBtn =  driver.findElement(By.xpath("//span[text()='Log in']"));
	   
	   if(email.isEnabled()) {
	   email.sendKeys("p@gmail.com");
	   }
	   if(pass.isDisplayed()) {
	   pass.sendKeys("233455");
	   }
	  
	  // loginBtn.submit();
	   pass.clear();
	   
	 }
	@Test(enabled=false)
	public void createAccount() throws InterruptedException
	{
	

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
//		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
//		js.executeScript("arguments[0].click;", dropdown);
//		//dropdown.click();
//		
//		Thread.sleep(2000);
		Select s = new Select(dropdown);
//		s.selectByIndex(2);
//		Thread.sleep(3000);
//		js.executeAsyncScript("arguments[0].click();", dropdown);
//		s.selectByVisibleText("Option 1");
//		
		List<WebElement> list = s.getOptions();
		System.out.println(list.size());
		WebElement first = s.getFirstSelectedOption();
		System.out.println(first.getText());
		
		for(WebElement o:list)
		{
			System.out.println(o.getText());
		}
		
		if(s.isMultiple())
		{
			System.out.println("list box is multiselectable");
		}
		else {
			System.out.println("list box is not multiselectable");
		}
		 
	}
	
	@Test(enabled=false)
	public void takeScreenshot() throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ec1003au\\Downloads\\SS\\ss1.jpg");
		
		FileHandler.copy(source, dest);
		
	}
	@Test(enabled=false)
	public void handleFrame()
	{
		driver.switchTo().frame("frame1"); //switch to frame
		//addbtn.click();
		driver.switchTo().parentFrame(); //one frameback
		driver.switchTo().defaultContent();//switch to main page
	}
	@Test(enabled=false)
	public void handlealertPopup()
	{
		Alert alt = driver.switchTo().alert();
		
		alt.accept();
		alt.dismiss();
		alt.getText();
	}
	@Test(enabled=false)
	public void getWindowHandles()
	{
		String parentwindow = driver.getWindowHandle();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		for(String window:allWindowHandles)
		{
			if(!window.equals(parentwindow))
			{
				driver.switchTo().window(window);
			}
		}
		
	}
	@Test(enabled=false)
	public void handleActionClass()
	{
		//1.identify dropdwon element
		WebElement login = driver.findElement(By.xpath("login"));
		//2.create an object of action class with webdriver as input
		Actions act = new Actions(driver);
		//call action class method
		act.moveToElement(login).perform(); //mouse over to element
		act.contextClick(login).perform(); //right click on element
		act.doubleClick(login).perform(); //double click on element
		WebElement source = driver.findElement(By.id("drag"));
		WebElement target = driver.findElement(By.id("drop"));
		act.dragAndDrop(source, target).perform();

		act.sendKeys(Keys.CONTROL + "a").perform();
		act.sendKeys(Keys.DELETE).perform();
		
		act.moveToElement(login).contextClick().doubleClick().perform();

	}
	@Test
	public void readExcelFileData() throws IOException
	{
		// 1. Excel file path
        File file = new File("C:\\Users\\ec1003au\\Downloads\\Annual Salary Details (4).xls");

        // 2. Read file
        FileInputStream fis = new FileInputStream(file);

        // 3. Workbook for .xls file
        HSSFWorkbook wb = new HSSFWorkbook(fis);

        // 4. Select sheet
        HSSFSheet sh = wb.getSheet("Sheet1");

        // 5. Total rows
        int rows = sh.getLastRowNum();

        // 6. Loop rows
        for (int i = 0; i <= rows; i++) {

            Row row = sh.getRow(i);

            // null check (important)
            if (row == null) continue;

            // 7. Total columns in row
            int cols = row.getLastCellNum();

            // 8. Loop columns
            for (int j = 0; j < cols; j++) {

                Cell cell = row.getCell(j);

                // null check
                if (cell == null) {
                    System.out.print("NULL ");
                } else {
                    System.out.print(cell.toString() + " ");
                }
            }

            System.out.println();
        }

        // 9. Close resources
        wb.close();
        fis.close();
	}
	@AfterMethod
	public void logoutFromApp()
	{
		driver.navigate().refresh();
		System.out.println("Logged out from app Succesfully");

	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		System.out.println("execution end");

	}
	@AfterSuite
	public void CloseDB()
	{
		System.out.println("DB Connecttion ends");
	}
	
	
}
