/*
  Application Information
We will be using a web page(http://www.facebook.com) for this exercise.
Tasks:

1. Go to the URL provided.
2. Click on Create New Account.
3. Fill in the first name, last name and give a 9-digit mobile number. Enter a password.
4. Select the date of birth from the drop-down using Select class.
5. Select gender and click on sign up button.
6. Fetch the error message and display it in the console.
7. Close the browser.


 */

package handsOn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

public class CaseStudy_4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//div[@class=\"_6ltg\"]/a")).click();

		driver.findElement(By.name("firstname")).sendKeys("Pavani");
		driver.findElement(By.name("lastname")).sendKeys("Yaram");
		driver.findElement(By.name("reg_email__")).sendKeys("987654321");
		driver.findElement(By.id("password_step_input")).sendKeys("Password");
		Select day= new Select(driver.findElement(By.name("birthday_day")));
		Select month= new Select(driver.findElement(By.name("birthday_month")));
		Select year= new Select(driver.findElement(By.name("birthday_year")));
		day.selectByValue("14");
		month.selectByIndex(0);
		year.selectByVisibleText("2001");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(3000);
		String errorMsg = driver.findElement(By.xpath("/html/body/div[4]/div/div/div")).getText();
		System.out.println(errorMsg);
		driver.close();

	}

}
