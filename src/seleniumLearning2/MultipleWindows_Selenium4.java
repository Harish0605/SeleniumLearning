package seleniumLearning2;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindows_Selenium4 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		String courseTitle = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

		// Open a new Window/Tab
		driver.switchTo().newWindow(WindowType.TAB);

		// Focus will still be with Parent Window

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> itr = windowHandles.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		// focus shifted to child window
		driver.switchTo().window(childWindow);
		// Switch to this page
		driver.get("https://rahulshettyacademy.com/");
		// Scroll to the element
		WebElement courseHeader = driver.findElement(By.xpath("//h2[contains(text(),'Featured Courses')]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", courseHeader);
		WebElement course = driver.findElements(By.xpath("//div[@class='image']/a/img")).get(0);
		System.out.println(courseTitle = course.getAttribute("alt"));

		// switch to parent window
		driver.switchTo().window(parentWindow);
		WebElement inputName = driver
				.findElement(By.xpath("//input[contains(@class,'form-control') and @name='name']"));
		wait.until(ExpectedConditions.visibilityOf(inputName));

		// Enter in the Name field
		inputName.sendKeys(courseTitle);

		 driver.quit();

	}

}
