package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HomeWorkGoogleCopyPaste extends TestBase {
    // google anasayfasina gidelim
    // arama kutusuna "Selenium" yazin ve enter tusuna basin
    // aratigimiz kelimeyi arama kutusundan ctrl+x ile keselim
    // tekrar google sayfasina gidip kestigimiz kelimeyi ctrl+v ile yapistirip tekrar aratalim

    @Test
    public void test01() {
        // google anasayfasina gidelim
        driver.get("https://google.com");

        // cerezleri reddet
        driver.findElement(By.xpath("(//*[.='Tümünü reddet'])[2]")).click();

        // arama kutusuna "Selenium" yazin ve enter tusuna basin
        WebElement aramaKutusu = driver.findElement(By.cssSelector("#APjFqb"));
        aramaKutusu.sendKeys("Selenium");
        bekle(1);
        aramaKutusu.sendKeys(Keys.ENTER);
        bekle(2);

        // aratigimiz kelimeyi arama kutusundan ctrl+a ile secelim/tarayalim
        driver.findElement(By.cssSelector("#APjFqb")).sendKeys(Keys.CONTROL,"a");
        bekle(2);
        // aratigimiz kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.cssSelector("#APjFqb")).sendKeys(Keys.CONTROL,"x");
        bekle(2);

        // tekrar google sayfasina gidip kestigimiz kelimeyi ctrl+v ile yapistirip tekrar aratalim

        driver.get("https://google.com");
        bekle(2);
        driver.findElement(By.cssSelector("#APjFqb")).sendKeys(Keys.CONTROL,"v");
        driver.findElement(By.cssSelector("#APjFqb")).sendKeys(Keys.ENTER);


    }
}
