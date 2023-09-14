package seleniumLearning2;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationWithStreams {

	private static String getVeggiePrice(WebElement s) {
		String amount = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return amount;
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<String> price;
		do {
			List<WebElement> items = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			// Iterating the list and printing the price of a vegetable
			price = items.stream().filter(s -> s.getText().equalsIgnoreCase("Almond")).map(s -> getVeggiePrice(s))
					.collect(Collectors.toList());
			price.stream().forEach(s -> System.out.println(s));
			if (price.size() < 1) {
				WebElement nextButton = driver.findElement(By.xpath("//a[contains(@aria-label,'Next')]"));
				nextButton.click();
			}
		} while (price.size() < 1);

		driver.quit();

	}

}
