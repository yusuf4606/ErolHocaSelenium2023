package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_DriverMethodsTestTechpro {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Techpro sayfasina gidelim. https://techproeducation.com
        driver.get("https://techproeducation.com");

        //Sayfa basligini(title) yazdirin
        System.out.println("Sayfa Başlığı : "+driver.getTitle());

        //Sayfa basliginin "Techpro" icerdigini test edin
        if (driver.getTitle().contains("Techpro")){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //Sayfa adresini(url) yazdirin
        System.out.println("Sayfa Url'i : "+driver.getCurrentUrl());

        //Sayfa url'inin "techpro" icerdigini test edin.
        if (driver.getCurrentUrl().contains("techpro")){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //Sayfa handle degerini yazdirin
        System.out.println("Sayfa Handle Değeri : "+driver.getWindowHandle());
        /*
            getWindowHandle() methodu ile kendimiz isteyerek başka bir pencereye geçiş yaptığımızda iki tane pencere
        açmış olucaz. Dolayısıyla ilk açtığımız pencereye tekrar geçiş yapmak istediğimizde ilk açtığımız pencereden
        sonra almış olduğumuz window handle değeri ile geçiş yapabiliriz. Pencereler arası geçiş konusunda bunu detaylı
        göreceğiz. Birde bir sayfaya gittiğimizde bir linke tıkladığımızda bizim kontrolümüz dışında yeni bir pencere
        açılabilir. Bu gibi durumlarda da getWindowHandles() methodu ile driver'in açmış olduğu pencerelerin handle
        değerlerini bir list'e assing ederiz ve istediğimiz pencereye index ile çok rahat geçiş yapabiliriz.
         */


        //Sayfa HTML kodlarinda "text" kelimesi gectigini test edin
        System.out.println(driver.getPageSource());
       System.out.println(driver.getPageSource().contains("text"));



        // Sayfayi kapatiniz
        driver.close(); // --> close() methodu driver in en son actigi sayfayi kapatir
// driver.quit(); --> methodu actigimiz birden fazla sekme ya da pencerelerin hepsini kapatmak icin kullanilir

    }

}
