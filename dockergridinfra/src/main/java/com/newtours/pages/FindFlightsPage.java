package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="reserveFlights")
	private WebElement firstSubmitBtn;
	
	@FindBy(name="buyFlights")
	private WebElement secondSubmitBtn;
	
	public FindFlightsPage(WebDriver driver) {
		
		this.driver=driver;
		this.wait=new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}
	
	public void submitFirstFlightPage() {
		this.wait.until(ExpectedConditions.visibilityOf(firstSubmitBtn));
		this.firstSubmitBtn.click();
	}
	
	public void goToFlightConfirmationPage() {
		this.wait.until(ExpectedConditions.visibilityOf(secondSubmitBtn));
		this.secondSubmitBtn.click();
	}
	
}
