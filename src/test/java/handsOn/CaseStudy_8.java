/*Application Information
We will be using a web page (http://demo.seleniumeasy.com/javascript-alert-box-demo.html) for this exercise. 



Tasks:
1. Open the URL in browser.
2. Locate the element “click me” button
3. Click on “click me” button.
4. Handel the alert.
5. Click “ok” on the alert box.
*/
package handsOn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CaseStudy_8 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
	
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Pavani");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		System.out.println("alert");
		driver.close();
		

	}

}
