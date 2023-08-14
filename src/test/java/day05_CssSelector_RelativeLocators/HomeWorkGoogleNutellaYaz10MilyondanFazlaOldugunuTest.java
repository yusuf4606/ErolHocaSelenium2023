package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class HomeWorkGoogleNutellaYaz10MilyondanFazlaOldugunuTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        Tekrar Testi
//        1-C01_TekrarTesti isimli bir class olusturun
//        2- https://www.google.com/  adresine gidin
        driver.get("https://www.google.com/");
//         3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
//        4. Sayfa basliginin “Google” ifadesi icerdigini test edin
        if (driver.getTitle().contains("Google")) {
            System.out.println("Sayfa Basligi 'Google' icerir TEST PASSED");
        } else {
            System.out.println("Sayfa basligi 'Google' icermiyor TEST FAILED");
        }
//        5. Arama cubuguna “Nutella” yazip aratin
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("textarea[id='APjFqb']")).sendKeys("Nutella", Keys.ENTER);
//        6. Bulunan sonuc sayisini yazdirin
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.id("result-stats"));

        Thread.sleep(2000);
//        7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] resultText = result.getText().split(" ");

        Integer resultNumber = Integer.valueOf(resultText[1].replace(".", ""));
        System.out.println("resultNumber = " + resultNumber);

        if (resultNumber > 10000000) {
            System.out.println("10 m'dan fazla sonuc bulundu ");
        } else {
            System.out.println("Sonuc 10 m'dan az ");
        }

//        8. Sayfayi kapatin

        driver.close();

    }
}
