package seleniumLearning2;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterWithStreams {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		List<WebElement> items = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<WebElement> item = items.stream().filter(s -> s.getText().contains("Rice"))
				.collect(Collectors.toList());
		Assert.assertEquals(items.size(), item.size());
		
		driver.quit();

	}

}
