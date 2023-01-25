package org.example.intro;

import com.github.javafaker.Faker;
import jdk.internal.org.jline.terminal.Terminal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class HWSelenium extends BaseTest{
    @Test
    public void webTables(){
       driver.get("https://demoqa.com/webtables");
       driver.findElement(By.id("addNewRecordButton")).click();
       driver.findElement(By.id("firstName"));
        Faker faker = new Faker();
        String fName = faker.name().name();
        String lName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String age = String.valueOf(faker.number().randomDigit());
        String salary = String.valueOf(faker.number().randomDigit());
        String department = faker.job().field();

        WebElement fullNameInput = driver.findElement(By.id("firstName"));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        WebElement ageInput = driver.findElement(By.id("age"));
        WebElement salaryInput = driver.findElement(By.id("salary"));
        WebElement departmentInput = driver.findElement(By.id("department"));

        fullNameInput.sendKeys(fName);
        lastNameInput.sendKeys(lName);
        emailInput.sendKeys(email);
        ageInput.sendKeys(age);
        salaryInput.sendKeys(salary);
        departmentInput.sendKeys(department);

        WebElement allData = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
        System.out.println(allData.getText());

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        driver.findElement(By.id("submit")).click();

        List <WebElement> saveData = driver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
        for(WebElement j: saveData) {
        System.out.println(j.getText());
        Helper.pause(3000);
        System.out.println("----------------");
        break;
     }

    }
}
//Selenium:
//        Selenium — это набор программ с открытым исходным кодом, которые применяют для тестирования веб-приложений и администрирования сайтов локально и в сети. Программы Selenium позволяют автоматизировать действия браузера. Среди программ проекта:
//        Selenium IDE — плагин для браузера Firefoх для записи действий пользователя.
//        Selenium RC — устаревшая библиотека для управления браузерами.
//        Selenium WebDriver — библиотека для управления браузерами.
//        Selenium Grid — кластер Selenium-серверов для управления браузерами на разных компьютерах в сети.
//        Selenium Server — сервер для управления браузером удаленно по сети.
//        Selenium WebDriver — библиотека для управления браузерами, основной продукт комплекта Selenium. Представляет из себя семейство драйверов для разных браузеров (Firefox, Edge, Google Chrome/Chromium, Internet Explorer, Safari, Opera) и набор клиентских библиотек на разных языках программирования для работы с драйверами. WebDriver поддерживает работу с языками Java, .Net (C#), Python, Ruby, JavaScript.
//        Locators:
//        1. By ID
//        2. Name
//        3. Class name
//        4. Partial link text
//        5. LinkText
//        6. tagName
//        7. xpath (absolute xpath,relative xpath)
//        8. css selector
//        Checkbox vs Radiobutton
//        Alert
//        Explicit wait: