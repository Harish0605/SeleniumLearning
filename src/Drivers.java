import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {
	
	public static WebDriver Chrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    return driver;
	}
	
	
	

}
