package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locators {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon Sayfasina gidiniz...
        driver.get("https://amazon.com");
        // Attribute degerine cift tiklayip ctrl+c --> ctrl+f --> ctrl+v yaparak ogenin unique olup olmadigini
        // html kodlarinin alt kismindaki arama bolumunden kontrol ederiz

        //Arama kutusunu locate ediniz ve iphone yazdirip aratiniz
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        // WebElement aramaKutusuName = driver.findElement(By.name("field-keywords"));

        // input tag'ina sahip bir webelementi locate ettikten sonra sendKeys() methodu ile o webelemente
        // istedigimiz text'i gonderebiliriz
        // bir texti arama kutusuna gonderdikten sonra klavyeden enter a bastihimiz gibi otomasyon ile de bunu yapabiliriz
        // 1. submit() methodunu kullanarak enter yapabiliriz
        // 2. tanimlanmis veri tipi olan (enum) ile
        aramaKutusu.sendKeys("iphone", Keys.ENTER); // Keys.Enter ile enter tusuna bastik
       //  aramaKutusu.submit(); // --> Enter anlamina geliyor


        // WebElement araButonu = driver.findElement(By.id("nav-search-submit-text"));
        // araButonu.click();

        //Sayfayi kapatiniz
        driver.close();

    }
}
