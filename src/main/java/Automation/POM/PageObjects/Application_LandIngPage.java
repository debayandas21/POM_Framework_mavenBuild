package Automation.POM.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Automation.framework.Action.action_keywrods;
import Automation.framework.Utilities.ExecutionReport;
import Automation.framework.Utilities.ExecutionStatus;
import Automation.framework.Utilities.globalConfig;
import Automation.framework.core.BaseClass;

public class Application_LandIngPage extends BaseClass {
	
	public Application_LandIngPage(WebDriver driver) {
		BaseClass.driver = driver;
		

	}

	action_keywrods actions= new action_keywrods();
	
	/**
	 * 
	 * @param report
	 * @throws Exception
	 */
	public void launchApllication(ExtentTest report) throws Exception {
		try {
			driver.navigate().to(globalConfig.globalParameter.get("ApplicationUrl"));

			System.out.println(globalConfig.globalParameter.get("ApplicationUrl"));

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

			String pageTitle = driver.getTitle();
			System.out.println(pageTitle);
			actions.Wait(3);
			ExecutionReport.loggMessage(report, "Capture Page Title", "Page Title Captured Successfully", ExecutionStatus.PASS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
