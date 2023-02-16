package Pages;

import Steps.Hooks;
import Utils.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")
    private WebElement searchResult;

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchResult() {
        return searchResult;
    }
}
