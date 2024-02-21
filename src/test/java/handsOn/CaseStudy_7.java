/*Application Information
We will be using a web page(https://www.globalsqa.com/samplepagetest/) for this exercise.

Task: 
Use JavaScript executor to submit the form.
(Uploading file is not mandatory)
*/

package handsOn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CaseStudy_7 {

	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.globalsqa.com/samplepagetest/");
	JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
	jsExecutor.executeScript("document.getElementsByClassName('name')[1].value='yaram';");
	//jsExecutor.executeScript("document.evaluate(\"//input[@id='g2599-email']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).value='mail';");
	WebElement email = (WebElement) jsExecutor.executeScript(" return document.getElementsByClassName('email')[1];");
	email.sendKeys("mail.@gmail.com");
	jsExecutor.executeScript("document.getElementById('g2599-website').value='https://www.google.com';");
	jsExecutor.executeScript("return document.getElementById('g2599-experienceinyears').selectedIndex = '4';");
	jsExecutor.executeScript("document.getElementsByName('g2599-expertise[]')[2].click()");
	jsExecutor.executeScript("document.getElementsByName('g2599-education')[1].click();");
	
	driver.findElement(By.xpath(".//button[@onclick='myFunction()']")).click();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	Thread.sleep(3000);
	jsExecutor.executeScript("document.getElementsByName('g2599-comment')[0].value='Working on Selenium';");
	
	jsExecutor.executeScript("document.getElementsByClassName('pushbutton-wide')[0].click()");
	driver.close();
	
	

	}
}
