package LMS_Homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task_01 extends TestBase {

    //  - ebay sayfasına gidiniz
    //- electronics bölümüne tıklayınız
    //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    //- Her sayfanın sayfa başlığını yazdıralım

    @Test
    public void test01() {

        //    - ebay sayfasına gidiniz
        driver.get("https://ebay.com");
        //- electronics bölümüne tıklayınız
        bekle(2);
        driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click();
        bekle(2);
        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım //- Her sayfanın sayfa başlığını yazdıralım
        List<WebElement> resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));

        for (int i = 0; i < resimler.size(); i++) {
            bekle(1);
            resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            bekle(1);
            resimler.get(i).click();

            System.out.println((i+1) + ".Title : " + driver.getTitle());
            bekle(1);
            driver.navigate().back();
        }
    }
}