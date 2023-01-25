package org.example.intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

    public class XpathHW {
        WebDriver driver;

        @BeforeClass
        public void setUp(){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://glovoapp.com/kg/ru/bishkek/");

        }
        @Test (description = "Find get started method")
        public void xPath1(){

            WebElement searchButton = driver.findElement(By.xpath("(//button[@id='user-register'])[2]"));
            searchButton.click();

        }
        @Test
        public void xpath2Test(){
            WebElement inputFirstName = driver.findElement(By.xpath("(//input[@class='el-input__inner'])[2]"));
            inputFirstName.sendKeys("Gulnara");
        }
        @Test
        public void xpath3Test(){
            WebElement inputEmail = driver.findElement(By.xpath("(//input[@class='el-input__inner'])[3]"));
            inputEmail.sendKeys("kkb@gmail");
        }
        @Test
        public void xpath4Test(){
            WebElement inputPassword = driver.findElement(By.xpath("(//input[@class='el-input__inner'])[4]"));
            inputPassword.sendKeys("12345678");
        }
        @AfterClass
        public void tearDown(){
            driver.close();
            driver.quit();

        }


    }

