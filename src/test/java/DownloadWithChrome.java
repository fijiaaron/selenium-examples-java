import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

public class DownloadWithChrome
{
	ChromeOptions options;
	DesiredCapabilities capabilities;
	WebDriver driver;
	
	public static class OneShore
	{
		public static String url = "http://one-shore.com";
		public static By download_link = By.cssSelector("#presentation-list tr:first-child .download a");
	}
	
	@Test
	public void test()
	{
		driver = UseLocalWebDriver();
		
		driver.get(OneShore.url);
		System.out.println("url:" + driver.getCurrentUrl());
		
		WebElement link = driver.findElement(OneShore.download_link);
		System.out.println("link: " + link.getText());
		System.out.println("href: " + link.getAttribute("href"));
		
	}
	
	public WebDriver UseLocalWebDriver()
	{
		options = getChromeOptions();
		return new ChromeDriver(options);
	}

	public WebDriver UseRemoteWebDriver()
	{
		options = getChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		return new RemoteWebDriver(capabilities);
	}
	
	public ChromeOptions getChromeOptions()
	{
		HashMap<String, Object> preferences = new HashMap<>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.default_directory", "/tmp/downloads");
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		return options;
	}
	
	
	@After
	public void after()
	{
		driver.quit();
	}
	
}
