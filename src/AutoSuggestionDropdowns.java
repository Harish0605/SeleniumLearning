import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class AutoSuggestionDropdowns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();  
	    driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    System.out.println(driver.getTitle());
	    
	    //Handle Auto suggestion Dropdowns
	   
//       driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
//       Thread.sleep(2000);
//       List<WebElement> li = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
//       for(WebElement e:li) {
//    	   String country = e.getText();
//    	   if(country.equalsIgnoreCase("indonesia")) {
//    		  e.click();
//    		  System.out.println("clicked on :"+country);
//    		  break;
//    	   }
//       }
       
       //Handling checkboxes
	    WebElement Friends_Family = driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]"));
	    Friends_Family.click();
	    Assert.assertTrue(Friends_Family.isSelected());
	    List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	    System.out.println(checkboxes.size());
	    int count =0;
	    for(WebElement ch:checkboxes) {
	    	if(ch.isSelected()) {
	    		ch.click();
	    		count++;
	    	}
	    }
	    System.out.println(count);
	    
	    
       
       
       driver.quit();
       
       
	}

}
