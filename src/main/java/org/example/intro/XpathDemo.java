package org.example.intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathDemo {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.edgedriver().setup();//Configure chromeDriver, настройка хромдрайвер чтобы подключиться браузеру
        driver = new EdgeDriver(); // creating instance of chromeDriver,переназначаем на хромбраузер
        driver.manage().window().maximize();   // maximizing window. открыть сайт на полное окно
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((20))); //vremya ojidanie 20 sek на открытие окна
        driver.get("https://demoqa.com/text-box"); //указали путь куда нас перекинуть
    }

    @Test
    public void xpathTest(){
        WebElement nameText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/label"));
        String expectedEmailText = "Email";
        Assert.assertEquals(nameText.getText(), expectedEmailText);

        WebElement nameText2 = driver.findElement((By.xpath("//label[@id='userEmail-label']")));
        Assert.assertTrue(expectedEmailText.contains(nameText2.getText()));

    }
    @Test
    public void xpathTest2(){
        WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Test123");
        System.out.println("Result is : " + userName.getAttribute("value"));
        Assert.assertEquals(userName.getAttribute("value"), "Test123");// мне нужен атрибут
    }

    @AfterClass
     public void tearDown(){
        driver.close();
        driver.quit();

    }
}
