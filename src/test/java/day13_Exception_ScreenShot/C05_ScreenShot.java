package day13_Exception_ScreenShot;


import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class C05_ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        /*
        Bir sayfanın ekran görüntüsünü almak istersek;
            1-Almak istediğimiz ekran görüntüsünü kaydetmek istediğimiz yolu belirleriz
            2-TakeScreenShot arayüsünden obje oluşturup bunu driver'a eşitleriz
            TakeScreenShot ts =(TakeScreenShot) driver;
            3-FileUtils class'ından copyFile() methoduna parametre olarak oluşturmuş olduğumuz ts objesi ile
            getScreenShotAs() methonu kullanarak getScreenShotAs() methoduna da parametre olarak 'OutPutType.FILE'
            seçerek bunu yeni bir dosyaya kaydetmesi için new File() diyerek almış olduğumuz dosyanın yolunu belirtiriz.

         */
        // Amazon a git
        driver.get("https://amazon.com");
        // tum sayfanin ekran goruntusu al
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE)
                , new File("src/test/java/utilities/TumSayfaResimleri/screenShot.jpeg"));
        // screenShot.jpeg --> bu dosya adini ve uzantisini burada belirledik,
        // yani ekran resimlerini screenshot.jpeg isminde dosyaya kaydet dedik
    }

    @Test
    public void test02() throws IOException {
        driver.get("https://techproeducation.com");

        // tum sayfa ekran resmin al

        TakesScreenshot ts = (TakesScreenshot) driver;


        String dosyaYolu = "src/test/java/utilities/TumSayfaResimleri/techProScreenShot.jpeg";
        File file = new File(dosyaYolu);
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), file);


    }

    @Test
    public void test03() throws IOException {
        // facebook.com git
        driver.get("https://facebook.com");
        bekle(2);
        facebookCerezIzin();
        // tum sayfanin ekran goruntusu al

        TakesScreenshot ts = (TakesScreenshot) driver;

        String dosyaYolu = "src/test/java/utilities/TumSayfaResimleri/facebook.jpeg";
        File file = new File(dosyaYolu);
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), file);
    }

    @Test
    public void test04() {
        driver.get("https://ebay.com");
        screenShot("ebay");
    }


    @Test
    public void tekrar01() throws IOException {
        // youtube ' a git
        driver.get("https://youtube.com");
        bekle(1);
        // cerezleri kabul et
        pageDown(2);
        bekle(2);
        youtubeCerezKabul();
        bekle(2);

        //tum sayfanin ekran goruntusunu al

        String tarih = new SimpleDateFormat("_HH_mm_ss_dd_MM_yyyy").format(new Date());
        String dosyaYolu = "target//ekranResimleri//youtube_" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        bekle(2);

        // yeni sekmede "https://www.ebay.com/" adresine git

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.ebay.com/");
        bekle(2);

        // arama kutusuna 'gaming mouse' yazip  aratip  webelementin resmini al
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='gh-ac']"));


        try {
            driver.findElement(By.xpath("//button[.='Accept All']")).click();
        } catch (Exception e) {
            System.out.println("cookies cikmadi");
        }
        bekle(2);


        aramaKutusu.sendKeys("gaming mouse",Keys.ENTER);
        bekle(2);

        WebElement aramaKutusuYeni = driver.findElement(By.cssSelector("#gh-ac"));
        String tarihWE = new SimpleDateFormat("_HH_mm_ss__dd_MM_yyyy").format(new Date());
        String dosyaYoluWE = "target//WebElementResimleri//aramaKutusuEbay"+tarihWE+".png";
        FileUtils.copyFile(aramaKutusuYeni.getScreenshotAs(OutputType.FILE),new File(dosyaYoluWE));


        // ilk urunun resmini al ve  tikla
        bekle(2);

        WebElement firstProduct = driver.findElement(By.xpath("(//li[@class='s-item s-item__pl-on-bottom'])[2]"));

        String tarihWEFP = new SimpleDateFormat("_HH_mm_ss__dd_MM_yyyy").format(new Date());

        String ilkUrunPath = "target//ebayWebelementResimleri//ilkUrun_"+tarihWEFP+".jpeg";

        FileUtils.copyFile(firstProduct.getScreenshotAs(OutputType.FILE),new File(ilkUrunPath));
        bekle(2);

        firstProduct.click();



        // tum ekran resmini al
        bekle(2);
        String date = new SimpleDateFormat("_HH_mm_ss_dd_MM_YYYY").format(new Date());
        String path = "target//ekranResimleri//ebay"+date+".jpeg";
        TakesScreenshot tsW = (TakesScreenshot) driver;
        FileUtils.copyFile(tsW.getScreenshotAs(OutputType.FILE), new File(path));
        bekle(2);
        // youtube sayfasina geri donelim

        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());


        // tum sayfanin ekran resmini al

        bekle(2);
        String date1 = new SimpleDateFormat("_HH_mm_ss_dd_MM_YYYY").format(new Date());
        String path1 = "target//ekranResimleri//youtube"+date1+".jpeg";
        TakesScreenshot tsW1 = (TakesScreenshot) driver;
        FileUtils.copyFile(tsW1.getScreenshotAs(OutputType.FILE), new File(path1));






    }


}
