package com.oem.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oem.genericlib.BaseTest;

public class CustomViewPage {

@FindBy(xpath = "//input[@value=\"New Solution\"]") private WebElement newSolutionsBtn;
	
	public CustomViewPage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}
	public void clickNewSolutionsBtn()
	{
		newSolutionsBtn.click();
	}

}
