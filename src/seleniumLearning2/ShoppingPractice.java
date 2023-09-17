package seleniumLearning2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingPractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//a[@class='nav-link' and contains(text(),'Shop')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'ProtoCommerce Home')]")));
		String selectItem = "Samsung Note 8";
		List<WebElement> products = driver.findElements(By.xpath("//app-card[contains(@class,'mb-3')]"));
		WebElement product = products.stream()
				.filter(item -> item.findElement(By.xpath(".//h4")).getText().equals(selectItem)).findFirst()
				.orElse(null);
		product.findElement(By.xpath("./../..//button[contains(@class,'btn')]")).click();
		WebElement checkOut = driver.findElement(By.xpath("//a[contains(@class,'btn-primary')]"));
		wait.until(ExpectedConditions.elementToBeClickable(checkOut)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn btn-success')]")))
				.click();
		WebElement countryInput = driver.findElement(By.xpath("//input[@id='country']"));
		wait.until(ExpectedConditions.visibilityOf(countryInput));
		wait.until(ExpectedConditions.elementToBeClickable(countryInput));
		countryInput.sendKeys("Serbia");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='lds-ellipsis']")));
		List<WebElement> countries = driver.findElements(By.xpath("//div[@class='suggestions']/ul/li"));
		WebElement country = countries.stream()
				.filter(input -> input.findElement(By.xpath(".//a")).getText().equals("Serbia")).findFirst()
				.orElse(null);
		country.click();
		wait.until(ExpectedConditions.invisibilityOfAllElements(countries));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='checkbox2']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'btn-success')]")))
				.click();
		WebElement successAlert = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"));
		System.out.println(wait.until(ExpectedConditions.visibilityOf(successAlert)).getText());
		driver.close();

	}

}
