/*Application Information
We will be using a web page (https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager) for this exercise. 

Tasks:
1. Open the URL in browser.
2.Locate the element High Taras1 using XPATH
3.Drag “High Taras1” in the trash.
4.Locate the element High Taras1 using XPATH
5.Drag “High Taras3” in the trash.

 */
package handsOn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaseStudy_9 {
	
	WebDriver  driver = null;
	
	@BeforeTest
	public void openBrowser()
	{

		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
	}

	@Test
	public  void dragAndDrop() throws InterruptedException {
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"post-2669\"]/div[2]/div/div/div[1]/p/iframe")));
	//	WebElement src1 = driver.findElement(By.xpath("(//li[contains(@class,'ui-widget-content')])[1]"));
		
		WebElement src1 = driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[1]"));	
		
		WebElement dest = driver.findElement(By.xpath("//*[@id=\"trash\"]"));
		
		Actions action = new Actions(driver);
	
		action.dragAndDrop(src1, dest).build().perform();
		
		WebElement src2 =driver.findElement(By.xpath("(//li[contains(@class,'ui-widget-content')])[3]"));
		
		action.clickAndHold(src2).moveToElement(dest).release().build().perform();
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
