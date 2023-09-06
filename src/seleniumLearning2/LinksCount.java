package seleniumLearning2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksCount {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> all_Links = driver.findElements(By.tagName("a"));
		System.out.println(all_Links.size());
		List<WebElement> footer_Links= driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		System.out.println(footer_Links.size());
		List<WebElement> footer_Section1= driver.findElements(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]//a"));
		System.out.println(footer_Section1.size());
		List<WebElement> footer_Section1_Links= driver.findElements(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul/li/following-sibling::li//a"));
		System.out.println(footer_Section1_Links.size());
		String parentWindow = driver.getWindowHandle();
		
//		for(WebElement e:footer_Section1_Links) {
//			String clickOnLInk=Keys.chord(Keys.CONTROL,Keys.ENTER);	
//			e.sendKeys(clickOnLInk);
//			
//		}
		Set<String> childWindows = driver.getWindowHandles();
		Iterator<String> itr = childWindows.iterator();
		while(itr.hasNext()) {
		String child = itr.next();
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());			
		}
		driver.switchTo().window(parentWindow);
		
		driver.quit();

	}

}
