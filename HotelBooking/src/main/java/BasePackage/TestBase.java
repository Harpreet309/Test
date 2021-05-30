package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() 
	{
		prop = new Properties();
		
		String Path =  System.getProperty("user.dir") + "\\src\\main\\resources\\Config\\config.properties";
		
		try
		{
			FileInputStream fin = new FileInputStream(Path);
			prop.load(fin);
		}
		catch(FileNotFoundException e)
		{
			System.out.println( "File not found" + e.getMessage());
		}
		
		 catch(IOException e)
        {
        	System.out.println("File not found" + e.getMessage());
        }
	}


public static void initialization()
{
	String Browser = prop.getProperty("browser");
	if(Browser.equalsIgnoreCase("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + prop.getProperty("Chrome_driverpath"));
		driver = new ChromeDriver();
	}
	else if(Browser.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
	//	System.setProperty("webdriver.gecko.driver", prop.getProperty("Firefox_driverpath"));
		driver = new FirefoxDriver();
	}
	else if(Browser.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.get(System.getProperty("user.dir") +prop.getProperty("Login_url"));
}

public static void shutdown()
{
	driver.quit();
}
}
