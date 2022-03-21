import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Test_Base {

   static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

     //@BeforeTest
public void Test_Base()
{
    WebDriverManager.chromedriver().setup();
    driver.set(new ChromeDriver());
    getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    getDriver().manage().window().maximize();
    getDriver().navigate().to("https://www.youtube.com/");

}

   public  WebDriver getDriver()
   {
      return driver.get();
   }

   //@AfterTest
    public void closedriver()
   {
       getDriver().quit();
   }

}
