package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginPageTests extends TestBase {

    @Test
    public void loginToTrelloPositive() throws InterruptedException {

        //----Login to Trello----
        waitUntilElementIsVisible(By.xpath("//a[@href='/login']"), 20);
        WebElement passwordInput = driver.findElement(By.xpath("//a[@href='/login']"));
        passwordInput.click();
        waitUntilElementIsClickable(By.id("login"),30);

        WebElement loginInput = driver.findElement(By.className("form-field"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("annagorodetskaya@yandex.ru");
        driver.findElement(By.id("login")).click();
        waitUntilElementIsClickable(By.id("login-submit"),30);

        driver.findElement(By.id("login-submit")).click();//for a button  continue

        waitUntilElementIsClickable(By.id("password"),30); // for a field  password
        waitUntilElementIsClickable(By.id("login-submit"),30); //for a button  enter

        driver.findElement(By.id("password")).sendKeys("bkmrf24092011");
        driver.findElement(By.id("login-submit")).click();
        waitUntilElementIsClickable(By.
                xpath("//button[@data-test-id='header-boards-menu-button']"),50);

        Assert.assertTrue(driver.findElement(By.
                xpath("//button[@data-test-id='header-boards-menu-button']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.
                xpath("//h3[@class = 'boards-page-board-section-header-name']")).getText().equals("Personal Boards"));
    }

    @Test
    public void loginIncorrectPassNegative() throws InterruptedException {

        waitUntilElementIsVisible(By.xpath("//a[@href='/login']"), 20);
        WebElement passwordInput = driver.findElement(By.xpath("//a[@href='/login']"));
        passwordInput.click();
        waitUntilElementIsClickable(By.id("login"),30);
        WebElement loginInput = driver.findElement(By.className("form-field"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("annagorodetskaya@yandex.ru");
        driver.findElement(By.id("login")).click();
        waitUntilElementIsClickable(By.id("login-submit"),30);
        driver.findElement(By.id("login-submit")).click();//for a button  continue
        waitUntilElementIsClickable(By.id("password"),30); // for a field  password
        waitUntilElementIsClickable(By.id("login-submit"),30); //for a button  enter
        driver.findElement(By.id("password")).sendKeys("1dgfdg");
        driver.findElement(By.id("login-submit")).click();
        waitUntilElementIsVisible(By
                .xpath("//div[@id = 'login-error']/span"),10);

     Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'login-error']/span")).getText()
        .contains("Неверный адрес электронной почты и/или пароль.\n" +
                "Требуется помощь, чтобы войти?"));
    }
    @Test
    public void loginIncorrectLoginNegative() throws InterruptedException {
        WebElement passwordInput = driver.findElement(By.xpath("//a[@href='/login']"));
        passwordInput.click();
        // go to login page
        waitUntilElementIsClickable(By.id("login"),30);
        waitUntilElementIsClickable(By.id("user"),30);
        waitUntilElementIsClickable(By.id("password"),30);
        WebElement loginInput = driver.findElement(By.className("form-field"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("aqqqqq");
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.clear();
        password.sendKeys("bkmrf24092011");
        waitUntilElementIsClickable(By.id("login"),30);
        WebElement in = driver.findElement(By.id("login"));
        in.click();
        waitUntilElementIsVisible(By.xpath("//p[@class='error-message']"),100);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='error-message']")).getText()
              .contains("Аккаунт"));
    }

}
