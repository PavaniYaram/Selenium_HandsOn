/*Application Information
We will be using a web page(http://www.amazon.in) for this exercise.
Tasks:
1. Go to the URL provided.
2. Search for any one item and add it to the cart.
3. Click on the “Go to Cart” button.
4. In the cart window, delete the item that you have added to the cart.
5. Close the browser.
*/

package handsOn;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CaseStudy_5 {
	public static void main(String[] args) {

	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("http://www.amazon.in");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("trolley bags");
	driver.findElement(By.xpath("//input[@value=\"Go\"]")).click();
	driver.findElement(By.xpath("(//span[@class=\"a-size-base-plus a-color-base a-text-normal\"])[3]")).click();
	String child = null;
	Set<String> windows = driver.getWindowHandles();
	System.out.println();
	Iterator<String> it = windows.iterator();
	while(it.hasNext())
	{
		child =it.next();
	}
	driver.switchTo().window(child);
	driver.findElement(By.id("add-to-cart-button")).click();
	driver.findElement(By.xpath("//span[@id=\"sw-gtc\"]/span[@class=\"a-button-inner\"]")).click();
	driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
	driver.quit();

	}
}
