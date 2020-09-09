package pages;

import org.openqa.selenium.WebDriver;
import utils.*;
import static utils.ConfigPropertyReader.*;

public class BasePage {

	protected WebDriver driver = null;
	protected ElementUtil elementUtil;
	protected JavaScriptUtil jsUtil;
	
		public BasePage(WebDriver driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(this.driver);
			jsUtil = new JavaScriptUtil(this.driver);
		}

		public void launchApplication() {
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(getProperty("url"));
			
		}
		
		public String getPageTitle() {
			jsUtil.checkPageIsReady();
			return driver.getTitle();
		}
		
		public void quit() {
			driver.quit();
		}
		
		public void close() {
			driver.close();
		}
}