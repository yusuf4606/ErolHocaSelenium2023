package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //Events linkine tıklayalım
       WebElement eventsWE =  driver.findElement(By.xpath("(//a[text()='Events'])[1]"));
       eventsWE.click();

        //Basliğin Events icerdigini doğrulayalım

        Assert.assertTrue(driver.getTitle().contains("Events"));
        //Ve sayfanın resmini alalım
        TakesScreenshot tsTechpro = (TakesScreenshot) driver;
        String tarih1 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYoluTechpro = "src/test/java/utilities/TumSayfaResimleri/techpro_"+tarih1+".jpeg";
        FileUtils.copyFile(tsTechpro.getScreenshotAs(OutputType.FILE),new File(dosyaYoluTechpro));
        //Yeni bir sekmede amazon sayfasına gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //Ve sayfanın resmini alalım
        TakesScreenshot tsAmazon = (TakesScreenshot) driver;
        String tarih2 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());

        String dosyaYoluAmazon = "src/test/java/utilities/TumSayfaResimleri/amazon_"+tarih2+".jpeg";
        FileUtils.copyFile(tsAmazon.getScreenshotAs(OutputType.FILE),new File(dosyaYoluAmazon));

        //Arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone",Keys.ENTER);
        //Çıkan sonun yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih3 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYoluWE = "src/test/java/utilities/WebElementEkranGoruntusu/_sonucYazisi_"+tarih3+".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYoluWE));
        //Techpro sayfasına geri dönelim
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        //ve sayfanın resmini alalım

        TakesScreenshot tsTechpro2 = (TakesScreenshot) driver;
        String tarih4 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYoluTechpro2 = "src/test/java/utilities/TumSayfaResimleri/techpro_"+tarih4+".jpeg";
        FileUtils.copyFile(tsTechpro2.getScreenshotAs(OutputType.FILE),new File(dosyaYoluTechpro2));



    }@Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //Events linkine tıklayalım
       WebElement eventsWE =  driver.findElement(By.xpath("(//a[text()='Events'])[1]"));
       eventsWE.click();

        //Basliğin Events icerdigini doğrulayalım

        Assert.assertTrue(driver.getTitle().contains("Events"));
        //Ve sayfanın resmini alalım
        screenShot("techpro");
        //Yeni bir sekmede amazon sayfasına gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //Ve sayfanın resmini alalım
        screenShot("amazon");

        //Arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone",Keys.ENTER);
        //Çıkan sonun yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
       screenShotWE(sonucYazisi,"iphoneAraSonuc");
        //Techpro sayfasına geri dönelim
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        //ve sayfanın resmini alalım

        screenShot("techPro");



    }
}
