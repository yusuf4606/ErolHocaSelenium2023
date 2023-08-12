package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ManageMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver  =new ChromeDriver();
        driver.manage().window().maximize();

        /*
Driver'i oluşturdak sonra maximize yapmamız bizim için gitmek istediğimiz sayfadaki elementlere daha
rahat sorunsuz ulaşmamız için önemlidir.
Bunun için driver'i hemen oluşturduktan sonra manage().window().maximize() methodunu kullanırız.
Maximize yaptıktan sonra internetten kaynak sayfa performansından kaynaklı sayfadaki elementler hemen
yüklenemeyebilir. Dolayısıyla sayfaya gittikten sonra bir elemente, bir butona tıklamak istediğimizde
hemen sayfa yüklenmez ise elementi bulamayacağı için tiklama işlemini gerçekleştiremeyeceği için
testimiz fail vericektir. Bunun önüne geçmek için maximize methodundan sonra driver'imiza
selenium dan gelen implicitly wait ataması yaparız. Bu wait ile sayfanın tüm elementlerinin oluşmasını
beklemesi için max. bir süre belirtiriz.
 */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // techpro sayfasina gidiniz ve sayfa basliginin techpro icerdigini test edelim
        driver.get("https://techproeducation.com");
        if (driver.getTitle().contains("techpro")){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        // sayfayi kapat
        driver.close();



    }
}
