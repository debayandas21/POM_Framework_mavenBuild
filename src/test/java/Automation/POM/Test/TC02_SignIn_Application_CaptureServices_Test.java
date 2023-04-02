package Automation.POM.Test;

import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Automation.POM.PageObjects.Application_LandIngPage;
import Automation.POM.framework.Utilities.ExecutionReport;
import Automation.POM.framework.Utilities.ExecutionStatus;
import Automation.POM.framework.core.BaseClass;

public class TC02_SignIn_Application_CaptureServices_Test extends BaseClass {

	ExtentTest report;

	@DataProvider(name = "testDataProvider")
	public Object[][] testDataProvider() throws Exception {
		return Automation.POM.framework.Utilities.DataRead
				.getConsolidatedtestDataArray(this.getClass().getSimpleName().toString(), "TestData_Sheet1");
	}

	@BeforeTest
	public void setUpConfig() throws Exception {
		initializeConfig();

	}

	@Test(dataProvider = "testDataProvider")
	public void Launch_Application(Hashtable<String, String> testData, ITestContext context) throws Exception {
		try {
			report = Extent.createTest(this.getClass().getSimpleName());
			initializeDriver(testData);

			Application_LandIngPage homeP = new Application_LandIngPage(driver);
			

			/* launch the application */
			homeP.launchApllication(report);
			
			/*Sign In*/
			homeP.perform_signIn(report);

			

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			super.quit_process(report);
			ExecutionReport.loggMessage(report, "Kill Browser Instance", "Browser instance killed successfully",
					ExecutionStatus.INFO);

		}
	}

}
