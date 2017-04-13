import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction_Tests
{
	
	
	
	public void dragAndDrop(WebElement orig, WebElement dest, WebDriver driver)
	{
		
		Actions action = new Actions(driver);
		action.dragAndDrop(orig, dest).build().perform();
	}
	
	public void implementDragAndDrop(WebElement orig, WebElement dest, WebDriver driver)
	{
		Actions builder = new Actions(driver);
		builder.clickAndHold(orig).moveToElement(dest).release().build().perform();
	}
}
