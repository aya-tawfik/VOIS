package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Page_Base {

    protected WebDriver driver;
    public static JavascriptExecutor jse;


    public Page_Base(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public static void click(WebElement Element)
    {
        Element.click();
    }

    public void entertext(WebElement element, String text)
    {
        element.sendKeys(text);
    }

    public static void scrollToButton()
    {
        jse.executeScript("scrollBy(0,2000)");
    }

    public static void scrollToUp()
    {
        jse.executeScript("scrollBy(0,2000)");
    }
}
