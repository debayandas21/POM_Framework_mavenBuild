package Automation.framework.interfaces;

import java.util.NoSuchElementException;



import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;



public interface Elements {

	
	public void click (WebElement locator) throws NoSuchElementException, ElementClickInterceptedException, ElementNotInteractableException;
	
	public long Wait(int timeUnit) throws Exception;
	
	public long implicitWait(int timeUnti) throws Exception;
	
}
