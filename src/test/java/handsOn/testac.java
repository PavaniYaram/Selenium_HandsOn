package handsOn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class testac {

	public static  List<WebElement> statusList;
	public static WebElement element;
 	public static void main(String[] args) {
 		
 		WebDriver driver = new EdgeDriver();
 		driver.manage().window().maximize();
 		driver.get("https://webapps.tekstac.com/Handling_Reg_Expression/");
 		driver.findElement(By.id("userId")).sendKeys("Shamili");
 		driver.findElement(By.id("track")).click();
 		String[] shipmentId = driver.findElement(By.xpath("//div[@id='result']")).getText().split("Phone");
 				System.out.println(shipmentId[0]);
 				String[] ship = shipmentId[0].split("Shamili");
 				System.out.println(ship[1]);
 		
 	}
 	}
 		
 		
	
