package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Pencereyi tam ekran yaptik
        driver.manage().window().maximize();

        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //Sayfa başlığını konsola yazdırınız
        String actualTitleAmazon = driver.getTitle();
        System.out.println("actulTitle = " + actualTitleAmazon);

        //Sayfanın Url'ini konsola yazdırınız
        String actualUrlAmazon = driver.getCurrentUrl();
        System.out.println(actualUrlAmazon);

        //Techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");

        //Sayfa başlığını konsola yazdırınız
        String tittleTechpro = driver.getTitle();
        System.out.println(tittleTechpro);

        //Sayfanın Url'ini konsola yazdırınız
        String urlTechpro = driver.getCurrentUrl();
        System.out.println(urlTechpro);

        // Browser i kapattik
        driver.close();
    }
}
