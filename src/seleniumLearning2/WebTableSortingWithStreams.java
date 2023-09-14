package seleniumLearning2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebTableSortingWithStreams {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@class='cart-header-navlink' and contains(text(),'Top Deals')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!childWindow.equals(parentWindow)) {
				driver.switchTo().window(childWindow);
				WebElement sortButton = driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']"));
				wait.until(ExpectedConditions.visibilityOf(sortButton)).click();

				// capture all WebElements into list
				List<WebElement> initialTable = driver.findElements(By.xpath("//tbody/tr/td[1]"));
				// convert List of WebElements to List of String using stream
				List<String> originalList = initialTable.stream().map(k -> k.getText()).collect(Collectors.toList());
				// sort the original list and store it in another list
				List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
				// check if the actual and expected are true
				Assert.assertTrue(originalList.equals(sortedList));

				driver.quit();

			}
		}

	}

}
