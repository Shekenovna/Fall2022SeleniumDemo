package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SelectDemo extends BaseTest{
    @Test
    public void testsSelect(){
        driver.get("https://demoqa.com/select-menu");
        driver.findElement(By.xpath("(//input[@id='react-select-2-input'])[1]")).sendKeys("Group 2, option 2", Keys.ENTER);
    }
}
