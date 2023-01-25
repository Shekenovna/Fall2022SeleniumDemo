package org.example.intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo1 {
    @Test
    public void testDemo1(){
        WebDriverManager.edgedriver().setup();//Configure chromeDriver, настройка хромдрайвер чтобы подключиться браузеру

        WebDriver driver = new EdgeDriver(); // creating instance of chromeDriver,переназначаем на хромбраузер
        driver.manage().window().maximize();   // maximizing window. открыть сайт на полное окно
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((20))); //vremya ojidanie 20 sek на открытие окна

        driver.get("https://demoqa.com/text-box"); //указали путь куда нас перекинуть

        WebElement fullNameInputField = driver.findElement(By.id("userName")); //найди элемент по id и сохрани fulNameIn...
        fullNameInputField.sendKeys("John Doe"); // на указанный элемент\поле напишет автоматом keysToSend

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("john@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Bishkek");
        currentAddress.getText();

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Kyrgyzstan");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();






     }

}
