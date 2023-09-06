import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarSelection {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.getTitle());

		// driver.findElement(By.xpath("//input[contains(@id,'rbtnl_Trip_1')]")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[contains(text(),'BLR')]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[contains(text(),'MAA')]"))
				.click();

		WebElement Dep_date = driver
				.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight')]"));
		Dep_date.click();
		// check whether the element is enabled or not
		// Sometimes isEnabled will not work properly
		// in that case, carefully watch the attribute that changes and put a check
		// point on it

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"));
		driver.findElement(By.xpath("//input[contains(@id,'rbtnl_Trip_1')]")).click();
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Its Enabled");
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);

		}

		driver.quit();

	}

}
