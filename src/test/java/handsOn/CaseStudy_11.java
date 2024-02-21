/*Application Information
We will be using a web page (https://www.globalsqa.com/demo-site/sliders/#Range) for this exercise. 

Tasks:
1.Open the URL in browser.
2.Locate the highest & lowest range in the slider.
3.Fix the price lower range to 100$ using mouse operation
4.Fix the price upper range to 400$ using mouse operation.
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

public class CaseStudy_11 {
	
	WebDriver  driver = null;
	@BeforeTest
	public void openBrowser()
	{
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.globalsqa.com/demo-site/sliders/#Range");

	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	@Test
	public void mouseHovering()
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"post-2673\"]/div[2]/div/div/div[2]/p/iframe")));
		WebElement lowestSlider = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ')][1]"));
		WebElement highestSlider = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ')][2]"));
		System.out.println("lowset slider location" + lowestSlider.getLocation());
		System.out.println("highest slider location" + highestSlider.getLocation());
		Actions action = new Actions(driver);
		action.dragAndDropBy(lowestSlider, 33, 46).build().perform();
		action.dragAndDropBy(highestSlider, 137, 46).build().perform();
	}

}
