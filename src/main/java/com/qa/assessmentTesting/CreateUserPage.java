package com.qa.assessmentTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateUserPage {
	
	@FindBy(id = "username")
	private WebElement usernameField;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordField;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement nameField;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	WebElement emailField;
	
	@FindBy(xpath = "//*[@id=\"yui-gen3-button\"]")
	private WebElement submitButton;
	
	public void createNewUser(WebDriver driver, ExtentTest test, String username, String password, String name, String email) {
		test.log(LogStatus.INFO, "Attemptiong to create user - " + username + " " + password + " " + name + " " + email);
		Actions action = new Actions(driver);
		
		action.moveToElement(usernameField).click().sendKeys(username).perform();
		
		action.moveToElement(passwordField).click().sendKeys(password).perform();
		
		action.moveToElement(confirmPasswordField).click().sendKeys(password).perform();
		
		action.moveToElement(nameField).click().sendKeys(name).perform();
		
		action.moveToElement(emailField).click().sendKeys(email).perform();
	}
	
	public void submitForm(WebDriver driver, ExtentTest test) {
		test.log(LogStatus.INFO, "Submitting form");
		Actions action = new Actions(driver);
		
		action.moveToElement(submitButton).click().perform();
	}
}
