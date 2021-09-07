package com.oem.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oem.genericlib.BaseTest;

public class HomePage {
	

	@FindBy(xpath="//a[text()='Solutions']") private WebElement solutionsTab;
	@FindBy(xpath="//a[text()=\"Price Books\"]") private WebElement pricebookTab;
	
	public HomePage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	
	}
	public void clickSolutionsTab()
	{
		solutionsTab.click();
	}

	public void clickPricebookTab()
	{
		pricebookTab.click();
	}
}
