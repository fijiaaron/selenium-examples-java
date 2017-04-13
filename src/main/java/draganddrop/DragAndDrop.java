package draganddrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface DragAndDrop
{
	void dragAndDrop(WebElement source, WebElement destination, WebDriver driver);
	void dragAndDrop(By sourceLocator, By destinationLocator, WebDriver driver);
}
