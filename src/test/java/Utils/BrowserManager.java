package Utils;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
//BrowserManager work as dependency injection
//It is use bcoz we cant use driver object in test runner as it is private in hooks
public class BrowserManager {
    private WebDriver driver;
    HomePage homePage;

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }
}
