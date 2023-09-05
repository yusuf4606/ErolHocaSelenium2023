package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class TestBase {
    protected ExtentReports extentReport;//-->raporlamayı başlatır
    protected ExtentHtmlReporter extentHtmlReporter;//-->Html formatında rapor oluşturur
    protected ExtentTest extentTest;//-->Test adımlarına bilgi eklenir
   protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);

      //  driver.close();  // driver en son hangi sayfada ise o kapanir
       // driver.quit(); // eger birden fazla sayfa acilmissa hepsini kapatir
    }

    //Hard Wait
    public void bekle(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    //Dropdown Select Index
    public void selectIndex(WebElement ddm, int idx){
        Select select = new Select(ddm);
        select.selectByIndex(idx);

    }

    public void selectVisibleText(WebElement ddm, String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);

    }

    public void selectValue(WebElement ddm, String value){
        Select select = new Select(ddm);
        select.selectByVisibleText(value);

    }

    public void selectWindow(int idx){
        List<String> pencerelerListesi = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencerelerListesi.get(idx));
    }

    // Window Handles

    public void window(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index-1].toString());
    }
// iframe index ile
    public void frameIndex(int index){
        driver.switchTo().frame(index);
    }

    //UploadFile Robot Class , bu method daha dogrusu Robot Class kullanilirken mause ' a hic dokunulmamasi gereki
    public void uploadFilePath(String dosyaYolu) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    // facebook cerezlerini kabul etmek icin
    public void facebookCerezIzin(){

        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
    }

    // Tum Sayfa screenShot
    public void screenShot(String nameOfWebsite){
        String tarih = new SimpleDateFormat("_hh_mm_ddMMyyyy").format(new Date());
        String dosyaYolu ="src/test/java/utilities/TumSayfaResimleri/"+nameOfWebsite+"_"+tarih+".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // WebElement screenShot
    public void screenShotWE(WebElement element, String nameOfElement){
        String tarih = new SimpleDateFormat("_hh_mm_ddMMyyyy").format(new Date());
        String dosyaYolu ="src/test/java/utilities/WebElementEkranGoruntusu/"+nameOfElement+"_"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //youtube cerezleri kabul et
    public void youtubeCerezKabul(){
        bekle(1);
        driver.findElement(By.xpath("(//*[.='Tümünü kabul et'])[1]")).click();
    }

    // sayfayi 1 defa PageDown yap
    public void pageDown(int num){
        Actions actions = new Actions(driver);
        for (int i=0;i<=num;i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
    }

    //Extent Report
    public void rapor(String browser,String reportName){
        extentReport = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/extentReport/report"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler
        extentReport.setSystemInfo("Tester","Erol");
        extentReport.setSystemInfo(browser,"Chrome");
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentHtmlReporter.config().setReportName(reportName);
    }
}
