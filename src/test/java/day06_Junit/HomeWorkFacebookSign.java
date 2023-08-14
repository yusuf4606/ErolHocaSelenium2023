package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWorkFacebookSign {
    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.facebook.com adresine gidin
        driver.get("https://facebook.com");
        Thread.sleep(2000);
    }

    @Test
    public void facebookTest() throws InterruptedException {

        //Cookies'i kabul edin
        WebElement cerezIzin = driver.findElement(By.xpath("(//button)[13]"));
        cerezIzin.click();
        Thread.sleep(2000);
        //Url'in facebook içerdiğini test(assertion ile)
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));


        //"Create an Account" button'una basin

        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        Thread.sleep(2000);
        //Çıkan formu doldurunuz
        WebElement ad = driver.findElement(By.xpath("(//input)[9]"));
        ad.sendKeys("Arif" + Keys.TAB + "Erdem");

        WebElement eMailKutusu = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        eMailKutusu.sendKeys("zamari.zihan@fixedfor.com" + Keys.TAB + "123456789,As");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("select[aria-label='Yıl']")).sendKeys("2000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='2']")).click();

        Thread.sleep(2000);
        //kaydol butonuna tıklayınız
        driver.findElement(By.xpath("(//button)[2]")).click();
        Thread.sleep(2000);
        // Eposta adresini tekrar gir butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("zamari.zihan@fixedfor.com" + Keys.ENTER);
        Thread.sleep(1000);
        //Not: Before methodda driver ayarlarını yapınız


    }

    //  After ile sayfayı kapatınız
    @After
    public void tearDown() throws Exception {
        //  driver.close();
    }
}
