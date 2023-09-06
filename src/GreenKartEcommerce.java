import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartEcommerce {

	public static void addProducts(String[] products, WebDriver driver) {
		int productCount = products.length;
		List<WebElement> vegetable_items = driver.findElements(By.xpath("//h4"));
		for (WebElement e : vegetable_items) {
			for (String s : products) {
				if (e.getText().contains(s)) {
					productCount--;
					String beforeXpath = "//h4[contains(text(),'";
					String afterXpath = "')]/parent::div//button[contains(text(),'ADD')]";
					String xpath = beforeXpath + s + afterXpath;
					driver.findElement(By.xpath(xpath)).click();
					System.out.println("clicked on : " + s);
					if (productCount == 0) {
						break;
					}

				}
			}
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] products = { "Beans", "Tomato", "Carrot", "Capsicum" };
		addProducts(products, driver);

		driver.findElement(By.cssSelector("[alt='Cart']")).click();
//		WebDriverWait checkOut_wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		checkOut_wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[text()='PROCEED TO CHECKOUT']"))));
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("[placeholder='Enter promo code']"))));
		driver.findElement(By.cssSelector("[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("[class='promoInfo']"))));
		String promoCode=driver.findElement(By.cssSelector("[class='promoInfo']")).getText();
		System.out.println(promoCode);
		driver.quit();

	}

}
