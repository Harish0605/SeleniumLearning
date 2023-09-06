package seleniumLearning2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentDynamicCheckbox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).click();
		String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		Select Dropdown = new Select(driver.findElement(By.cssSelector("select#dropdown-class-example")));
		Dropdown.selectByVisibleText(opt);
		driver.findElement(By.xpath("//input[@placeHolder='Enter Your Name']")).sendKeys(opt);
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		String alertText = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		driver.switchTo().alert().accept();
		if(alertText.contains(opt)) {
			System.out.println("Test case passed as expected");
		}else {
			System.out.println("Test case failed");	
		}

		driver.quit();

	}

}
