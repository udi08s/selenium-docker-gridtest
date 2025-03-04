package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="firstName")
	private WebElement firstNameTxt;
	
	@FindBy(name="lastName")
	private WebElement lastNameTxt;
	
	@FindBy(name="email")
	private WebElement userNameTxt;
	
	@FindBy(name="password")
	private WebElement passwordTxt;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPasswordTxt;
	
	@FindBy(name="register")
	private WebElement submitBtn;
	
	
	
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, 360);
		PageFactory.initElements(driver, this);
	}
	
	public void goTo() {
		this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
		this.wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
	}
	
	public void enterUserDetails(String firstName,String lastName) {
		this.firstNameTxt.sendKeys(firstName);
		this.lastNameTxt.sendKeys(lastName);
	}
	
	public void enterUserCredentails(String usrName,String pass) {
		this.userNameTxt.sendKeys(usrName);
		this.passwordTxt.sendKeys(pass);
		this.confirmPasswordTxt.sendKeys(pass);
		
	}
	
	public void submit() {
		this.submitBtn.click();
	}

}
