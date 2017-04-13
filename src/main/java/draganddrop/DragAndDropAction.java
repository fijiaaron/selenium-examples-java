package draganddrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction implements DragAndDrop
{
	public void dragAndDrop(WebElement source, WebElement destination, WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination);
		action.build().perform();
	}
	
	public void dragAndDrop(By sourceLocator, By destinationLocator, WebDriver driver)
	{
		WebElement source = driver.findElement(sourceLocator);
		WebElement destination = driver.findElement(destinationLocator);
		dragAndDrop(source, destination, driver);
	}
	
}
