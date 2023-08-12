package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.navigate().to("https://www.youtube.com/");//-->Bu method get() methodu gibi girelen url'e gider.
        Thread.sleep(3000); // 3 saniye kadar beklettik

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000); // 3 saniye kadar beklettik

        //Tekrar YouTube'sayfasina donelim
        driver.navigate().back();  // bir onceki sayfaya gider
        Thread.sleep(3000); // 3 saniye kadar beklettik

        //Yeniden Amazon sayfasina gidelim
        driver.navigate().forward(); // -->
        Thread.sleep(3000); // 3 saniye kadar beklettik

        //Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        Thread.sleep(3000); // 3 saniye kadar beklettik

        //Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();
    }

}
