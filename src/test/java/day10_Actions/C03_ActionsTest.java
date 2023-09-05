package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ActionsTest extends TestBase {
    @Test
    public void test01() {
        // TechproEducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        // Sayfayi istedigimiz bir miktar asagiya dogru scroll yapalim
        Actions actions = new Actions(driver);

        bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        bekle(2);
        // Sayfayi istedigimiz bir miktar yukariya dogru scroll yapalim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

        /*
            Sayfanin ortalarindaki Bir webelementi locate etmek istedigimizde driver sayfayi actigi zaman webelemeneti
        goremedigi icin bazen sayfayi biraz asagiya dogru scroll yapmamiz gerekebilir.
        bunun icin yukaridaki ornekteki gibi page_down ile bunu gerceklestirebiliriz.
            Sayfadaki bir webelementi locate etiigimiz halde NoSuchElementExc. alirsak
            1- Locate'i tekrar kontrol ederiz,
            2- Webelementin iframe icinde olup olmadigina bakariz,
            3- Driver webelementi goremedigi icin actions class ile scroll yapip elementin gorunur olmasini saglariz

         */


    }

    @Test
    public void actions02() {
        // Techpro sayfasina gidelim

        driver.get("https://techproeducation.com");

        // Sayfanin en altina scroll yapalim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        bekle(2);
        // Sayfanin en ustune scroll yapalim
        actions.sendKeys(Keys.HOME).perform();


    }

    @Test
    public void action03() {

        // Techpro sayfasina gidelim

        driver.get("https://techproeducation.com");

        // Events yazisina kadar scroll yapalim

        WebElement eventYazisi = driver.findElement(By.xpath("(//h2)[1]"));
        new Actions(driver).scrollToElement(eventYazisi).perform();
    }
    /*
    //Amazon sayfasina gidiniz
    // Sayfanin ortalarindaki bir webelementi locate edip o webelemente kadar scroll yapiniz
     */
}
