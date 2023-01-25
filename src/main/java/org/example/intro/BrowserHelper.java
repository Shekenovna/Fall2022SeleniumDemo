package org.example.intro;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {
    private WebDriver driver;
    public BrowserHelper(WebDriver driver){
        this.driver = driver;
    }
    public void openURL(String URL){// БУДЕМ ОТКРЫВАТЬ ССЫЛКИ
        driver.navigate().to(URL);
    }
    public void goBack(){
        driver.navigate().back();
    }
    public void goForward(){
        driver.navigate().forward();//
    }
    public void refresh(){
        driver.navigate().refresh();//возврат на пред
    }
    public Set<String> getWindowHandles(){// забирает табы и вложит в сет, чтобы не было дубликатов и покажет храниение вкладок
        return driver.getWindowHandles();//чтобы переключаться между вкладками и влзвращает все вкладки
    }
    public void switchToWindow(int index){
        LinkedList <String>windowsId = new LinkedList<String>(getWindowHandles());//положить все вкладки и индексировать
        if(index>0 || index > windowsId.size()){
            throw new IllegalArgumentException("Invalid index: " + index);
        }
        driver.switchTo().window(windowsId.get(index));
    }
    public void switchToParent(){
        LinkedList <String>windowsId = new LinkedList<String>(getWindowHandles());
        driver.switchTo().window(windowsId.get(0));
    }
}
