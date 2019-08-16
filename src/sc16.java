import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class sc16 {
	static {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
	}

	@Test
	public static void M1() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https:www.bluestone.com");
		Actions a= new Actions(driver);
		driver.findElement(By.xpath("//a[@title=\"Gold Mine 10+1 Monthly Plan\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"amount\"]")).sendKeys("2000");
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("ranadhamana18@gmail.com");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//input[@class=\"required min-length_10 numeric text-input form-control mobile-char mobile-number \"]")).sendKeys("9438533819");;
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys("Soumya Ranjan Rana");
		driver.findElement(By.xpath("//textarea[@id=\"address\"]")).sendKeys("Oro Pharmaceuticals jagatpur, cuttack");
		driver.findElement(By.xpath("//input[@name=\"postcode_delivery\"]")).sendKeys("560037");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"nomineeName\"]")).sendKeys("MO BANDA RA ICHA");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		 TakesScreenshot ts = (TakesScreenshot)driver;
		    File ss = ts.getScreenshotAs(OutputType.FILE);
		    File ff = new File("./screenshot/paymentpage.png");
		    Files.copy(ss, ff);
		String path=driver.getTitle();
		System.out.println(path);
		
		
		
		
	}
}
