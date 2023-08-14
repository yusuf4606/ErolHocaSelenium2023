package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWorkSauceDemoUrunSepeteEklendiginiKontrolet {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //        Soru 3
        //        1.“https://www.saucedemo.com” Adresine gidin

        driver.get("https://www.saucedemo.com");
        //        2. Username kutusuna “standard_user” yazdirin
        //        3. Password kutusuna “secret_sauce” yazdirin
        //        4. Login tusuna basin
        WebElement login = driver.findElement(By.cssSelector("input[id='user-name']"));
        Thread.sleep(2000);
        login.sendKeys("standard_user" + Keys.TAB + "secret_sauce" + Keys.ENTER);

        //        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("(//div)[27]")).click();
        //        6. Add to Cart butonuna basin
        WebElement addCart = driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack"));
        addCart.click();

        //        7. Alisveris sepetine tiklayin
        WebElement sepet = driver.findElement(By.xpath("//span"));
        sepet.click();
        Thread.sleep(2000);
        //        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepet1Urun = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
            // Sepete eklenip eklenmedigi kontrolü 1.yol
            /*
            boolean urunSepeteEklendiMi = sepet1Urun.isDisplayed();
            if (urunSepeteEklendiMi){
                System.out.println("Urun sepete eklenmistir");
            } else {
                System.out.println("Sepete eklenememistir");
            }
            /*

        */

        // Sepete eklenip eklenmedigi kontrolü 2.yol

        if (sepet1Urun.getText().equals("1")) {
            System.out.println("Urun sepete eklenmistir");
        } else {
            System.out.println("Urun sepete eklenememistir");
        }

        //        9. Sayfayi kapatin

        driver.close();
    }

}
