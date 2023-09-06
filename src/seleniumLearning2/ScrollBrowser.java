package seleniumLearning2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ScrollBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement table = driver.findElement(By.xpath("//legend[contains(text(),'Web Table Fixed header')]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", table);
		int sumOfAmount =0;
		String expectedAmount = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		int expectedTotal = Integer.parseInt(expectedAmount);
		System.out.println(expectedTotal);
		List<WebElement> Amount = driver.findElements(By.xpath("//div/table[@id='product']/tbody/tr/td[4]")); 
		for(WebElement e:Amount) {
			int value = Integer.parseInt(e.getText());
			sumOfAmount=sumOfAmount+value;			
		}
		System.out.println("Total sum of Amounts :"+sumOfAmount);
		Assert.assertEquals(sumOfAmount, expectedTotal);

		driver.quit();
		
		
		
		
		

	}

}
