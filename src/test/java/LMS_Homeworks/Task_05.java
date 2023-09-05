package LMS_Homeworks.day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task_05 extends TestBase {
//  - http://szimek.github.io/signature_pad/ sayfasına gidiniz
//  - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
//  - Çizimden sonra clear butonuna basınız
//  - Sayfayi kapatiniz

    @Test
    public void test01() {

        //  - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("https://szimek.github.io/signature_pad/");

        //  - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz

        bekle(2);
        WebElement cizimAlani = driver.findElement(By.xpath("//canvas"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(cizimAlani)
                .moveByOffset(70,0)
                .moveByOffset(70,-70)
                .moveByOffset(-70,-70)
                .moveByOffset(0,70)
                .moveByOffset(70,0)
                .release()
                .perform();

            bekle(2);

        //  - Çizimden sonra clear butonuna basınız

        driver.findElement(By.cssSelector("button[class='button clear']")).click();
        bekle(2);
        //  - Sayfayi kapatiniz
        bekle(2);

        driver.quit();
    }
    @Test
    public void name() throws InterruptedException {
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver).clickAndHold(yaziTahtasi);

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5,-5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 12; i++) {
            actions.moveByOffset(5,0);
        }
        actions.release().build().perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();

    }
}
