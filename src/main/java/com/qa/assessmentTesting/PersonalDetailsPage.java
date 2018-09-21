package com.qa.assessmentTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailsPage {

	@FindBy(xpath = "//*[@id=\"breadcrumbs\"]/li[5]/a")
	WebElement fullName;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[2]")
	WebElement username;
}
