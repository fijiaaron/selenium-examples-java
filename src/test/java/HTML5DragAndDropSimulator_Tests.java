import draganddrop.DragAndDrop;
import draganddrop.HTML5DragAndDropSimulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;


@RunWith(Parameterized.class)
public class HTML5DragAndDropSimulator_Tests extends TestBase
{
	DragAndDrop dnd;
	
	public HTML5DragAndDropSimulator_Tests(String browser)
	{
		super(browser);
		dnd = new HTML5DragAndDropSimulator();
	}
	
	@Test
	public void test_on_TheInternet()
	{
		driver.get(theinternet.DragAndDropPage.url);
		WebElement origin = driver.findElement(theinternet.DragAndDropPage.A);
		WebElement destination = driver.findElement(theinternet.DragAndDropPage.B);
		
		dnd.dragAndDrop(origin, destination, driver);
	}
	
	@Test
	public void test_on_Html5Demos()
	{
		driver.get(html5demos.DragAndDropPage.url);
		WebElement origin = driver.findElement(html5demos.DragAndDropPage.one);
		WebElement destination = driver.findElement(html5demos.DragAndDropPage.bin);
		
		dnd.dragAndDrop(origin, destination, driver);
	}
	
	@Test
	public void test_on_W3Schools()
	{
		driver.get(w3schools.DragAndDropPage.url);
		WebElement origin = driver.findElement(w3schools.DragAndDropPage.draggable);
		WebElement destination = driver.findElement(w3schools.DragAndDropPage.B);

		dnd.dragAndDrop(origin, destination, driver);
	}
}