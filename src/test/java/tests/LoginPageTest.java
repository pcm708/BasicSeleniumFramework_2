package tests;

import static utils.YamlReader.getYamlValue;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginPageTest extends ParentTest{
	
	LoginPage loginPage;
	DashboardPage dbPage;
	
	@BeforeTest
	public void setupLoginPage() {
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitle() {
		Assert.assertEquals(getYamlValue("loginPageTitle"),loginPage.getPageTitle());
		System.out.println("[Assertion Passed]: Verified the login page title");
	}
	
	@Test(priority = 2)
	public void loginAsAdminWithINCorrectCreds() {
		Assert.assertTrue(loginPage.doLoginWith_INCorrectCredentials());
		System.out.println("[Assertion Passed]: Invalid credentials error message is displayed");
	}
	
	@Test(priority = 3)
	public void loginAsAdminWithCorrectCreds() {
		dbPage = loginPage.doLoginWith_CorrectCredentials();
		Assert.assertEquals(getYamlValue("dashboardPageTitle"),dbPage.getPageTitle());
		System.out.println("[Assertion Passed]: Verified the dashboard page title");
	}
}