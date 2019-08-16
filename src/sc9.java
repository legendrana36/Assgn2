

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class sc9 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}

	@Test
	public void M() throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.bluestone.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='search_query_top_elastic_search']")).sendKeys("Rings");
		driver.findElement(By.xpath("//input[@class='button']")).click();
		
		driver.findElement(By.xpath("//span[@class='style-fill title']")).click();
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[contains(.,'22k')]")));
		WebElement count = driver.findElement(By.xpath("//span[contains(.,'22k')]/span[@class='items-count']"));
		System.out.println("No. of 22k Pure Gold items: "+count.getText());
		Thread.sleep(2000);
		driver.close();
	}
}