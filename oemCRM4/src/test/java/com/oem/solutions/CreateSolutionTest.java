package com.oem.solutions;

import org.testng.annotations.Test;

import com.oem.genericlib.BaseTest;
import com.oem.genericlib.FileLib;
import com.oem.genericlib.WebDriverCommonLib;
import com.oem.pom.CustomViewPage;
import com.oem.pom.HomePage;
import com.oem.pom.LoginPage;

public class CreateSolutionTest extends BaseTest{
	@Test
	public void main() throws Throwable {
		BaseTest bt = new BaseTest();
		bt.openBrowser();
		
		LoginPage lp=new LoginPage();
		FileLib flib = new FileLib();
		Thread.sleep(2000);
		lp.loginToApp(flib.readPropertyData(PROP_PATH, "userName"),flib.readPropertyData(PROP_PATH, "passWord"));
		
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "homeTitle"), "Home Page");
		HomePage hp=new HomePage();
		hp.clickSolutionsTab();
		
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "customViewTitle"), "Custom View Page");
		CustomViewPage cvs = new CustomViewPage();
		cvs.clickNewSolutionsBtn();
		Thread.sleep(2000);
		wlib.verify(wlib.getPageTitle(), flib.readPropertyData(PROP_PATH, "customSolutionsTitle"), "Create Solutions Page");
		
		CreateSolutionsPage sp = new CreateSolutionsPage();	
		sp.createLeadWithMandatoryDetails1(flib.ReadExcelData(EXCEL_PATH,"Leads",0, 1), flib.ReadExcelData(EXCEL_PATH,"Leads",1, 1),flib.ReadExcelData(EXCEL_PATH,"Leads", 2, 1));
		wlib.verify(wlib.getPageTitle(),flib.readPropertyData(PROP_PATH, "SolutionsDetails"), "Solutions Details");
		
		//driver.close();
	}

}



