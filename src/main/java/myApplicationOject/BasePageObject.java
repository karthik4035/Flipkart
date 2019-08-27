package myApplicationOject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	public static WebDriver driver;
	public String browser="chrome";
	
	public BasePageObject()
	{
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"A:\\Software\\Selenium setup\\chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				System.out.println("Browser not found");
			}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	                        }
	}
	
	
	public boolean elementFound(WebElement element)
	{
		boolean res=false;
		try {
			res=element.isDisplayed();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void setText(WebElement element, String name) {
		if (name!=null)
		{
		element.click();
		element.clear();
		element.sendKeys(name);
		}
	}
	
	public String getTxtAttribute(WebElement element)
	{
		return element.getAttribute("value");
	}
	
	public String selectFromDropdown(WebElement element, String option)
	{
		Select obj=new Select(element);
		obj.selectByValue(option);
		return obj.getFirstSelectedOption().getText();
	}	 
  
	public boolean isElementVisible(WebElement element)
	{ try {
		WebDriverWait wait=new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	} catch (Exception e)
	{
		return false;
	}
		}
	public void JavaScriptExe()
	{
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,100)");
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
	public void quiteDriver()
	{
		driver.quit();
	}
}

