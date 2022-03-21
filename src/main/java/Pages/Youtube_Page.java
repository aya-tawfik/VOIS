package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.AssertJUnit;

import java.util.List;

public class Youtube_Page extends Page_Base
{
  @FindBy(xpath = "//div//ytd-searchbox//form//div//div//input[@class='ytd-searchbox']")
  public   WebElement search_box;


    @FindBy (id = "search-icon-legacy")
  public   WebElement search_icon;
    

    @FindBy (css = "yt-icon.style-scope.ytd-toggle-button-renderer")
    public WebElement filters;
    

   @FindBy (id = "video-title")
   public List<WebElement> results;

    @FindBy (css = "yt-formatted-string.style-scope.ytd-search-filter-renderer")
    public WebElement type_video;


    @FindBy (css = "h1.title.style-scope.ytd-video-primary-info-renderer")
    public WebElement video_title;

    public Youtube_Page(WebDriver driver) {
        super(driver);
    }



    public void select(String searchtext, int videonumber )
    {
        entertext(search_box,searchtext);
        click(search_icon);
        click(filters);
        click(type_video);
        String Selected_video=results.get(videonumber-1).getText();
        results.get(videonumber-1).click();
        String videotitle= video_title.getText();
        System.out.println("video"+videotitle);
        AssertJUnit.assertEquals(Selected_video,videotitle);
    }
}
