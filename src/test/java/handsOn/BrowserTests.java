/*
 1.	Open the Selenium WebDriver documentation and download the WebDriver for your preferred browsers (e.g. Chrome, Firefox, Edge).

2.	Extract the WebDriver executable for each browser and add it to your system PATH.
3.	Create a new Java project in your IDE.
4.	Add the Selenium WebDriver dependency to your project.
5.	Create a new class called BrowserTests.
6.	Create a new test method called testOpenDifferentBrowsers that does the following for each browser:
•	Creates a new instance of the WebDriver for the browser.
•	Navigates to the sample web page URL.
•	Extracts the greeting message from the page.
•	Verifies that the greeting message is correct.
•	Closes the WebDriver instance for the browser.
 */

package handsOn;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserTests {

	public static WebDriver driver = null;
	
	@Test
	public static void main(String[] args) {
		String url = "https://www.google.com";
		BrowserTests bt = new BrowserTests();
		System.out.println("Enter browserName :");
		Scanner sc = new Scanner(System.in);
		String browserName = sc.next();
		bt.testOpenDifferentBrowsers(browserName);
		driver.get(url);
		String actual = driver.getTitle();
		
		Assert.assertEquals(actual, "Google");
		driver.quit();
	}
	
	
	public void testOpenDifferentBrowsers(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser name");
		}
	}

}
