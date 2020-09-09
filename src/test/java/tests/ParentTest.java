package tests;

import static utils.ConfigPropertyReader.getProperty;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.BasePage;
import utils.WebDriverFactory;

public class ParentTest {

	protected WebDriver driver =null;
	protected WebDriverFactory wdFactory; 
	BasePage basePage;
	
	@BeforeTest
	public void setup() {
		wdFactory  = new WebDriverFactory();
		driver = wdFactory.getBrowserDriver(getProperty("browser"));
		basePage = new BasePage(driver);
		basePage.launchApplication();
	}
	
	@AfterTest
	public void tearDown() {
		basePage.close();
	}
}