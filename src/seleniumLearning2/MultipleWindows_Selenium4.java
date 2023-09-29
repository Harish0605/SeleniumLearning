package seleniumLearning2;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindows_Selenium4 {
	
	//To Invoke a new window
//	By using Selenium 4 - driver.switchTo().newWindow(WindowType.TAB);
//	By using Selenum 3 - ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		String courseTitle = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

//		// Open a new Window/Tab
//		driver.switchTo().newWindow(WindowType.TAB);
//
//		// Focus will still be with Parent Window
//
//		Set<String> windowHandles = driver.getWindowHandles();
//		Iterator<String> itr = windowHandles.iterator();
//		String parentWindow = itr.next();
//		String childWindow = itr.next();
//		// focus shifted to child window
//		driver.switchTo().window(childWindow);
//		// Switch to this page
//		driver.get("https://rahulshettyacademy.com/");
//		// Scroll to the element
//		WebElement courseHeader = driver.findElement(By.xpath("//h2[contains(text(),'Featured Courses')]"));
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].scrollIntoView();", courseHeader);
//		WebElement course = driver.findElements(By.xpath("//div[@class='image']/a/img")).get(0);
//		System.out.println(courseTitle = course.getAttribute("alt"));
//
//		// switch to parent window
//		driver.switchTo().window(parentWindow);
//		WebElement inputName = driver
//				.findElement(By.xpath("//input[contains(@class,'form-control') and @name='name']"));
//		wait.until(ExpectedConditions.visibilityOf(inputName));
//
//		// Enter in the Name field
//		inputName.sendKeys(courseTitle);
//
//		 driver.quit();
//		 
		// Approach-2
		// Assuming you've already set up your WebDriver instance and navigated to a
		// webpage.

		// Execute JavaScript to open a new tab
		((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");

		// Switch to the new tab
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		// Now you are in the new tab. You can navigate to a URL or perform actions in
		// this tab.
		driver.get("https://rahulshettyacademy.com");

		// Scroll to the element
		WebElement courseHeader = driver.findElement(By.xpath("//h2[contains(text(),'Featured Courses')]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", courseHeader);
		WebElement course = driver.findElements(By.xpath("//div[@class='image']/a/img")).get(0);
		System.out.println(courseTitle = course.getAttribute("alt"));

		// If you want to switch back to the original tab, you can do so by switching to
		// the appropriate index in the 'tabs' list.
		driver.switchTo().window(tabs.get(0));
		WebElement inputName = driver
				.findElement(By.xpath("//input[contains(@class,'form-control') and @name='name']"));
		wait.until(ExpectedConditions.visibilityOf(inputName));

		// Enter in the Name field
		inputName.sendKeys(courseTitle);

		driver.quit();

	}

}
