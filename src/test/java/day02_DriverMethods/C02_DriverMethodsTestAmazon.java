package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodsTestAmazon {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

//        1.Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get(" https://www.amazon.com/");
//        2.Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());
//        3.Sayfa basliginin “Amazon” icerdigini test edin
        if (driver.getTitle().contains("Amazon")){
            System.out.println("sayfa basligi amazon iceriyor");
            System.out.println(driver.getTitle());
        }else{
            System.out.println("sayfa basligi amazon icermiyor");
        }

//        4.Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());
//        5.Sayfa url’inin “amazon” icerdigini test edin.
        if (driver.getCurrentUrl().contains("amazon")){
            System.out.println("sayfa url 'amazon' iceriyor");
        } else{
            System.out.println("url 'amazon icermiyor'");
        }
//        6.Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());
//        7.Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        if (driver.getPageSource().contains("Gateway")){
            System.out.println("HTML kodlari 'Gateaway' kelimesi icerir");
        } else {
            System.out.println("HTML kodlari 'Gateaway' kelimesi icermiyor");
        }

//        8.Sayfayi kapatin.

        driver.quit();
    }
}
