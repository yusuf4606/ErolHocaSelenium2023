package LMS_Homeworks.day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task_06 extends TestBase {
//    -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
//            -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
//-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
//-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
//-Çıkan alert'te iptal butonuna basınız
//            -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
//-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
//-Çıkan mesajı konsola yazdırınız
//-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız


    @Test
    public void test01() {

        //    -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        // -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        bekle(2);
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız

        bekle(2);
        String alertText = driver.switchTo().alert().getText();
        System.out.println("alertText = " + alertText);

        driver.switchTo().alert().accept();
        bekle(2);
        //-Alert with OK & Cancel butonuna basınız

        driver.findElement(By.xpath("//a[.='Alert with OK & Cancel ']")).click();

        // ve sonrasında click the button to display a confirm box butonuna basınız
        bekle(2);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        bekle(2);
        //-Çıkan alert'te iptal butonuna basınız

        driver.switchTo().alert().dismiss();
        bekle(2);

        // -Alert with Textbox butonuna basınız

        driver.findElement(By.xpath("//a[.='Alert with Textbox ']")).click();
        bekle(2);
        // ve sonrasında click the button to demonstrate the prompt box butonuna basınız

        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        bekle(2);
        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız

        driver.switchTo().alert().sendKeys("yusuf");
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);
        //-Çıkan mesajı konsola yazdırınız

        WebElement mesaj = driver.findElement(By.id("demo1"));

        System.out.println("mesaj = " + mesaj);
        bekle(2);
        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız

        Assert.assertEquals("Hello yusuf How are you today", mesaj.getText());


    }
}
