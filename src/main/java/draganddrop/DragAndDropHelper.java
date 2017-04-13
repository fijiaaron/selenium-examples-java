package draganddrop;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.nio.charset.Charset;


// Abandoned in favor of HTML5DragAndDropSimulator
// see https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/3604

public class DragAndDropHelper implements DragAndDrop
{
	@Override
	public void dragAndDrop(WebElement source, WebElement destination, WebDriver driver)
	{
		// need to actually pass locators, not WebElements
		By sourceLocator = By.cssSelector("#" + source.getAttribute("id"));
		By destinationLocator = By.cssSelector("#" + source.getAttribute("id"));
		
		dragAndDrop(sourceLocator, destinationLocator, driver);
	
	}
	
	@Override
	public void dragAndDrop(By sourceLocator, By destinationLocator, WebDriver driver)
	{
		String script = String.format("$( %s ).simulateDragDrop({ dropTarget: %s });", sourceLocator, destinationLocator);
		
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(loadJQuery() + ";" + loadDragAndDropHelper() + ";" + script);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String loadJQuery() throws Exception
	{
		URL JQueryURL = new URL("https://code.jquery.com/jquery-2.2.4.min.js");
		return IOUtils.toString(JQueryURL, "UTF-8");
	}
	
	public String loadDragAndDropHelper() throws Exception
	{
		URL drag_and_drop_helper_url = new URL("https://gist.githubusercontent.com/rcorreia/2362544/raw/da3f37f412119d7f2bc204529c27bfca3441965c/drag_and_drop_helper.js");
		return IOUtils.toString(drag_and_drop_helper_url, Charset.defaultCharset());
	}
}
