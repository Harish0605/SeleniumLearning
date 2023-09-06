import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_Form {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();  
	    driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/angularpractice/");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//label[contains(text(),'Name')]/following-sibling::input")).sendKeys("Testharish");
	    driver.findElement(By.xpath("//label[contains(text(),'Email')]/following-sibling::input")).sendKeys("sample@gmail.com");
	    driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("Welcome@123");
	    driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
	    Select Gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
	    Gender.selectByVisibleText("Female");
	    driver.findElement(By.id("inlineRadio1")).click();
	    driver.findElement(By.name("bday")).sendKeys("06051995");
	    driver.findElement(By.cssSelector("input[type='submit']")).submit();
	    String success = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText();
	    System.out.println(success);
	    

	}

}
