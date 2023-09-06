package seleniumLearning2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[contains(@class,'ui-autocomplete-input')]")).sendKeys("ind");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(
				By.xpath("//ul[contains(@class,'ui-menu ui-widget ui-widget-content ui-autocomplete ui-front')]"))));
		List<WebElement> options = driver.findElements(By.xpath(
				"//li[@class='ui-menu-item']/div"));
		for (WebElement e : options) {
			if (e.getText().contains("Indonesia")) {
				e.click();				
				break;
			}
		}
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		
		driver.quit();

	}

}
