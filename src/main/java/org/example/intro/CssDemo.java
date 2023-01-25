package org.example.intro;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CssDemo extends BaseTest {

    @Test
    public void cssTest() {
        driver.get("https://www.amazon.com/");

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);

        WebElement appleText = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));

        System.out.println(appleText.getText());
        driver.findElement(By.xpath("//*[@id=\"brandsRefinements\"]/ul/li[8]/span/div/a/span")).click();

//            WebElement seeMore = driver.findElement(By.cssSelector("#brandsRefinements > ul > li:nth-child(8) > span > div > a > span"));

//            List<WebElement> allBrands = driver.findElements((By.xpath("//div[@id='brandsRefinements']")));

//            List<WebElement> allBrands = driver.findElements((By.xpath("//li[contains(@id,'p_89') /span/a/div")));
//            for (WebElement e : allBrands){
//                System.out.println(e.getText());
////                WebElement appleText2 = driver.findElement(By.xpath("(//span[@class='a-expander-prompt'])[12]"));
////                appleText2.click();
//            }
        List<WebElement> allBrands2 = driver.findElements(By.xpath("//li[contains(@id,'p_89/')]"));
        for (WebElement j : allBrands2) {
            System.out.println(j.getText());
            if (j.getText().equals("SAMSUNG")) {
                Helper.pause(3000);
                System.out.println("----------------");
                j.findElement(By.tagName("i")).click();
                break;

            }
        }
    }
}
    //node[position() > last() - 5]
//нашёл это только не понял как оно работает)





