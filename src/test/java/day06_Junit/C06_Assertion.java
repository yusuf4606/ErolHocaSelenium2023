package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Assertion {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
//        => Sayfa başlığının “YouTube” oldugunu test edin
//        => YouTube resminin görüntülendiğini (isDisplayed()) test edin
//        ○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//        ○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://youtube.com adresine gidin
        driver.get("https://youtube.com");
        Thread.sleep(2000);
    }

    @Test
    public void test01() {
        //        => Sayfa başlığının “YouTube” oldugunu test edin
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[2]"));
        Assert.assertEquals("YouTube",driver.getTitle());

        //        => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }@Test
    public void test02() {
        //        Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='search']"));
        Assert.assertTrue(searchBox.isEnabled());

    }@Test
    public void test03() {
        //        wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertNotEquals("Title esit","youtube",driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
