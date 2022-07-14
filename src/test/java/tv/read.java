package tv;



import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class read {
	

	

	public static void main(String[]args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	driver.get("http://www.amazon.com");
	driver.manage().window().maximize();
	WebElement sear=driver.findElement(By.name("field-keywords"));
	sear.sendKeys("samsung TV",Keys.ENTER);
	Thread.sleep(2000);
	WebElement tv=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
	
	String parent=driver.getWindowHandle();
	Set<String>child=driver.getWindowHandles();
	for(String x:child) {
		if(!parent.equals(x)) {
			driver.switchTo().window(x);
			
		}
	}
	
	tv.click();
	
    TakesScreenshot tk=(TakesScreenshot) driver;
	File type=tk.getScreenshotAs(OutputType.FILE);
	File dest=new File("E:\\Users\\5767\\eclipse-workspace\\tv\\saving\\samsung.jpg");
	FileUtils.copyFile(type,dest);
	
	}

}
