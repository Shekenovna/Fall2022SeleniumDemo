package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserDemo extends BaseTest{


    @Test
    public void test1(){
        browserHelper.openURL("https://demoda.com/browser-windows");
        WebElement newTab = driver.findElement(By.id("tubButton"));
        newTab.click();
        Helper.pause(5000);
        browserHelper.switchToWindow(1);//чтобы вернуться назад нужно указать индекс, если не указать то новую вкладку переведет
        Helper.pause(3000);
        browserHelper.switchToParent();
        Helper.pause(3000);
    }
}
