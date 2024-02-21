/*Application Information
We will be using a web page (https://www.globalsqa.com/demo-site/frames-and-windows/) for this exercise.

Tasks:
1. This application runs on multiple windows. Click on “Open New Window” and then click on “Click Here”.
2. Handle the new window.
3. Check If the new window id is different from the parent window id.

*/
package handsOn;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaseStudy_10 {

	WebDriver  driver = null;
	@BeforeTest
	public void openBrowser()
	{
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");

	}
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}

	@Test
	public void windowhandles() throws InterruptedException
	{
		driver.findElement(By.id("Open New Window")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"post-2632\"]/div[2]/div/div/div[2]/a")).click();
		//driver.findElement(By.xpath("(//a[contains(@class,'button')])[1]")).click();
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windows);
		driver.switchTo().window(list.get(1));
		String parentId = list.get(0);
		String childId = list.get(1);
		if(parentId.equals(childId))
		{
			System.out.println("parentId and child Id are same");
		}
		else
		{
			System.out.println("ParentId and child Id are different");
		}
	}
}
