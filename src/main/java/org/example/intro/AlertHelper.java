package org.example.intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {

    private WebDriver driver;

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }
    private Alert alert;


    public void acceptAlert(){
        alert.accept();
    }

    public void dismissAlert(){
        alert.dismiss();
    }

    public void sendKeysAlert(String txt){
        alert.sendKeys(txt);
    }
}
