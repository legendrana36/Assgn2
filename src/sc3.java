import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class sc3 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}

	@Test
	public static void M1() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https:www.bluestone.com");
		Actions a= new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//li[@class=\"menuparent gold-coins\"]"));
		a.moveToElement(ele).perform();
		driver.findElement(By.xpath("//span[@data-p=\"l-gold-coins-weight-2gms,m\"]")).click();
		String path= driver.findElement(By.xpath("//h1[@class=\"title-5\"]")).getText();
		System.out.println(path);
		driver.close();
	}
}
