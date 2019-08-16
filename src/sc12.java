import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class sc12 {
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

		driver.findElement(By.xpath("//li[@class=\"menuparent repb nav-goldmine-link\"]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class=\"form-submit text-center auto-filled\"]/input")).click();

		WebElement error = driver.findElement(By.id("Email_error"));
		String err = error.getText();
		if (err == "Email is required") {

		}
		System.out.println("error is displayed " + err);

		driver.close();

	}

}