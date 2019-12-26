package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginPageTests extends TestBase {

    @Test
    public void loginToTrelloPositive() throws InterruptedException {

        //----Login to trello----
        WebElement passwordInput = driver.findElement(By.xpath("//a[@href='/login']"));
        passwordInput.click();
        Thread.sleep(5000);
        WebElement loginInput = driver.findElement(By.className("form-field"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("annagorodetskaya@yandex.ru");
        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("bkmrf24092011");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(30000);

    }

    @Test
    public void loginIncorrectPassNegative() throws InterruptedException {
        WebElement passwordInput = driver.findElement(By.xpath("//a[@href='/login']"));
        passwordInput.click();
        Thread.sleep(5000);
        WebElement loginInput = driver.findElement(By.className("form-field"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("a@yandex.ru");
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.clear();
        password.sendKeys("bkmrf24092011");
        Thread.sleep(5000);
        WebElement in = driver.findElement(By.id("login"));
        in.click();
        Thread.sleep(5000);
        WebElement error = driver.findElement(By.id("error"));
        System.out.println(error.findElement(By.xpath("//p[@class='error-message']")).getText());
    }
    @Test
    public void loginIncorrectLoginNegative() throws InterruptedException {
        WebElement passwordInput = driver.findElement(By.xpath("//a[@href='/login']"));
        passwordInput.click();
        Thread.sleep(5000);
        WebElement loginInput = driver.findElement(By.className("form-field"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("a@yandex.ru");
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.clear();
        password.sendKeys("bkmrf24092011");
        Thread.sleep(5000);
        WebElement in = driver.findElement(By.id("login"));
        in.click();
        Thread.sleep(5000);
                WebElement error = driver.findElement(By.id("error"));
        System.out.println(error.findElement(By.xpath("//p[@class='error-message']")).getText());

    }

}
