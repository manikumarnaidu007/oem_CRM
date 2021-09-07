package com.oem.genericlib;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

	public class BaseTest implements Iautoconstants{
		
		public static WebDriver driver;
		@BeforeClass
		public void openBrowser() throws Throwable
		{
			FileLib flib= new FileLib();
			String browsername=flib.readPropertyData(PROP_PATH, "browser");
			
			if(browsername.equals("chrome"))
			{
				System.setProperty(CHROME_KEY, CHROME_VALUE);
				driver= new ChromeDriver();
			}
			else
				if(browsername.equalsIgnoreCase("firefox"))
				{
					System.setProperty(GECKO_KEY, GECKO_VALUE);
					driver = new FirefoxDriver();
					
				}
				else
				{
					System.out.println("Enter proper browser name");
				}
			
			driver.manage().window().maximize();
			String appurl = flib.readPropertyData(PROP_PATH, "url");
			driver.get(appurl);
			
			WebDriverCommonLib wlib= new WebDriverCommonLib();
			String explt= flib.readPropertyData(PROP_PATH, "logintitle");
			wlib.verify(wlib.getPageTitle(),explt,"Loginpage");
		}

	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
	
	
	
	}


