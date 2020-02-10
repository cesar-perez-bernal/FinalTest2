package SeleniumPractice.Homework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;

public class basicTest {
	
//	protected static String baseUrl = "https://learn.letskodeit.com/p/practice";
//	protected static String baseUrl = "https://dhtmlx.com/docs/products/dhtmlxGrid/";
	protected static String baseUrl = "https://docs.oracle.com/javase/7/docs/api/";
	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Exception{
//		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.ie.driver", "driver\\IEDriverServer_x64_3.141.59\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
//		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver-v0.26.0-win64\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@AfterClass
	public static void tearDown() throws Exception{
		driver.close();
		driver.quit();
	}
}
