package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButton {

        //https://www.facebook.com adresine gidin
        //Cookies'i kabul edin
        //"Create an Account" button'una basin
        //"radio buttons" elementlerini locate edin
        //Secili degilse cinsiyet butonundan size uygun olani secin

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
    public void radioButton() throws InterruptedException {
        //Cookies'i kabul edin
       WebElement cerezIzin = driver.findElement(By.xpath("(//button)[13]"));
       cerezIzin.click();
        Thread.sleep(2000);

        //"Create an Account" button'una basin

        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        Thread.sleep(2000);

        //"radio buttons" elementlerini locate edin
        WebElement cinsiyetBayan = driver.findElement(By.xpath("(//label)[1]"));
        WebElement cinsiyetErkek = driver.findElement(By.xpath("(//label)[2]"));
        WebElement cinsiyetOzel = driver.findElement(By.xpath("(//label)[3]"));
        //Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(2000);
        if (!cinsiyetErkek.isSelected()){
            cinsiyetErkek.click();
        }
        Thread.sleep(2000);


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
