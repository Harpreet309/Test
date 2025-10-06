package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
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


        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "Config" + File.separator + "config.properties";

		
		try
		{
			FileInputStream fin = new FileInputStream(path);
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
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    String loginPath = System.getProperty("user.dir") + prop.getProperty("Login_url");
    File loginFile = new File(loginPath);
    driver.get(loginFile.toURI().toString());
}

public static void shutdown()
{
	driver.quit();
}
}
