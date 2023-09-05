package LMS_Homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Task_02 extends TestBase {

    // -Amazon sayfasına gidelim
    //-Arama Kutusundaki Dropdown menuyu yazdıralım
    //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    //   başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

    @Test
    public void test01() {
        // -Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        //-Arama Kutusundaki Dropdown menuyu yazdıralım

        WebElement aramaKutusuDDM = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select selectAramaKutusuDDM = new Select(aramaKutusuDDM);

        List<WebElement> aramaKutusuTumSecenekler = selectAramaKutusuDDM.getOptions();
        int sira = 1;
        for (WebElement w : aramaKutusuTumSecenekler) {
            System.out.println(sira + ". " + w.getText());
            sira++;
        }
    }

    @Test
    public void test02() {

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //   başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

        driver.get("https://amazon.com");
        driver.navigate().refresh();
        for (int i = 1; i < 6; i++) {
            WebElement aramaKutusuDDM = driver.findElement(By.cssSelector("#searchDropdownBox"));
            Select selectAramaKutusuDDM = new Select(aramaKutusuDDM);

            List<WebElement> aramaKutusuTumSecenekler = selectAramaKutusuDDM.getOptions();

            aramaKutusuTumSecenekler.get(i).click();

            bekle(1);
           WebElement araButonu =  driver.findElement(By.id("nav-search-submit-button"));
           araButonu.click();
            bekle(1);
            System.out.println(i + ". baslik : " + driver.getTitle());
            bekle(1);
        }


    }
}
