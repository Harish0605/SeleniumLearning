import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Locators2 extends Drivers {
	public static String Password(String s) {
		        String output = s.split("'")[1];
        return output;
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Locators2.Chrome();
		
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");        
        System.out.println("Title of the page is : "+driver.getTitle());
        driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Reset Login')]")).click();
        String output = Password(driver.findElement(By.xpath("//p[contains(@class,'infoMsg')]")).getText());
        driver.findElement(By.xpath("//button[contains(text(),'Go to Login')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("harishbanavatu@gmail.com");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(output);
        driver.findElement(By.xpath("//input[@value='agreeTerms']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//button[contains(text(),'Log Out')]")).click();
        driver.quit();
        
        

	}

}
