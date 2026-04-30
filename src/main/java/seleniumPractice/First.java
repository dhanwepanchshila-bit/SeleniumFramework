package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.itextpdf.text.log.SysoCounter;

public class First {
	

	@Test()
	public void execute() throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
//		String title = driver.getTitle();
//		String url = driver.getCurrentUrl();
//		System.out.println(title);
//        System.out.println(url);
//        if(title.contains("Facebook"))
//        {
//        	System.out.println("Welcome Page is displayed");
//        }
//        else {
//        	System.out.println("page not found");
//        }
//		//driver.close();
//        //driver.quit();
//        
//        driver.navigate().to("https://Google.com");
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();
//        driver.manage().window().maximize();
//        driver.manage().window().minimize();
//		
//		Dimension d = new Dimension(100, 200);
//		driver.manage().window().setSize(d);
//		
//		Point p = new Point(200, 200);
//		driver.manage().window().setPosition(p);
		
		//task
//		
//		Thread.sleep(2);
//		String title = driver.getTitle();
//		System.out.println(title);
//		
//		driver.get("https://www.facebook.com");
//		String url = driver.getCurrentUrl();
//		System.out.println(url);
//		
//		Thread.sleep(2000);
//		driver.get("https://instagram.com");
//		Thread.sleep(3000);
//		driver.navigate().back();
//		
//		if(url.contains("facebook"))
//		{
//			System.out.println("facebook page is displayed");
//		}else {
//			System.out.println("fb page not displayed");
//			
//		}
//		Thread.sleep(3000);
//		Dimension d = new Dimension(300,300);
//		driver.manage().window().setSize(d);
//		
//		Thread.sleep(3000);
//		Point p = new Point(400,300);
//		driver.manage().window().setPosition(p);
//		
//		Thread.sleep(2000);
//		driver.manage().window().maximize();
//		
//		Thread.sleep(2000);
//		driver.navigate().forward();
//		if(driver.getCurrentUrl().contains("yatra")){
//			System.out.println("yatra page is displayed");
//		}else {
//			System.out.println("yatra page not displayed");
//			
//		}
//		
//		Thread.sleep(2000);
//		driver.navigate().refresh();
//		Thread.sleep(2000);
//		driver.close();
//		
//		WebElement email = driver.findElement(By.xpath("hhhhhh"));
//		email.sendKeys("ghgjhjkm");
//		email.click();
//		email.clear();
//		String text = email.getText();
//		email.isDisplayed();
//		email.isEnabled();
//		email.isSelected();
//		email.submit();
//		email.getTagName();
		
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement crtAcc = driver.findElement(By.xpath("//span[text()='Create new account']"));
		
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOf(crtAcc));
		crtAcc.click();
		
        
		WebElement day = driver.findElement(By.xpath("//span[text()='Day']/following::div[1]"));
		Thread.sleep(5);
		wait.until(ExpectedConditions.elementToBeClickable(day));
		Thread.sleep(10);

		day.click();
		Thread.sleep(10);
		Select s = new Select(day);
//		s.selectByIndex(1);
//		s.selectByValue("6");
//		s.selectByVisibleText("4");
//		
		List<WebElement> list = s.getOptions();
		list.size();
		System.out.println(list);

		
		}
	
	}
	


