import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public abstract class TestBase
{
	@Rule
	public TestName test = new TestName();
	
	String browser;
	WebDriver driver;
	
	public TestBase(String browser)
	{
		this.browser = browser;
	}
	
	@Before
	public void setup()
	{
		driver = getWebDriverInstance(browser);
		System.out.println(getTestDescription());
	}
	
	@After
	public void cleanup()
	{
		pause(3);
		driver.quit();
	}
	
	public String getTestDescription()
	{
		StringBuilder description = new StringBuilder();
		description.append(this.getClass().getSimpleName());
		description.append(" " + test.getMethodName());
		description.append(" " + driver.getClass().getSimpleName());
		
		if (driver instanceof RemoteWebDriver)
		{
			description.append(" " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName());
			description.append(" " + ((RemoteWebDriver) driver).getCapabilities().getVersion());
			description.append(" " + ((RemoteWebDriver) driver).getCapabilities().getPlatform());
		}
		
		return description.toString();
	}
	
	public void pause(long seconds)
	{
		try
		{
			Thread.sleep( seconds * 1000);
		}
		catch (InterruptedException e)
		{}
	}
	
	@Parameterized.Parameters
	public static Collection browsers()
	{
		return Arrays.asList(new Object[][] {
				{ "chrome" },
				{ "firefox" }
		});
	}
	
	public static WebDriver getWebDriverInstance(String browser)
	{
		switch (browser.toLowerCase())
		{
			case "chrome":
				return new ChromeDriver();
			case "firefox":
				return new FirefoxDriver();
		}
		
		return null;
	}
}