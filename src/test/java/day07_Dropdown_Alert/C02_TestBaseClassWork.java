package day07_Dropdown_Alert;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_TestBaseClassWork extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        // Arama kutusuna Java yazdiralim
        driver.findElement(By.cssSelector("#searchHeaderInput")).sendKeys("Java");
    }
}
