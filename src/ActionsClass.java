import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions act = new Actions(driver);
		//hover over = moveToElement
		//act.moveToElement(driver.findElement(By.cssSelector("a#nav-link-accountList"))).build().perform();
		//driver.findElement(By.xpath("//span[text()='Orders']/parent::a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))));
		WebElement search_box = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		//act.moveToElement(search_box).click().keyDown(Keys.SHIFT).sendKeys("Iphone").doubleClick().build().perform();
		System.out.println(driver.getTitle());
		driver.quit();
	

	}

}
