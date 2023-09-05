package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HomeWork_Amazon extends TestBase {

    @Test
    public void test01() {
        //Amazon sayfasina gidiniz
        driver.get("https://amazon.com");

        driver.navigate().refresh();
        // Sayfanin ortalarindaki bir webelementi ("New International") locate edip o webelemente kadar scroll yapiniz

        WebElement newInt = driver.findElement(By.xpath("//h2[.='Deals Under $25']")); // surekli  guncelleniyor sayfa, farkli web element olabilir


        Actions actions = new Actions(driver);
        bekle(2);
        actions.moveToElement(newInt).perform();
    }
}
