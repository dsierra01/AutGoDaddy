import java.awt.List;
import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DemoAutomation {
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ReadExcelFile readFile;
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\dchrome\\chromedriver.exe");
				
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		readFile = new ReadExcelFile();
		
		driver.get("https://www.godaddy.com/es");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement seachbox = driver.findElement(By.cssSelector("#id-76d4a4b5-9ed0-44a7-9060-e3bf820741be .searchInput"));
		WebElement seachbtn = driver.findElement(By.className("bg-teal-550"));
		//String filepath = "C:\\Users\\ASUS\\Documents\\Dev\\Selenium\\Consulta.xlsx";
		//String searchText = readFile.getCellValue(filepath, "Hoja1", 0, 0);
		
		Actions actions = new Actions(driver);
		
		seachbox.click();
		Thread.sleep(2000);
		seachbox.sendKeys("RTRC Testing");
		Thread.sleep(2000);
		seachbox.sendKeys(Keys.ENTER);
		//seachbtn.click();
		//seachbox.submit();
		
		//WebElement opt1 = driver.findElements(By.cssSelector("")); //.findElement(By.xpath("div[@id='search-app']/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[4]/div/div/div/div[2]/button")); //.cssSelector(".gap-1:nth-child(1) .ux-button"));
		//WebElement addShopBtn = driver.findElement(By.cssSelector("#hcShoppingBtn"));
		//ux-button ux-button-primary px-4 button-primary-teal
		//WebElement opt2 = (WebElement) driver.findElements(By.cssSelector(".text-right"));
		
		//WebElement setElement = driver.findElement(By.className("ux-button-text"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click()", setElement);
		
		driver.findElements(By.cssSelector(".text-right")).get(0).click();
		Thread.sleep(8000);
		driver.findElements(By.cssSelector(".text-right")).get(0).click();
		//Thread.sleep(10000);
		//driver.findElements(By.cssSelector(".text-right")).get(0).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.cssSelector(".text-right")).get(1))).click();
		Thread.sleep(5000);
		driver.findElements(By.cssSelector(".text-center")).get(2).click();
		Thread.sleep(5000);
		driver.findElements(By.cssSelector(".text-center")).get(2).click();
		Thread.sleep(8000);
		driver.findElement(By.id("hcCartIcon")).click(); // .cssSelector("#hcCartIcon > .ux-button-text")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.id("hcCloseX")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("hcCartBtn")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("stickyContinue")))).click();
		Thread.sleep(12000);
		
		driver.findElements(By.className("dropdown-text")).get(0).click();
		Thread.sleep(3000);
		driver.findElements(By.className("dropdown-item")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(By.className("dropdown-text")).get(1).click();
		Thread.sleep(10000);
		driver.findElements(By.className("dropdown-item")).get(8).click();
		Thread.sleep(2000); 
		driver.findElements(By.className("dropdown-text")).get(2).click();
		Thread.sleep(9000);
		driver.findElements(By.className("dropdown-item")).get(13).click();
		Thread.sleep(2000);
		driver.findElements(By.className("dropdown-text")).get(3).click();
		Thread.sleep(9000);
		driver.findElements(By.className("dropdown-item")).get(16).click();
		
		/*Thread.sleep(12000);
		WebElement selectTipoUsuario = driver.findElements(By.id("duration-dropdown-menu")).get(0);
		Select tipoUsuario = new Select(selectTipoUsuario);
		tipoUsuario.selectByIndex(0);*/
		String subtotal = driver.findElement(By.xpath("//div[@id='root']/div/div/div/div[2]/div/div/flex/div[2]/div[3]/div/span[2]")).getText();
		
		System.out.println(subtotal);
		
		String ahorro = driver.findElement(By.xpath("//div[@id='root']/div/div/div/div[2]/div/div/flex/div[2]/div[6]/span/span")).getText();		
		
		System.out.println(ahorro);
		
		Thread.sleep(6000);
		//for (int i = 0; i<=3; i++) {
			driver.findElements(By.cssSelector(".d-flex .ux-button-text")).get(0).click();
			Thread.sleep(9000);
			driver.findElements(By.cssSelector(".d-flex .ux-button-text")).get(0).click();
			Thread.sleep(9000);
			driver.findElements(By.cssSelector(".d-flex .ux-button-text")).get(0).click();
			Thread.sleep(9000);
			driver.findElements(By.cssSelector(".d-flex .ux-button-text")).get(3).click();
			Thread.sleep(9000);
			driver.findElements(By.cssSelector(".d-flex .ux-button-text")).get(0).click();
			Thread.sleep(9000);
		//}
		try {		
		String resultado = driver.findElement(By.cssSelector(".text-center")).getText();
		System.out.println(resultado + "No hay artículos en tu carrito.");
		if( resultado == "No hay artículos en tu carrito."){
			System.out.println("Se eliminaron todos los productos correctamente"); 
		}
		}catch(Exception e){
			System.out.println("No se eliminaron todos los productos correctamente");
		}
			
		//opt1.get
		//opt1.click();
		//addShopBtn.click();
		//opt2.click();
		driver.close();
		
	}

}
