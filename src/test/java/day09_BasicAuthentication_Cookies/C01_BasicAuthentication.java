package day09_BasicAuthentication_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {
    @Test
    public void test01() {
        //Aşağıdaki bilgileri kullanarak authentication yapınız:

        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //    Başarılı girişi doğrulayın. "Congratulations! You must have the proper credentials." yazisinin ciktigini dogrulayin
        String text = driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals("Congratulations! You must have the proper credentials.",text);

        // Elemental selenium linkine tiklayalim

        driver.findElement(By.xpath("(//a)[2]")).click();

        window(2);   // -- testbase deki window() ile yeni acilan sayfaya gectik


        // basligin Elemental Selenium icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));

    }
}
