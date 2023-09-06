package seleniumLearning2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calendarUI {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver_107v.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		WebElement dateOfTravel = driver.findElement(By.cssSelector("input#form-field-travel_comp_date"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", dateOfTravel);
		Thread.sleep(2000);
		dateOfTravel.click();
		System.out.println("clicked");
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'flatpickr-calendar animate')]"))));
		String Month = "December";
		WebElement monthValue = driver.findElement(By.xpath("//div[@class='flatpickr-month']/div/span"));
		try {
			while(!monthValue.getText().contains(Month)) {
				wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='flatpickr-next-month']")));
				
				driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			}	
		}
		catch(StaleElementReferenceException ex) {
			ex.printStackTrace();
			
		}
			
		
       String day = "19";		
		try {
			List<WebElement> days = driver.findElements(By.xpath("//span[contains(@class,'flatpickr-day')]"));
			for(WebElement e:days) {
				if(e.getText().contains(day)) {
					wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'flatpickr-day')]")));
					e.click();
					break;
				}
			}	
		}
		catch(StaleElementReferenceException ex) {
			ex.printStackTrace();
			
		}
		if(dateOfTravel.getAttribute("value").split("/")[1].equals(day)) {
			System.out.println("Desired value is selected : "+day);
		}else {
			System.out.println("Please check whether the day value is clickable or not");
		}		

		driver.quit();

	}

}
