/*
Application Information
We will be using a web page(http://www.google.com/) for this exercise. 

Tasks: 
1. Go to the URL provided.
2. Enter the text “Selenium” in the search box.
3. Highlight the search text box with yellow color.
4. Click on the Search button.
5. Take a screenshot of the search results page. 
6. Close the browser.
*/

package handsOn;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CaseStudy_6 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("http://google.in");
	JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
	jsExecutor.executeScript("document.getElementById('APjFqb').value='Selenium';");
	jsExecutor.executeScript("document.getElementById('APjFqb').style.background='yellow';");
	jsExecutor.executeScript("document.getElementById('APjFqb').click()");
	Thread.sleep(3000);
	TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	File destFile = new File("./Screenshot/CaseStudy-6.png");
	FileUtils.copyFile(sourceFile, destFile);
	
	}
}
