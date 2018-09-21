package com.qa.assessmentTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.assessmentTesting.Const;
import com.qa.assessmentTesting.Helpers;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StackSteps {
	private WebDriver driver;

	public ExtentTest test;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", Const.DRIVER_PATH + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {

		test = StackRunner.report.startTest("Navigating to UserScreen");
		driver.get(Const.INDEX_URL);

		MainPage index = PageFactory.initElements(driver, MainPage.class);

		index.login(driver, test, "admin", Const.ADMIN_PASSWORD);

		test.log(LogStatus.INFO, "Login successful");
		index.navigateCreateUser(driver, test);

		if (driver.getCurrentUrl().equals(Const.CREATE_USER_URL)) {

			test.log(LogStatus.PASS, "Correct URL is passed - " + driver.getCurrentUrl());

		} else {

			test.log(LogStatus.FAIL,
					"Is not correct URL - " + driver.getCurrentUrl() + ". Expected - " + Const.CREATE_USER_URL);
		}

		assertEquals("Is not correct URL - " + driver.getCurrentUrl() + ". Expected - " + Const.CREATE_USER_URL,
				Const.CREATE_USER_URL, driver.getCurrentUrl());

	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
		CreateUserPage newUser = PageFactory.initElements(driver, CreateUserPage.class);

		newUser.createNewUser(driver, test, "gniteckm", "password", "Mark Gniteckis", "gniteckm@test.com");

		if (newUser.emailField.getAttribute("value").equals("gniteckm@test.com")) {

			test.log(LogStatus.PASS, "Details have been entered correctly" + test.addScreenCapture(
					Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "details" + " - gniteckm" + ".png")));

		} else {

			test.log(LogStatus.FAIL, "Wrong details have been entered"
					+ test.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "detailsFail.png")));

		}

		assertEquals("Wrong details entered", "gniteckm@test.com", newUser.emailField.getAttribute("value"));

	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {

		CreateUserPage newUser = PageFactory.initElements(driver, CreateUserPage.class);
		test = StackRunner.report.startTest("New user - submitting form");

		newUser.submitForm(driver, test);

		if (driver.getCurrentUrl().equals(Const.USERS_URL)) {

			test.log(LogStatus.PASS, "Sucessfully submitted form" + test
					.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "newUserSuccess.png")));

		} else {

			test.log(LogStatus.FAIL, "Submit failed"
					+ test.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "newUserFail.png")));

		}

		StackRunner.report.endTest(test);
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {

		assertEquals("Submit failed", Const.USERS_URL, driver.getCurrentUrl());
		StackRunner.report.endTest(test);
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(
			String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {

		CreateUserPage newUser = PageFactory.initElements(driver, CreateUserPage.class);
		test = StackRunner.report.startTest("New user - entering details");

		newUser.createNewUser(driver, test, arg1, arg2, arg4, arg5);

		if (newUser.emailField.getAttribute("value").equals(arg5)) {

			test.log(LogStatus.PASS, "Details have been entered correctly" + test.addScreenCapture(
					Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "details - " + arg1 + ".png")));

		} else {

			test.log(LogStatus.FAIL, "Wrong details have been entered" + test.addScreenCapture(
					Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "details - " + arg1 + ".png")));

		}

		assertEquals("Wrong details entered", arg5, newUser.emailField.getAttribute("value"));
		StackRunner.report.endTest(test);
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		test = StackRunner.report.startTest("New user - status");
		
		UsersPage users = PageFactory.initElements(driver, UsersPage.class);
		
		assertTrue("User doesn't exist", users.checkForUser(driver, test, arg1));
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
		test = StackRunner.report.startTest("Correct web address");
		driver.get(Const.INDEX_URL);

		MainPage index = PageFactory.initElements(driver, MainPage.class);

		index.login(driver, test, "admin", Const.ADMIN_PASSWORD);

		test.log(LogStatus.INFO, "Login successful");

		test.log(LogStatus.INFO, "Navigating to Users");
		index.navigateUsers(driver, test);

		UsersPage users = PageFactory.initElements(driver, UsersPage.class);

		assertTrue("User doesn't exist", users.checkForUser(driver, test, arg1));

	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		test = StackRunner.report.startTest("Click on a user Name");
		UsersPage users = PageFactory.initElements(driver, UsersPage.class);
		
		assertTrue("User doesn't exist", users.checkForUser(driver, test, arg1));

	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
		UsersPage users = PageFactory.initElements(driver, UsersPage.class);

		users.clickUsername(driver, test, arg1);

		PersonalDetailsPage details = PageFactory.initElements(driver, PersonalDetailsPage.class);

		test.log(LogStatus.PASS, "Username Displayed" + test.addScreenCapture(
				Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "Display - " + arg1 + ".png")));
		
		assertEquals("Wrong username", "Jenkins User Id: " + arg1, details.username.getText());
		StackRunner.report.endTest(test);
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
		test = StackRunner.report.startTest("Correct web address");
		driver.get(Const.INDEX_URL);

		MainPage index = PageFactory.initElements(driver, MainPage.class);

		index.login(driver, test, "admin", Const.ADMIN_PASSWORD);

		test.log(LogStatus.INFO, "Login successful");

		test.log(LogStatus.INFO, "Navigating to Users");
		index.navigateUsers(driver, test);

		UsersPage users = PageFactory.initElements(driver, UsersPage.class);

		users.clickUsername(driver, test, arg1);

		PersonalDetailsPage details = PageFactory.initElements(driver, PersonalDetailsPage.class);
		assertEquals("Wrong username", "Jenkins User Id: " + arg1, details.username.getText());
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
		test = StackRunner.report.startTest("Correct web address");
		driver.get(Const.INDEX_URL);

		MainPage index = PageFactory.initElements(driver, MainPage.class);

		index.login(driver, test, "admin", Const.ADMIN_PASSWORD);

		test.log(LogStatus.INFO, "Login successful");

		test.log(LogStatus.INFO, "Navigating to Users");
		index.navigateUsers(driver, test);
	}

	@When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
	public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String arg1)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_email_address(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		StackRunner.report.flush();
	}

}