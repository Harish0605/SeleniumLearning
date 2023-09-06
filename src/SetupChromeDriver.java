import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupChromeDriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");        
        System.out.println("Title of the page is : "+driver.getTitle());
        driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("harishbanavatu@gmail.com");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("Chinni@0605");
        driver.findElement(By.xpath("//input[@value='agreeTerms']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       String error =  driver.findElement(By.xpath("//p[@class='error']")).getText();
       System.out.println(error);
        driver.quit();
	}

}
