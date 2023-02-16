package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoQA {
//    public static void main(String[] args) {
//        //selenium
//
//        //Test steps:
//        //1. Open Chrome browser and navigate to amazon.in
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://www.amazon.in/");
//
//        //Check amazon miniTV tab present & navigate to link
//        String tab_text=driver.findElement(
//                By.xpath("//a[@data-csa-c-slot-id=\"nav_cs_0\"]")).getText();
//        if(tab_text.equalsIgnoreCase("amazon minitv")){
//            System.out.println("Amazon miniTV is present");
////            driver.findElement(By.xpath("//a[@data-csa-c-slot-id=\"nav_cs_0\"]"))
////                    .click();
////            driver.get("https://www.amazon.in//minitv?ref_=nav_avod_desktop_topnav");
//        }
//        else{
//            System.out.println("Amazon miniTV is not present");
////            driver.quit();
//        }
//
//        //2. Enter 'mobiles' in search bar
////        By by= By.id("twotabsearchtextbox");
////        WebElement element=driver.findElement(by);
////        element.sendKeys("mobiles");
//        //shorthand way
//        driver.findElement((By.id("twotabsearchtextbox"))).sendKeys("mobiles");
//
//        //3. Click on search icon / enter key
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
//
//        //4. Mobiles should be display
//        String text=driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]"))
//                .getText();
//        if(text.equals("\"mobiles\""))
//        {
//            System.out.println("Mobiles are displayed");
//        }
//        else{
//            System.out.println("Mobiles are not displayed");
//        }
//        driver.quit();
//
//        //xpath
//        //absolute -> /html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]
//        //relative -> //tagName[@attribute] -> //span[@class="a-color-state a-text-bold"]
//    }

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void TestCase1(){
        driver.get("https://www.amazon.in/");

        //Check amazon miniTV tab present & navigate to link
        String tab_text=driver.findElement(
                By.xpath("//a[@data-csa-c-slot-id=\"nav_cs_0\"]")).getText();
        Assert.assertEquals(tab_text,"Amazon miniTV");
        driver.findElement(By.xpath("//a[@data-csa-c-slot-id=\"nav_cs_0\"]"))
                    .click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.in/minitv"));
    }

    @Test
    public void TestCase2(){
        driver.get("https://www.amazon.in/");
        driver.findElement((By.id("twotabsearchtextbox"))).sendKeys("mobiles");

        //3. Click on search icon / enter key
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);

        //4. Mobiles should be display
        String text=driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]"))
                .getText();
        Assert.assertEquals(text,"\"mobiles\"");
    }

    @AfterTest
    public void TestDown(){
        driver.quit();
    }
}
