package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class CurrentBoardPageTests extends TestBase {

   @Test
    public void createNewList() throws InterruptedException {
       //----Login to Trello ----
       WebElement passwordInput = driver.findElement(By.xpath("//a[@href='/login']"));
       passwordInput.click();
       Thread.sleep(5000);
       //--------- fill login form ------
       WebElement loginInput = driver.findElement(By.className("form-field"));
       loginInput.click();
       loginInput.clear();
       loginInput.sendKeys("annagorodetskaya@yandex.ru");
       WebElement Atlassian = driver.findElement(By.id("login"));
       Atlassian.click();
       Thread.sleep(5000);
       WebElement forward = driver.findElement(By.className("css-t5emrf"));
       forward.click();
       Thread.sleep(5000);
       WebElement password = driver.findElement(By.id("password"));
       password.clear();
       password.sendKeys("bkmrf24092011");
       password.click();
       //-------- confirm login --------
       WebElement in = driver.findElement(By.className("css-t5emrf"));
       in.click();
       Thread.sleep(30000);
// ------------------open "New" board
       driver.findElement(By.xpath("//div[@title='New']/..")).click();
       Thread.sleep(20000);

       driver.findElement(By.cssSelector(".placeholder")).click();// add another column
       Thread.sleep(15000);

       driver.findElement(By.cssSelector(".list-name-input")).sendKeys("New List Anna");//Enter the title of the list

       driver.findElement(By.xpath("//input[@type='submit']")).click();// add the list
       Thread.sleep(10000);

       driver.findElements(By.xpath("//span[@class='js-add-a-card']")).get(0).click();
       Thread.sleep(5000);
    }
    @Test
    public void  addFirstCardInNewList () throws InterruptedException {
        //----Login to Trello ----
        WebElement passwordInput = driver.findElement(By.xpath("//a[@href='/login']"));
        passwordInput.click();
        Thread.sleep(5000);
        //------fill login form- --------
        WebElement loginInput = driver.findElement(By.className("form-field"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("annagorodetskaya@yandex.ru");
        WebElement Atlassian = driver.findElement(By.id("login"));
        Atlassian.click();
        Thread.sleep(5000);
        WebElement forward = driver.findElement(By.className("css-t5emrf"));
        forward.click();
        Thread.sleep(5000);
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("bkmrf24092011");
        password.click();
        //--------- confirm login --------------
        WebElement in = driver.findElement(By.className("css-t5emrf"));
        in.click();
        Thread.sleep(30000);
        // ------------------ open  board with name "New"
        driver.findElement(By.xpath("//div[@title='New']/..")).click();
        Thread.sleep(20000);

         //-----Add  new list------
        driver.findElement(By.cssSelector(".placeholder")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".list-name-input"))
                .sendKeys("New List");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
        //----Add a first card for any new list
        driver.findElements(By.xpath("//span[@class='js-add-a-card']")).get(0).click();
        Thread.sleep(3000);
        driver.findElement(By
                .xpath("//textarea[@class='list-card-composer-textarea js-card-title']")).sendKeys("text");
        driver.findElement(By
                .xpath("//input[@class='primary confirm mod-compact js-add-card']")).click();
        Thread.sleep(5000);
            }
    @Test
    public void deleteList() throws InterruptedException {
       //----Login to Trello ----
        WebElement passwordInput = driver.findElement(By.xpath("//a[@href='/login']"));
        passwordInput.click();
        Thread.sleep(5000);
        //------fill login form- --------
        WebElement loginInput = driver.findElement(By.className("form-field"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys("annagorodetskaya@yandex.ru");
        WebElement Atlassian = driver.findElement(By.id("login"));
        Atlassian.click();
        Thread.sleep(5000);
        WebElement forward = driver.findElement(By.className("css-t5emrf"));
        forward.click();
        Thread.sleep(5000);
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("bkmrf24092011");
        password.click();
        //--------- confirm login --------------
        WebElement in = driver.findElement(By.className("css-t5emrf"));
        in.click();
        Thread.sleep(30000);
       // ------------------ open  board with name "New"
        driver.findElement(By.xpath("//div[@title='New']/..")).click();
        Thread.sleep(20000);
       //------------ list recalculation
        List<WebElement> listEvents = driver.findElements(
                By.xpath("//div[@id= 'board']//h2[@class='list-header-name-assist js-list-name-assist']/.."));
        int counter =0;
        for (WebElement element : listEvents) { counter++;}

        System.out.println("before  lists " + counter);
        //------- there isn't a list. add  new list
        if (counter==0){
            driver.findElement(By.cssSelector(".placeholder")).click();// add another column
            Thread.sleep(15000);
            driver.findElement(By.cssSelector(".list-name-input")).sendKeys("New List");//Enter the title of the list
            driver.findElement(By.xpath("//input[@type='submit']")).click();// add the list
            Thread.sleep(10000);
        }
        // ----- delete list -----
        WebElement dots = driver.findElement(By.xpath
                ("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"));
        dots.click();
        Thread.sleep(5000);
        WebElement closeList = driver.findElement(By.xpath("//a[@class='js-close-list']"));
        closeList.click();
       // -----------check that the list has been removed
        List<WebElement> listEventsAfter = driver.findElements(
                By.xpath("//div[@id= 'board']//h2[@class='list-header-name-assist js-list-name-assist']/.."));
        counter = 0;
        for (WebElement element : listEventsAfter) { counter++;}

        System.out.println("after  lists " + counter);
    }
}
