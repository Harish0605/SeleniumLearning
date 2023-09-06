package seleniumLearning2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//legend[contains(text(),'Web Table Example')]")));
		// Scenario 1 - Print Number of rows in the webtable
		List<WebElement> rows = driver.findElements(
				By.xpath("//legend[contains(text(),'Web Table Example')]/following-sibling::table/tbody/tr"));
		System.out.println(rows.size());
		// Scenario 2 - Print number of columns in webtable
		List<WebElement> columns = driver.findElements(
				By.xpath("//legend[contains(text(),'Web Table Example')]/following-sibling::table/tbody/tr/th"));
		System.out.println(columns.size());
		// Scenario 3 - Print 2nd row content
		List<WebElement> rowContent = driver.findElements(
				By.xpath("//legend[contains(text(),'Web Table Example')]/following-sibling::table/tbody/tr[3]/td"));
		for (WebElement e : rowContent) {
			System.out.println(e.getText());
		}
		driver.quit();

	}

}
