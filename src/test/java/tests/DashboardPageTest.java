package tests;

import static utils.ConfigPropertyReader.getProperty;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;

public class DashboardPageTest extends ParentTest{

	LoginPage loginPage;
	DashboardPage dbPage;
	
	@BeforeTest
	public void setupDashboardPage() {
		loginPage = new LoginPage(driver);
		loginPage.launchApplication();
		dbPage= loginPage.doLoginWith_CorrectCredentials();
	}
	
	@Test(priority = 1)
	public void verifyUserAccountName() {
		Assert.assertEquals(getProperty("accountName"), dbPage.getAccountName());
		System.out.println("[Assertion Passed]: Verified the Account Name : "+ getProperty("accountName"));
	}
}