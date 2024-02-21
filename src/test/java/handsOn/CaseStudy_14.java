/*Application Information
We will be using a web page (http://www.flipkart.com/) for this exercise.

Tasks:
1.	Go to the URL given above.
2.	Search for “Sony headphones” in the search box.
3.	Click on the book “SONY ZX110A Wired without Mic Headset” from the list of headphones in the search result. 
4.	Click on “Add to cart” option to buy the item from Flipkart site.
5.	Using TestNG assertions verify the Model name and number in the Add to cart page under product details. If the names match, print “Item name matched” in the console.
6.	Click on place order.
7.	Close the browser.
*/
package handsOn;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaseStudy_14 {
	
	WebDriver driver = null;
	String actualname = "SONY ZX110A Wired without Mic Headset";
	
	@BeforeClass
	public void invokingBrowser() throws InterruptedException
	{
		driver = new ChromeDriver();
	
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
	}
	@Test(priority=0)
	public void searchMethod() {
		WebElement searchItem = driver.findElement(By.name("q"));
		searchItem.sendKeys("Sony headphones");
		searchItem.sendKeys(Keys.ENTER);
	}
	@Test(priority = 1)
	public void clicksearchItem() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500);");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title = 'SONY ZX110A Wired without Mic Headset']")).click();
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windows);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	}
	@Test(priority = 2)
	public void verifyModelName() throws InterruptedException
	{
		
		Thread.sleep(3000);
		String Modelname = driver.findElement(By.xpath("//div[@class='_2-uG6-']/a")).getText();
		Assert.assertEquals(actualname, Modelname);
		if(actualname== Modelname)
		{
			System.out.println("Item name matched");
		}
		else
		{
			System.out.println("Item name is not matched");
		}
		
		driver.findElement(By.xpath("//span[text()='Place Order']")).click();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
