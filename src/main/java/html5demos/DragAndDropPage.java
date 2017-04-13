package html5demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage
{
	public static String url = "http://html5demos.com/drag";
	
	public static By bin = By.cssSelector("#bin");
	public static By one = By.cssSelector("#one");
	public static By two = By.cssSelector("#two");
	public static By three = By.cssSelector("#three");
	public static By four = By.cssSelector("#four");
	public static By five = By.cssSelector("#five");
	
	public WebDriver driver;
	
	public DragAndDropPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void open()
	{
		driver.get(url);
	}
}
