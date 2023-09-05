package LMS_Homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Task_03 extends TestBase {

    @Test
    public void test01() {
        //-https://the-internet.herokuapp.com/windows sayfasına gidiniz

        driver.get("https://the-internet.herokuapp.com/windows");

        // -Sayfada Elemental Selenium webelementinin görünür olduğunu test ediniz
        WebElement elementalSEleniumYazisi = driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(elementalSEleniumYazisi.isDisplayed());
        bekle(2);
        //-Elemental Selenium linkine tıklayınız

        elementalSEleniumYazisi.click();

        //-Açılan pencerede sayfa başlığının Elemental Selenium içerdiğini test ediniz

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));

        //-Url'in https://elementalselenium.com/ olduğunu doğrulayınız

        Assert.assertEquals("https://elementalselenium.com/", driver.getCurrentUrl());

        // A free weekly email of tips to help make Selenium one of the most robust browser automation tools out there.
        // -Yukarıdaki text'in altındaki email bölümüne email'inizi yazınız

        WebElement emailGirisi = driver.findElement(By.cssSelector("#email"));
        emailGirisi.sendKeys("java@gmail.com");
        bekle(2);

        //-Language dropdown menuden java seçiniz

        WebElement languageDDM = driver.findElement(By.xpath("//select"));

        Select selectLanguageDDM = new Select(languageDDM);
        bekle(2);
        selectLanguageDDM.selectByValue("Java");
        bekle(2);

        //-Join the mailing list buttonuna tıklayınız

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        bekle(2);
        //-Sayfada Thank you! yazısının çıktığını doğrulayınız

        WebElement thankYou = driver.findElement(By.xpath("//*[.='Thank you! ']"));
        Assert.assertEquals("Thank you!", thankYou.getText());
    }
}
