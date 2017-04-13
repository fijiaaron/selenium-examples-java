package w3schools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDropPage
{
	public static String url = "https://www.w3schools.com/html/html5_draganddrop.asp";
	
	public static By draggable  = By.cssSelector("#drag1");
	public static By A = By.cssSelector("#div1 ");
	public static By B = By.cssSelector("#div2");
	
	WebDriver driver;
	
	public DragAndDropPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void open()
	{
		driver.get(url);
	}
	
	public WebElement findDraggable()
	{
		return driver.findElement(draggable);
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