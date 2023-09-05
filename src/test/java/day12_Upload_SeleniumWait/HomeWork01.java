package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class HomeWork01 extends TestBase {
    @Test
    public void test01() {

        //3.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4.Remove butonuna basin.

        driver.findElement(By.xpath("(//button)[1]")).click();

        //5.“It’s gone!” mesajinin goruntulendigini dogrulayin.

        WebElement itsGone = driver.findElement(By.cssSelector("p[id='message']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOf(itsGone));

        Assert.assertEquals("It's gone!",itsGone.getText());

        //6.Add buttonuna basin
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        addButton.click();

        //7.It’s back mesajinin gorundugunu test edin

        WebElement itsBack = driver.findElement(By.xpath("(//p)[2]"));



        // 1. yol its back yazisi ekranda olusana kadar bekle
         wait.until(ExpectedConditions.visibilityOf(itsBack));

        //  2. yol olarak da Remove butonu ekranda gorunene kadar bekle diyebiliriz
        //  WebElement removeButton = driver.findElement(By.xpath("//*[.='Remove']"));
        //  wait.until(ExpectedConditions.visibilityOf(removeButton));

        Assert.assertEquals("It's back!", itsBack.getText()
        );
    }
}