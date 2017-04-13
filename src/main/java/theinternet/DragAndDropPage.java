package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDropPage
{
	public static String url = "http://the-internet.herokuapp.com/drag_and_drop";

	public static By A = By.cssSelector("#column-a > header");
	public static By B = By.cssSelector("#column-b > header");
	
	WebDriver driver;
	
	public DragAndDropPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void open()
	{
		driver.get(url);
	}
	
	public WebElement findA()
	{
		return driver.findElement(A);
	}
	
	public WebElement findB()
	{
		return driver.findElement(B);
	}
}