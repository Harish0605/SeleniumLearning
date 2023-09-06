import org.openqa.selenium.WebDriver;

public class Locators3 extends Drivers {

	public static void main(String[] args) {
		WebDriver driver =Locators3.Chrome();
		 driver.manage().window().maximize();
	     driver.get("https://rahulshettyacademy.com/locatorspractice/");        
	     System.out.println("Title of the page is : "+driver.getTitle());
	     driver.quit();

	}

}
