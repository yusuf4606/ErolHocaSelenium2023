package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
import java.util.Set;

public class HomeWork2 extends TestBase {

    //https://the-internet.herokuapp.com/windows sayfasına gidiniz/Elemental Selenium linkine tıklayınız
    //sayfa başlığının Elemental Selenium içerdiğini test ediniz

    @Test
    public void test01() {

     //   https://the-internet.herokuapp.com/windows sayfasına gidiniz

        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        // Elemental Selenium linkine tıklayınız
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).click();

        //    sayfa başlığının Elemental Selenium içerdiğini test ediniz
        Set<String> pencereler = driver.getWindowHandles();
        for (String w : pencereler) {
            System.out.println(w);
            if (!w.equals(ilkSayfaHandleDegeri)) {
                driver.switchTo().window(w);
            }
        }
        bekle(2);
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));
    }
}
