import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class sc13 {
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		driver.findElement(By.xpath("//div/span[@class='subscribe']")).click();

		String mnth = "1000";
		String em = "bhakuakukura@gmail.com";
		driver.findElement(By.xpath("//input[@id='amount']")).sendKeys(mnth);
		driver.findElement(By.xpath("//div[@class='form-group']/descendant::input[@id='Email']")).sendKeys(em);
		driver.findElement(By.xpath("//input[@id='gmsStart']")).click();
		Thread.sleep(2500);

		WebElement entered = driver.findElement(By.id("email"));
		System.out.println(entered.getAttribute("value"));
		WebElement amount = driver.findElement(By.xpath("//span[@class=\"subscription-amount subscribed-amount\"]"));
		System.out.println(amount.getText());

		Thread.sleep(2000);

		Thread.sleep(2000);
		driver.close();
	}
}