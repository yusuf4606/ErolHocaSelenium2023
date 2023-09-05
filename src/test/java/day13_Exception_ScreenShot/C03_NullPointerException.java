package day13_Exception_ScreenShot;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_NullPointerException extends TestBase {

    WebDriver driver;
    Faker faker;
    Actions actions;

    @Test
    public void test01() {
        /*
        NULLPOINTEREXCEPTIN
            Eğer bir obje yada değişken oluşturup bunlara atama yapmazsak bu exception'ı alırız
         */
        //org.openqa.selenium.SessionNotCreatedException: Driver ayarları için WebDriverManager kullanmadığımızdan bu hatayı aldık
        //driver = new ChromeDriver();//-->driver objesine atama yapmazsak NULLPOINTEREXCEPTION alırız
        driver.get("https://amazon.com");


    }

    @Test
    public void test02() {
        //faker = new Faker();-->Atamasını yapınca NULLPOINTEREXCEPTION hatasını handle etmiş olduk
       System.out.println(faker.name().firstName());//-->NULLPOINTEREXCEPTION ALDIK
    }

}
