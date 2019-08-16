import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class sc8 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}

	@Test
	public static void M() throws InterruptedException {
		
		  ChromeOptions co = new ChromeOptions();
		  co.addArguments("--disable-notifications");
		 
		WebDriver driver = new ChromeDriver(co);
		Actions a = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.bluestone.com/");
		Thread.sleep(2000);

		driver.findElement(By.id("search_query_top_elastic_search")).sendKeys("rings", Keys.ENTER);
		WebElement ele = driver
				.findElement(By.xpath("//span[@class=\"title style-fill i-right\"]/span[contains(.,'Metal')]"));
		a.moveToElement(ele).perform();

		driver.findElement(
				By.xpath("//div[@class=\"form-items\"]/descendant::span[@data-displayname=\"plain gold/platinum\"]"))
				.click();

		
		List<WebElement> ele1 = driver.findElements(By.xpath("//span[@class=\"p-wrap\"]"));
		int count=0;
		for (WebElement items : ele1) {
			System.out.println(items.getText());
			count++;
			
		}
		System.err.println("The number of platinum rings are:"+count);
		driver.close();
		
	}

}