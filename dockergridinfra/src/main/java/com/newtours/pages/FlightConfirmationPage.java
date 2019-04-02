package com.newtours.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//font[contains(text(),'Flight Confirmation')]")
	private WebElement flightConfirmationText;
	
	@FindBy(xpath="//font[contains(text(),'USD')]")
	private List<WebElement> price;
	
	@FindBy(linkText="SIGN-OFF")
	private WebElement signOffOption;
	
	public FlightConfirmationPage(WebDriver driver) {
		
		this.driver=driver;
		this.wait=new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}
	
	public void printPrices() {
		
		this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationText));
		
		System.out.println(this.flightConfirmationText.getText());
		
		System.out.println(this.price.get(1).getText());
		
		this.signOffOption.click();
		
	}
	
	

}
