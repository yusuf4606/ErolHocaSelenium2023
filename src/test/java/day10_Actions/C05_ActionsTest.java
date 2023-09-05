package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ActionsTest extends TestBase {
    @Test
    public void test01() {

        // Google anasayfasina gidelim
        driver.get("https://google.com");

        // cerezleri reddet
        driver.findElement(By.xpath("(//*[.='Tümünü reddet'])[2]")).click();
        // arama kutusuna shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazdiralim
        WebElement aramaKutusu = driver.findElement(By.cssSelector("#APjFqb"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).       // -->Arama kutusunda shift e basili tutar
                sendKeys("selenium").                   // --> Shift 'e basili tutarak SELENIUM yazdiracak
                keyUp(Keys.SHIFT).                      // --> Shift i birak
                sendKeys("-java",Keys.ENTER).perform();

    }

    @Test
    public void test02() {
        // Google anasayfasina gidelim
        driver.get("https://google.com");

        // cerezleri reddet
        driver.findElement(By.xpath("(//*[.='Tümünü reddet'])[2]")).click();
        // arama kutusuna shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazdiralim
        WebElement aramaKutusu = driver.findElement(By.cssSelector("#APjFqb"));

        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java");
        bekle(2);
        aramaKutusu.sendKeys(Keys.ENTER);
        /*
        Yukaridaki ornekte action class'i kullanmadan da istedigim metni buyuk kucuk harf ile yazdirabilirim
        ilk yazdigimiz Keys.Shift shift tusuna basili tutar ikinci yazdigimiz Keys.Shift shift tusunu serbest birakir
         */

        /*
        odev

        // google anasayfasina gidelim
        // arama kutusuna "Selenium" yazin ve enter tusuna basin
        // aratiigimiz kelimeyi arama kutusundan ctrl+x ile keselim
        // tekrar google sayfasina gidip kestigimiz kelimeyi ctrl+v ile yapistirip tekrar aratalim
         */






    }
}
