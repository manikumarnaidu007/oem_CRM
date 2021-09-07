package com.oem.genericlib;
	

	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WebDriverCommonLib {
		
		public String getPageTitle()
		{
			String pagetitle=BaseTest.driver.getTitle();
			return pagetitle;
			
		}

		

		public void verify(String actual, String expected, String page)
		{
			if(actual.equals(expected))
			{
				System.out.println(page + "is Displayed : Pass");
			}
			else
			{
				System.out.println(page + "is not Displayed: Fail ");
			}
			
		}
		
		
		public void waitforPageTitle(String Title)
		{
			WebDriverWait wait= new WebDriverWait(BaseTest.driver,30);
			wait.until(ExpectedConditions.titleContains(Title));
		}
		
	}



