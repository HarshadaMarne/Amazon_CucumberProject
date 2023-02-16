package Steps;

import Pages.HomePage;
import Utils.BrowserManager;
import Utils.EnvProps;
import Utils.TestDataReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class StepDefinitions {
    private WebDriver driver;
    HomePage homePage;
    String url;
    HashMap<String , String> data;
    Scenario scenario;
    BrowserManager browserManager;
    public StepDefinitions(BrowserManager browserManager)
    {
        this.driver=browserManager.getDriver();
    }

    @Before(order = 1)
    public void before(Scenario scenario)
    {
        this.scenario=scenario;
    }
    @Given("the user navigates to the home page")
    public void the_user_navigates_to_the_home_page() {
        url= EnvProps.getValue("url");
        driver.get(url);
//        System.out.println(1/0);
        data= TestDataReader.getData(scenario.getName());
    }
    @When("the user enter the product name")
    public void the_user_enter_the_product_name() {
        homePage=new HomePage(driver);
        homePage.getSearchBox().sendKeys(data.get("Data"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }
    @Then("the product results should be displayed")
    public void the_product_results_should_be_displayed() {
        String text=homePage.getSearchResult().getText();
        Assert.assertEquals(text,"\"mobiles\"");
    }

    @And("user enters {string} and {string}")
    public void userEntersAnd(String arg0, String arg1) {

    }

    @Given("user is on home page")
    public void userIsOnHomePage() {
    }

    @When("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
    }

    @Then("message displayed login successfully")
    public void messageDisplayedLoginSuccessfully() {
    }

    @Given("user is logged in")
    public void userIsLoggedIn() {
        System.out.println("From background");
    }
}
