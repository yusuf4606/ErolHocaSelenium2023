package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {
    /*
    Eger sadece bir webelementin resmni almak istersek
    o elementin locatini alip WE.getScreenShotAs() methodu ile webelementin resmini alabiliriz
     */

    @Test
    public void test01() throws IOException {

        // amazon sayfasina gidelim
        driver.get("https://amazon.com");

        // arama kutusunda iphoe aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        // ekran resmini alalim
        screenShot("amazon");
        // sonuc yazisi webelementinin resmini alalim
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/utilities/WebElementEkranGoruntusu"+tarih+".png";
        WebElement result = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("result.getText() = " + result.getText());

        FileUtils.copyFile(result.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }

    @Test
    public void test02() {
        // amazon sayfasina gidelim
        driver.get("https://amazon.com");

        // arama kutusunda iphoe aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        // ekran resmini alalim
        screenShot("amazon");
        // sonuc yazisi webelementinin resmini alalim

        WebElement result = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        screenShotWE(result, "resultText");
    }
}
