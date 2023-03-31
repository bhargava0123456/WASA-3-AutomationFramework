package vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.Homepage;
import vtiger.ObjectRepository.Loginpage;

public class BaseClass {
    
	
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public JavaUtility jutil= new JavaUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public static WebDriver driver;
	public  static WebDriver sdriver= driver;
	@BeforeSuite
	public void database()
	{
		System.out.println("----database connected----");
	}
	@BeforeClass
	public void browser() throws Exception
	{
		String url=putil.datafrompropertyfile("url");
		String BROWSER= putil.datafrompropertyfile("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("----- "+BROWSER+" Launched succesfully-----");
			
		} else if (BROWSER.equalsIgnoreCase("Edge")) 
		{
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("----- "+BROWSER+" Launched successfully-----");
			
		} else 
		{
			System.out.println("Invalid Browser name");
		}
		
		wutil.maximizewindow(driver);
		wutil.waitforpage(driver);
		driver.get(url);
	}
	@BeforeMethod
	public void login() throws Exception
	{
		String uname=putil.datafrompropertyfile("username");
		String pass=putil.datafrompropertyfile("password");
		Loginpage lp=new Loginpage(driver);
		lp.logintoapp(uname, pass);
	    WebDriver sdriver=driver;
	}
	@AfterMethod
	public void logout()
	{
		Homepage hp=new Homepage(driver);
		hp.logout(driver);
		System.out.println("---logout successful---");
	}
	@AfterClass
	public void quit()
	{
		driver.quit();
	}
	@BeforeSuite
	public void removedb()
	{
		System.out.println("---db connection removed---");
	}
}
