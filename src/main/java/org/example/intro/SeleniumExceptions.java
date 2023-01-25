package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.target.model.SessionID;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumExceptions extends BaseTest {
    @Test
    public void noSuchElementExceptionTest() {// исключение возникает из-за использования неправильных локаторов элементов в методе findElement
        // NoSuchElementException:            //неправильных локаторов элементов в методе findElement
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.xpath("userName")).sendKeys("Hello World");
    }

    @Test
    public void noSuchWindowExceptionTest() { //возникает, если текущий список окон не обновляется.
        // NoSuchWindowException              //Предыдущее окно не существует, и вы не можете переключиться на него.
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().window("Hello");
    }

    @Test
    public void noSuchFrameExceptionTest() {
        // NoSuchFrameException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().frame(123);
    }

    @Test
    public void noSuchAlertExceptionTest() {//Происходит, когда пользователь пытается переключиться на оповещение,
        // NoSuchAlertException            // которого нет. Проще говоря, это означает, что тест выполняется
        browserHelper.openURL("https://demoqa.com/text-box"); //слишком быстро и пытается найти оповещение, которое еще не было открыто браузером.
        alertHelper.acceptAlert();
    }

    @Test
    public void InvalidSelectorExceptionTest() { //css & xpath синтаксическая ошибка
        // org.openga.selenium.InvalidSelectorExceptoin -не верно указали путь к элементу, в данном случае не верно икспасс
        browserHelper.openURL("https://demoda.com/text-box");
        SessionId s = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session Id is: " + s);

//        driver.findElement(By.xpath("//button[@type='button'][100]"));
    }

    @Test
    public void noSuchSessionExceptionTest() {// ошибка сессии
        //InvalidSelectorException
        driver.quit();// указали закрыть предыд сессию
        browserHelper.openURL("https://demoda.com/text-box");//и не указали какую сессию открыть указывая сайт
    }

    @Test
    public void staleElementReferenceExceptionTest() {
        //staleElementReferenceException - устаревшую ссылку когда ссылаемся
        browserHelper.openURL("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
                break;// если уберем и когда находим самсунг, и дадьше опять же будет условия читать и ищет самсунг, хотя ссылка указ на 69 поле устарел

            }
        }
    }

    @Test
    public void timeOutExceptionTest() {
        //timeOutException -если команда не была выполнена или завершена в течение времени ожидания
        browserHelper.openURL("https://demoqa.com/dynamic-properties");
//        driver.findElement(By.id("enableAfter")).click();// если хотим без ожидания кликнуть, тоже ощибка
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));// указали 0, а сам браузер указан 5 сек, а также в clsss baseTest тоже сократить
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();

    }

    @Test
    public void ElementNotInteractableTest() {//наш драйвер не может взаимодействовать с неактивным элементом,
        //ElementNotInteractableTest        // потому что не нажали эту кнопку, неактивна она
        browserHelper.openURL("https://demoda.com/text-box");
        driver.findElement(By.id("noRadio")).sendKeys("saas");
//        driver.findElement(By.id("noRadio")).click();

    }

    @Test
    public void ElementClickInterceptedException() {// пытаемся неактивную кнопку кликнуть(не верный код, выяснить)
        browserHelper.openURL("https://demoda.com/text-box");
        driver.findElement(By.id("noRadio")).click();
    }

    @Test
    public void elementNotInteractable(){
        // elementNotInteractable --> драйвер не может с ним взаимодействовать, мы с ним неправильно взаимодействуем
        browserHelper.openURL("https://demoqa.com/radio-button");
        driver.findElement(By.id("noRadio")).sendKeys("saas"); // в кнопку пытаемся что-то написать
        // org.openqa.selenium.ElementNotInteractableException: element not interactable
    }
    @Test
    public void elementClickInterceptedException(){
        // elementClickInterceptedException --> элемент не активный
        browserHelper.openURL("https://demoqa.com/radio-button");
        driver.findElement(By.id("noRadio")).click(); // пытаемся кликнуть недоступный элемент
        // org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <input type="radio" id="noRadio" disabled="" name="like" class="custom-control-input disabled"> is not clickable at point (573, 376). Other element would receive the click: <label class="custom-control-label disabled" for="noRadio">...</label>
    }
    @Test
    public void NoSuchAttributeExceptionTest(){ // не можем найти
        browserHelper.openURL("https://demoda.com/text-box");
        WebElement element = driver.findElement(By.id("userName1"));
        String name = element.getAttribute("href");
    }
}



