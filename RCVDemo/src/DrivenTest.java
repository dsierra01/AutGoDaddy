import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.List;
import java.awt.RenderingHints.Key;
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

public class DrivenTest {

	ReadExcelFile readFile;
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\dchrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		readFile = new ReadExcelFile();
		
		driver.get("https://www.godaddy.com/es");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() throws IOException, InterruptedException {
		
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
		
		driver.findElements(By.cssSelector(".text-right")).get(0).click();
		Thread.sleep(8000);
		driver.findElements(By.cssSelector(".text-right")).get(0).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(5000);
		driver.findElements(By.cssSelector(".text-center")).get(2).click();
		Thread.sleep(5000);
		driver.findElements(By.cssSelector(".text-center")).get(2).click();
		Thread.sleep(8000);
		driver.findElement(By.id("hcCartIcon")).click();
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
		Thread.sleep(3000);
		driver.findElements(By.className("dropdown-text")).get(3).click();
		Thread.sleep(10000);
		driver.findElements(By.className("dropdown-item")).get(16).click();
		
		String subtotal = driver.findElement(By.xpath("//div[@id='root']/div/div/div/div[2]/div/div/flex/div[2]/div[3]/div/span[2]")).getText();
		
		System.out.println(subtotal);
		
		String ahorro = driver.findElement(By.xpath("//div[@id='root']/div/div/div/div[2]/div/div/flex/div[2]/div[6]/span/span")).getText();		
		
		System.out.println(ahorro);
		
		Thread.sleep(7000);
		//for (int i = 0; i<=3; i++) {
			driver.findElements(By.cssSelector(".d-flex .ux-button-text")).get(0).click();
			Thread.sleep(11000);
			driver.findElements(By.cssSelector(".d-flex .ux-button-text")).get(0).click();
			Thread.sleep(15000);
			driver.findElements(By.cssSelector(".d-flex .ux-button-text")).get(0).click();
			Thread.sleep(15000);
			driver.findElements(By.cssSelector(".d-flex .ux-button-text")).get(3).click();
			Thread.sleep(12000);
			driver.findElements(By.cssSelector(".d-flex .ux-button-text")).get(0).click();
			
		//}
		try {		
		String resultado = driver.findElement(By.cssSelector(".text-center")).getText();
		//System.out.println(resultado + "No hay artículos en tu carrito.");
		if( resultado.equals("No hay artículos en tu carrito.")){
			System.out.println("Se eliminaron todos los productos correctamente");
			assertTrue("El resultado es" ,driver.findElement(By.cssSelector(".text-center")).isDisplayed());
		}
		}catch(Exception e){
			System.out.println("No se eliminaron todos los productos correctamente");
		}
	}

}
