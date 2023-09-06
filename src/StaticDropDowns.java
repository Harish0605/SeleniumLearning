import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class StaticDropDowns {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();  
    driver.manage().window().maximize();
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    System.out.println(driver.getTitle());
    Thread.sleep(2000);
    //Static Dropdown Select Tag-- CURRENCY dropdown handling 
    String currency = "AED";
    Select CURRENCY_drpdwn = new Select(driver.findElement(By.xpath("//select[contains(@id,'DropDownListCurrency')]")));
    
    //Below are the options used to click by using Select class
    //CURRENCY_drpdwn.selectByVisibleText(currency);  
    //CURRENCY_drpdwn.selectByValue(currency);
    //CURRENCY_drpdwn.selectByIndex(1);   
   
   
    //Selecting the option by using List class 
    List<WebElement> CURRENCY_options=CURRENCY_drpdwn.getOptions();
    
    Thread.sleep(2000);
    for(WebElement e:CURRENCY_options) {
    String currency_list = e.getText();
    if(currency_list.equalsIgnoreCase(currency)) {
    	e.click();  
    	 	}
    }
    
    System.out.println(CURRENCY_drpdwn.getFirstSelectedOption().getText());
    


    driver.quit();
	}

}
