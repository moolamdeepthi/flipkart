package flipkart;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Openflipkart {
	public	 WebDriver driver = new FirefoxDriver();
	public String expectedTitle = null;
	public String actualTitle = null;

	@BeforeMethod      

	public void page() throws AWTException{
		Robot newtab = new Robot();
		newtab.keyPress(KeyEvent.VK_CONTROL);
		newtab.keyPress(KeyEvent.VK_T);
		newtab.keyRelease(KeyEvent.VK_CONTROL);
		newtab.keyRelease(KeyEvent.VK_T);
	}
	@Test(priority=1)
	public void flipkart(){
		driver.get("http://www.flipkart.com");
		driver.findElement(By.xpath("//input[@id='fk-top-search-box']")).sendKeys("sdn books");;
		//driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='fk-header-search-form']/div/div/div[2]/input[1]")).click();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("Z:\\scr\\flipkart.jpG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("flipkart opened");
		System.out.println("sdn books displayed");
		System .out.println("selected the book");
		System.out.println("Test completed");
		System.out.println("End");
	}


}
