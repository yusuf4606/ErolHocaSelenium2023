package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebelementLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // TechPro sayfasina gidelim
        driver.get("https://techproeducation.com");
        // arama kutusna "java" yazalim,
        driver.findElement(By.id("searchHeaderInput")).sendKeys("java");
        Thread.sleep(3000);
        // cikan seceneklerden full stack developer secenegine tiklayalim

        List<WebElement> javaDeveloperListesi = driver.findElements(By.linkText("Full Stack Java Developer"));
        /*
        linktext i full stack java developer olan butun webelementleri javaDeveloperListesi isimli listeye attik
        Websayfasi uzerinden yukari asagi ok tuslari ile hangi webelement tiklamak istedigim webelement ise onu 4. de bulduk
         */

        javaDeveloperListesi.get(3).click();

        // basligin java icerdigini test edelim
        if (driver.getTitle().contains("Java")){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        // sayfadaki kac tane link oldugunu kinsola yazdiralim
        /*
        Tag'i 'a' olan webelementlerin hepsini bir liste attik. List kullaniminda birden fazla webelemente ulasmak
         istedigimiz icin findElement() methou yerine findElemenets methodunu kullaniriz
         */
        List<WebElement> linkler = driver.findElements(By.tagName("a"));
        System.out.println("sayfadaki linklerin sayisi: "+linkler.size());
        
        // sonra linkleri konsola yazdiralim
        for (WebElement w:linkler) {
           System.out.println(w.getText());
        }

        for (WebElement w:linkler) {
            System.out.println(!w.getText().isEmpty());     // bos olmayanlari getir
        }

       // linkler.forEach(t-> System.out.println(t.getText()));
        linkler.stream().filter(t->!t.getText().isEmpty()).forEach(t-> System.out.println(t.getText()));

        /*
        bir webelementin sahip oldugu text i yazdirmak isterseniz getText() methodu kullanilir
         */
        driver.close();
    }
}