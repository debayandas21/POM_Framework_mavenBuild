package Automation.framework.Action;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;

import Automation.framework.core.BaseClass;
import Automation.framework.interfaces.Elements;

public class action_keywrods extends BaseClass implements Elements {

	/**
	 * click Perform click operation
	 */
	public void click(WebElement locator)
			throws NoSuchElementException, ElementClickInterceptedException, ElementNotInteractableException {
		// TODO Auto-generated method stub
		try {
			if (driver == null) {
				throw new UnreachableBrowserException("Browser is not launched  or driver is failed to initialize");
			}

			else if (locator != null) {
				if (locator.isDisplayed() && locator.isSelected()) {
					locator.click();
				}
			} else {
				throw new NoSuchElementException("Element is not present");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wait Customized Wait command for static wait time
	 *
	 */
	@Override
	public long Wait(int timeUnit) throws Exception {
		if (driver != null) {
			logger.info("driver is not null");
			try {
				Thread.sleep(Duration.ofSeconds(timeUnit));
				logger.info("wait for "+timeUnit+" seconds");
				System.out.println("wait for "+timeUnit+" seconds");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return timeUnit;

	}

	/**
	 * implicitWait
	 * Implicitly wait 
	 */
	@Override
	public long implicitWait(int timeUnit) throws Exception {
		
		if(driver!= null) {
			logger.info("driver is not null");
			
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeUnit));
			} catch(Exception e) {
				e.printStackTrace();
			}
		} return timeUnit;
	}
	
	
}
