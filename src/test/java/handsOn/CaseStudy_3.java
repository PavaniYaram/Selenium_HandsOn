/*
Application Information
We will be using a web page(http://www.amazon.in/) for this exercise. 
Tasks:

1. Go to the URL provided.

2. Locate the search text box and enter “Redmi note 12”. 
3. Click on the search button.
4. Select price range as “10000 - 20000” and select Top brands check box.
5. Choose the first model displayed and fetch the name of the model and display it in the console.
6. Close the browser.
*/

package handsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaseStudy_3 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi note 12");
		driver.findElement(By.xpath("//input[@value=\"Go\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"₹10,000 - ₹20,000\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Top Brands']")).click();
		String modelName = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).getText();
		System.out.println(modelName);
		driver.quit();
	}

}
