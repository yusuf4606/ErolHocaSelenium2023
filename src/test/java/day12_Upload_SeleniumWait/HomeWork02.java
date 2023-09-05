package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class HomeWork02 extends TestBase {
//    1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

//     2.Textbox’in etkin olmadigini(enabled) dogrulayın

//     3.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

//     4.“It’s enabled!” mesajinin goruntulendigini dogrulayın.

//     5.Textbox’in etkin oldugunu(enabled) dogrulayın.


    @Test
    public void test01() {
        //    1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //   2.Textbox’in etkin olmadigini(enabled) dogrulayın

        WebElement texBox = driver.findElement(By.cssSelector("input[type='text']"));
        Assert.assertFalse(texBox.isEnabled());

        //   3.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enable = driver.
                findElement(By.xpath("//button[@ autocomplete='off' and @type='button' and @onclick='swapInput()' and text()='Enable']"));
        enable.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


            // 1. yol disable etkin visible olana kadar bekle
            // webelement e assign etmeden dogrudan locate'ini aldik
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button)[2]")));

            //2. yol textbox click edilebilene kadar bekle
            // wait.until(ExpectedConditions.elementToBeClickable(texBox));

        //   4.“It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsEnabled = driver.findElement(By.xpath("(//p)[2]"));
        Assert.assertEquals("It's enabled!", itsEnabled.getText());
        //   5.Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(texBox.isEnabled());

    }
}
