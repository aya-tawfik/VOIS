import Pages.Youtube_Page;
import org.testng.annotations.Test;


public class Youtube_Test extends Test_Base{

    Youtube_Page youtube;
  static Youtube_Test  test = new Youtube_Test();

 // @Test
  public void Testcase1()
  {
      youtube= new Youtube_Page(test.getDriver());
	youtube.select("Selenium Tutorials", 3);
	
  }
  
  //@Test
  public void Testcase2()
  {
      youtube= new Youtube_Page(test.getDriver());
      youtube.select("Test Automation Tutorial", 3);
	
  }
  
  //@Test
  public void Testcase3()
  {
      youtube= new Youtube_Page(test.getDriver());
      youtube.select("Selenium Tutorials", 10);
	
  }
  
}
