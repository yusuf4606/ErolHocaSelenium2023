package day04_GetTagNameGetAttribute_Xpat_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Xpath_ClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

//        2 . Add Element butonuna basin
        Thread.sleep(2000);
driver.findElement(By.xpath("//*[text()='Add Element']")).click();

//        3 . Delete butonu’nun gorunur oldugunu test edin
        /*

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//*[.='Delete']"));
        if (deleteButton.isDisplayed()){//--> Bir web element görünebiliyor ise
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

         */

        System.out.println(driver.findElement(By.xpath("//*[text()='Delete']")).isDisplayed());
//        4 . Delete tusuna basin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Delete']")).click();
//        5 . “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//*[text()='Add/Remove Elements']")).isDisplayed());

        // sayfayi kapat
        driver.close();

        /*
        hoca nin kodlari

        package day04_GetTagNameGetAttribute_Xpath_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XpathClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        Thread.sleep(3000);

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//*[.='Delete']"));
        if (deleteButton.isDisplayed()){//--> Bir web element görünebiliyor ise
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //Delete tusuna basin
        Thread.sleep(3000);
        deleteButton.click();

        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement = driver.findElement(By.xpath("//h3"));
        if (addRemoveElement.isDisplayed()){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        //sayfayı kapatınız
        driver.close();
    }
}
         */
    }
}
