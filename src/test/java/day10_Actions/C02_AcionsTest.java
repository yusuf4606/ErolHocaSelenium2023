package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_AcionsTest extends TestBase {
    @Test
    public void action() {

        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        driver.navigate().refresh();
        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        WebElement accountList = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

        Actions actions = new Actions(driver);

        actions.moveToElement(accountList).perform(); // Mouse 'u locate ettigimiz webelemenetin uzerine moveToElement()
                                                        // ile goturup tikladik ve perform() ile islemi tamamladik
        bekle(2);
        driver.findElement(By.xpath("//span[.='Account']")).click();
        bekle(2);

        //Acilan sayfanin Title in "Your Account" icerdigini dogrula

        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}
