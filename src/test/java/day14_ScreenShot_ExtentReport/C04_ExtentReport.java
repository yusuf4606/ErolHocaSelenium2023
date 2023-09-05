package day14_ScreenShot_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_ExtentReport extends TestBase {
    ExtentReports extentReport;//-->raporlamayı başlatır
    ExtentHtmlReporter extentHtmlReporter;//-->Html formatında rapor oluşturur
    ExtentTest extentTest;//-->Test adımlarına bilgi eklenir




    /*
    EXTENTREPORT
    1-ExtentReport kullanabilmek için öncelikle mvn repository adresinden extentReport araması yapıp
    com.aventstack » extentreports seçip, 4.0.9 uncu versiyonu alıp pom.xml dosyamıza koymalıyız.
    2-ExtentReport class'ından raporlamayı başlatması için bir obje oluşturmamız gerekir.
    3-ExtentHtmlReporter class'ından raporları html formatında oluşturması için bir obje oluşturmalıyız
    4-ExtentTest class'ından test adımlarına bilgi ekleyebilmemiz için bir obje oluştururuz
     */

    @Test
    public void test01() {
        extentReport = new ExtentReports();

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/utilities/ExtentReports/report_"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);
        // Raporda gorunmesini istedigimiz bilgiler
        extentReport.setSystemInfo("Tester","Josef");    // key ve value olarak degerler girebilirriz istedigimiz kadar
        extentReport.setSystemInfo("Browser","Chrome");
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");   //-- dokuman basligina isim veriyoruz
        extentHtmlReporter.config().setReportName("Smoke Test");

        extentTest=extentReport.createTest("AmazonTest","Test Raporu");

        // Amazon sayfasina gidelim
        extentTest.info("Kullanici Amazon sayfasina gider");
        driver.get("https://amazon.com");



        //Arama kutusunda iphone aratalim
        extentTest.info("Kullanici Amazon sayfasindaki arama kutusunun locate ini alir");
        bekle(2);
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Kullanici Amazon sayfasindaki arama kutusunda 'iphone' aratir ve enter a basar");
        aramaKutusu.sendKeys("iphone", Keys.ENTER);


        //ekran resmini alalım
        extentTest.info("Kullanici tum sayfanin ekran resmini alir");
        screenShot("amazon");
        //sonuc yazısı webelementinin resmini alalım

        extentTest.info("Kullanici sonuc yazisinin locate ini alir");
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        extentTest.pass("Kullanici sonucYazisinin resmini alir");
        screenShotWE(sonucYazisi,"iphoneAraSonuc");


        extentReport.flush();


    }
}
