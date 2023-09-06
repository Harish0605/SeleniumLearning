import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Passengers_DropDown_2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();  
	    driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    System.out.println(driver.getTitle());
	    	    
	    //Dynamic dropdown without Select tag
	    WebElement pax_drpdwn = driver.findElement(By.xpath("//div[contains(@id,'paxinfo')]"));
	    pax_drpdwn.click();
	    String afterXpath = "//parent::div/span[contains(@class,'pax-add pax-enabled')]";
	    String Adult_beforeXpath = "//span[contains(@id,'spanAudlt')]";
	    String Child_beforeXpath = "//span[contains(@id,'spanChild')]";
	    String Infant_beforeXpath = "//span[contains(@id,'spanInfant')]";
	    Thread.sleep(2000);
	    WebElement Adult = driver.findElement(By.xpath(Adult_beforeXpath+afterXpath));
	    for(int i=0;i<2;i++) {
	    	Adult.click();
	    }
	    WebElement Child = driver.findElement(By.xpath(Child_beforeXpath+afterXpath));
	    for(int i=0;i<2;i++) {
	    	Child.click();
	    }
	    WebElement Infant = driver.findElement(By.xpath(Infant_beforeXpath+afterXpath));
	    for(int i=0;i<1;i++) {
	    	Infant.click();
	    }
	    driver.findElement(By.xpath("//input[contains(@value,'Done')]")).click();
	    
	    System.out.println(pax_drpdwn.getText());
	    driver.quit();
	  
	  
	    
	    
	    
	    
	    
	    
	}

}
