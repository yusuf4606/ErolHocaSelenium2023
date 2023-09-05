package day14_ScreenShot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        // amazon sayfasina gidelim sayfanin resmini alalim

        driver.get("https://amazon.com");

        // Sayfanin resmini alalim

        String dosyaYolu ="src/test/java/utilities/TumSayfaResimleri/amazonScreenShot.jpeg";
        TakesScreenshot ts  = (TakesScreenshot) driver;

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
    @Test
    public void test02() throws IOException {
        // amazon sayfasina gidelim sayfanin resmini alalim

        driver.get("https://amazon.com");

        // Sayfanin resmini alalim

        // target altinda ekran goruntuusu aldik
        String tarih = new SimpleDateFormat("_hh_mm_ddMMyyyy").format(new Date());
        String dosyaYolu ="target/ekranGoruntusu/screenShot"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
    @Test
    public void test03() throws IOException {
        // youtube sayfasina gidelim sayfanin resmini alalim

        driver.get("https://youtube.com");

        // Sayfanin resmini alalim

        // target altinda ekran goruntuusu aldik
        screenShot("youtube"); // TestBase class indaki method ile ekran resmini aldik
    }
}
