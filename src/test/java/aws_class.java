import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.devicefarm.DeviceFarmClient;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlRequest;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlResponse;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class aws_class
{
        /** Set up the test suite. */
       // @BeforeTest
        @Test
        public void setUp() {
            DeviceFarmClient client = DeviceFarmClient.builder().region(Region.US_WEST_2).build();
            CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder()
                    .expiresInSeconds(300)        // 5 minutes
                    .projectArn("arn:aws:devicefarm:us-west-2:731786881849:testgrid-project:e9a566f1-20af-4f43-b796-9fc36ecd2e3e")
                    .build();

            URL testGridUrl = null;
            try {
                CreateTestGridUrlResponse response = client.createTestGridUrl(request);
                testGridUrl = new URL(response.url());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Assert.assertNotNull(testGridUrl);


/*
            DesiredCapabilities desired_capabilities = new DesiredCapabilities();
            desired_capabilities.setCapability("browserName","chrome");
            desired_capabilities.setCapability("browserVersion", "latest");
            desired_capabilities.setCapability("platform", "windows");

            //DesiredCapabilities desired_capabilities = DesiredCapabilities.firefox();
*/
            ChromeOptions options = new ChromeOptions();
            RemoteWebDriver driver = new RemoteWebDriver(testGridUrl, options);
           // RemoteWebDriver driver = new RemoteWebDriver(testGridUrl, desired_capabilities);


           driver.get("https://www.google.com/");
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
           driver.manage().window().maximize();
            System.out.println("1");
            driver.findElement(By.name("q")).sendKeys("Test");
            System.out.println("2");

        }
}
