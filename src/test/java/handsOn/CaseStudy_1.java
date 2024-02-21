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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaseStudy_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new  ChromeDriver();
		driver.get("https://www.youtube.com");
		System.out.println("opening");

	}
	@Test
	public void test()

	{
		System.out.println("testng is working");
	}
}
