package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static java.lang.Thread.sleep;

public class TestBase {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        //===========Enter to Trello====
        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
