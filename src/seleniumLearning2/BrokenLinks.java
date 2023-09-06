package seleniumLearning2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
	public static void responseCode(List<WebElement> links,WebDriver driver) throws IOException {
		
		for(WebElement e:links) {
			String link = e.getAttribute("href");
			HttpURLConnection connection =  (HttpURLConnection) new URL (link).openConnection();
			int responseCode = connection.getResponseCode();
			if(responseCode==400|| responseCode==404 || responseCode==401) {
				System.out.println(link+" : "+responseCode);	
			}
			
		}
		}

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UNIFY\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.xpath("//table[@class='gf-t']/tbody/tr/td/ul/li//a"));
		responseCode( links,driver);		
		driver.quit();

	}

}
