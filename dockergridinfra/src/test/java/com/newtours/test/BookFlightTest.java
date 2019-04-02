package com.newtours.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.newtours.pages.FindFlightsPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;

public class BookFlightTest {
	
	private WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		this.driver=new ChromeDriver();
		
	}
	
	@Test
	public void registrationTest() {
		
		RegistrationPage registrationPage=new RegistrationPage(driver);
		
		registrationPage.goTo();
		registrationPage.enterUserDetails("Udaya", "Seshadri");
		registrationPage.enterUserCredentails("selenium", "docker123");
		registrationPage.submit();
		
		
	}

	@Test(dependsOnMethods="registrationTest")
	public void registrationConfirmationTest() {
		
		RegistrationConfirmationPage registrationConfirmationPage=new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.goToFlightDetailsPage();
	}
	
	@Test(dependsOnMethods="registrationConfirmationTest")
	public void flightDetailsTest() {
		
		FlightDetailsPage flightDetailsPage=new FlightDetailsPage(driver);
		
		flightDetailsPage.selectPassenger("2");
		flightDetailsPage.goToFindFlightsPage();
		
	}
	
	@Test(dependsOnMethods="flightDetailsTest")
	public void findFlightDetailsTest() {
		
		FindFlightsPage findFlightsPage=new FindFlightsPage(driver);
		findFlightsPage.submitFirstFlightPage();
		findFlightsPage.goToFlightConfirmationPage();
	}
	
	@Test(dependsOnMethods="findFlightDetailsTest")
	public void flightConfirmationTest() {
		
		FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
		flightConfirmationPage.printPrices();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
