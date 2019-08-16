import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class sc6 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}

	@Test
	public static void M() throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.bluestone.com/");
		Thread.sleep(2000);

		driver.findElement(By.id("search_query_top_elastic_search")).sendKeys("Rings", Keys.ENTER);
		driver.findElement(By.xpath("//section[@class=\"block\"]/span")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[@class=\"form-item \"]/descendant::span[@data-displayname=\"below rs 10000\"]"))
				.click();
		Thread.sleep(3000);
		List<WebElement> ele = driver.findElements(By.xpath("//span[@class=\"p-wrap\"]"));
		int count = 0;
		for (WebElement l1 : ele) {
			System.out.println(l1.getText());
			count++;

		}
		System.out.println("The number of rings are " + count);
driver.close();
	}
}