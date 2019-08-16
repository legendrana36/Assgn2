

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class sc7 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}

	@Test
	public void m() throws InterruptedException {
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
		a.moveToElement(driver.findElement(By.xpath("//div/span[@data-tagcategory=\"Delivery Time\"]")));
		WebElement count = driver.findElement(By.xpath("//div/span[@data-tagcategory=\"Delivery Time\"]/span[@class=\"items-count\"]"));
		System.out.println("No. of items available for next day delivery: "+count.getText());
		Thread.sleep(2000);
		driver.close();
	}
}