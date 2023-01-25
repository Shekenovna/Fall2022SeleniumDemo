package org.example.intro;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenShots extends BaseTest{


    @Test
    public void screenShotTest() throws Exception {//скрины можем создать в баге, где идет ошибки
        browserHelper.openURL("https://www.amazon.com/");
        this.takeSnapShot(driver, "C:\\Users\\User\\IdeaProjects\\UI_framework_Practice\\src\\main\\resources\\amazonHomePage.png");
    }
    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{// sozdali metod
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);//interf takeScreenShot ispolzovat для скрина и запарсили в вебдрайвер
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);// класс файл от жавы хотим сохранить скрин и каким файлом хотим сохранить в каком то формате
//Move image file to new destination
        File DestFile=new File(fileWithPath);// файл создаем и название где сохраним
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);//  сохранили в ресурсахю
    }
}
