package seleniumLearning2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// above
		WebElement inputName = driver
				.findElement(By.xpath("//input[contains(@class,'form-control') and @name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(inputName)).getText());
		
		//below
		driver.findElement(with(By.tagName("input")).below(By.xpath("//label[@for='dateofBirth']"))).sendKeys("01012001");
		
		driver.findElement(By.xpath("//input[contains(@class,'btn-success')]")).click();
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText());
		driver.close();

	}

}
