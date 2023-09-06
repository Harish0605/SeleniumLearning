import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
//		driver.get("https://jqueryui.com/droppable/");
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
//		Actions act = new Actions(driver);		
//		WebElement src = driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
//		WebElement target = driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
//		System.out.println(driver.findElement(By.xpath("//div[@id='draggable']")).getAttribute("style"));
//		act.dragAndDrop(src, target).build().perform();
//		System.out.println(driver.findElement(By.xpath("//div[@id='draggable']")).getAttribute("style"));
//		driver.switchTo().defaultContent();
//		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Accept')]")).getText());
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@name='frameset-middle']/frame[@name='frame-middle']")));
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
		driver.quit();
		
		
       //

	}

}
