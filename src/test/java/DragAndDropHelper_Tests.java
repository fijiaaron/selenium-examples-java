import draganddrop.DragAndDrop;
import draganddrop.DragAndDropHelper;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class DragAndDropHelper_Tests extends TestBase
{
	DragAndDrop dnd;
	
	public DragAndDropHelper_Tests(String browser)
	{
		super(browser);
		dnd = new DragAndDropHelper();
	}
	
	@Test
	public void test_on_TheInternet()
	{
		WebDriver driver = new ChromeDriver();

		driver.get(theinternet.DragAndDropPage.url);
		
		dnd.dragAndDrop(theinternet.DragAndDropPage.A, theinternet.DragAndDropPage.B, driver);
		
		pause(3);
	}
	
}
