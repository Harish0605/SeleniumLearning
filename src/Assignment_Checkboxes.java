import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_Checkboxes {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();  
	    driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    
	    WebElement Checkbox1 = driver.findElement(By.cssSelector("input[id='checkBoxOption1']"));
	    System.out.println(Checkbox1.isSelected()); //false
	    if(!Checkbox1.isSelected()) {
	    	 Checkbox1.click();
	    	
	    }
	    System.out.println(Checkbox1.isSelected()); // true
	    if(Checkbox1.isSelected()) {
	    	 Checkbox1.click();
	    	
	    }
	    System.out.println(Checkbox1.isSelected()); //false
	  
	    int count =driver.findElements(By.cssSelector("input[type='checkbox']")).size();
	    System.out.println(count);
	    driver.quit();

	}

}
