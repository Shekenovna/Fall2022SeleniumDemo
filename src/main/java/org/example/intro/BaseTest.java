package org.example.intro;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest {

    WebDriver driver;
    BrowserHelper browserHelper;

    AlertHelper alertHelper;

    @BeforeClass
    public void setUp(){
        WebDriverManager.edgedriver().setup();//Configure chromeDriver, настройка хромдрайвер чтобы подключиться браузеру
        driver = new EdgeDriver(); // creating instance of chromeDriver,переназначаем на хромбраузер
        driver.manage().window().maximize();   // maximizing window. открыть сайт на полное окно
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((3))); //vremya ojidanie 20 sek на открытие окна
        browserHelper = new BrowserHelper(driver);
        alertHelper = new AlertHelper(driver);
        driver.get("https://demoqa.com/text-box"); //указали путь куда нас перекинуть

    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();

    }
}
