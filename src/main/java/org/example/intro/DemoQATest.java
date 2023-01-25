package org.example.intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DemoQATest {
    WebDriver driver = new EdgeDriver();
    Faker faker = new Faker();

    String name;
    String email;
    String currentAdress;
    String permanentAdress;

    String expectedFakeName;
    String expectedFakeEmail;
    String fakeAddress;
    String fakePerAddress;

    @BeforeClass
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("http://demoqa.com/text-box");

    }

    @Test (description = "Should run first.", priority = 1)
    public void submitTesting() {

        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        currentAdress = faker.address().country();
        permanentAdress = faker.address().city();

        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys(name);

        WebElement emailInputField = driver.findElement(By.id("userEmail"));
        emailInputField.sendKeys(email);

        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        currentAddressField.sendKeys(currentAdress);

        WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
        permanentAddressField.sendKeys(permanentAdress);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    @Test (priority = 2)
    public void assertTestingName () {

        expectedFakeName = driver.findElement(By.id("name")).getText();
        assertTrue(expectedFakeName.contains(name),  " Name is Ok");

    }
    @Test(priority = 3)
    public void assertTestingEmail(){
        expectedFakeEmail = driver.findElement(By.id("email")).getText();
        assertEquals("Email:"+ email,expectedFakeEmail, "Email is failed");

    }
    @Test (priority = 4)
    public void assertTestingAddress() {
        fakeAddress = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]")).getText();
        assertTrue(fakeAddress.contains(currentAdress),"current address is ok");

    }
    @Test(priority = 5)
    public void assertTestingPerAddress() {
        fakePerAddress = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]")).getText();
        assertTrue(fakePerAddress.contains(permanentAdress), "permanent address is ok");


    }
    @AfterClass
    public void close(){
        driver.close();
        driver.quit();
    }
}
