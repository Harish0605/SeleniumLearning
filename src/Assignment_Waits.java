import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment_Waits {
	public static void addMobile(WebDriver driver,String[] mobiles) {
		int mobilesCount = mobiles.length;
		List<WebElement> appCards = driver.findElements(By.cssSelector("h4[class='card-title']"));
		for(WebElement e:appCards) {
			for(String s:mobiles) {
				
				if(e.getText().contains(s)) {
					mobilesCount--;
					String beforeX = "//a[contains(text(),'";
					String afterX = "')]/parent::h4/parent::div/following-sibling::div/button";
					String xpath = beforeX+s+afterX;
					driver.findElement(By.xpath(xpath)).click();
					System.out.println("Clicked on :"+s);
					break;
				}
			}
			if(mobilesCount==0) {
				break;
			}
			
		}
		
	}
	public static void formFill(WebDriver driver,WebDriverWait wait) {
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='okayBtn']"))));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		dropdown.selectByVisibleText("Consultant");
		driver.findElement(By.xpath("//input[@name='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		formFill(driver,wait);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'btn-primary')]")));
		String[] mobiles = {"iphone","Blackberry","Samsung","Nokia"};
		addMobile(driver,mobiles);
		driver.findElement(By.xpath("//a[contains(@class,'btn-primary')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn btn-success')]")));
		WebElement checkout = driver.findElement(By.xpath("//button[contains(@class,'btn btn-success')]"));
		Assert.assertTrue(checkout.isEnabled());		
		driver.quit();

	}

}
