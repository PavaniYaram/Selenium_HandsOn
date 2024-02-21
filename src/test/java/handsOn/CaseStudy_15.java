/*Application Information
We will be using a web page (https://phptravels.org/login) for this exercise.

Tasks:
1.	Go to the URL given above.
2.	Enter username and password by using data provider annotation.
3.	Execute the same test case for at least 3 different sets of data.
4.	Capture the error message for each set of data and display it in the console.
5.	Close the browser.
*/

package handsOn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CaseStudy_15 {

	
	WebDriver driver;
	@BeforeClass
	public void setUP()
	{
		 driver = new ChromeDriver();
		 driver.get("https://phptravels.org/login");
			driver.manage().window().maximize();
	}
	@Test(dataProvider="dataprovider")
	public void test(String email, String  password)
	{
		
		driver.findElement(By.name("username")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		String errorMsg=driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/div[1]/div/form/div/div[1]/div[2]")).getText();

        System.out.println(errorMsg);
		
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider(name="dataprovider")
	String[][] loginData()
	{
		String data[][] = {
				{"name@gmail.com","test123"},
				
				{"pavani@gmail.com","t7gdjhh"},
				{"name12@gmail.com","testghj123"}
			};
		return data;
		}
		
	}

