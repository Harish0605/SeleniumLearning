package seleniumLearning2;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPriceOfEachItem {

	public static LinkedHashMap<String, Integer> storeProductPrices(List<WebElement> products) {
		LinkedHashMap<String, Integer> productsAndPrices = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < products.size(); i++) {
			productsAndPrices.put(products.get(i).getText(),
					Integer.parseInt(products.get(i).findElement(By.xpath("following-sibling::td[1]")).getText()));

		}
		return productsAndPrices;
	}

	private static String getVeggiePrice(WebElement e) {
		return e.findElement(By.xpath("following-sibling::td[1]")).getText();

	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// get the products and price using Map
		List<WebElement> itemsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		System.out.println(storeProductPrices(itemsList).toString());

		// scan the name column of the vegetablesList and print the price if the
		// vegetable is Tomato
		//we are using do while loop because we wanted to continue do block until 
		//while block condition is met and then stop
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		 price= rows.stream().filter(s -> s.getText().contains("Apple")).map(s -> getVeggiePrice(s))
					.collect(Collectors.toList());
			price.stream().forEach(k -> System.out.println(k));
			
			//pagination
			//what if the vegetable is not found in the first list
			//Iterate till its found
			
			if(price.size()<1) {
				
				driver.findElement(By.xpath("//a[contains(@aria-label,'Next')]")).click();
				
			}
		}while(price.size()<1) ;
		
		driver.quit();

	}

}
