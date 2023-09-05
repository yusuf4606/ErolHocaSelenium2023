package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class HomeWork2 extends TestBase {
    /*
    1.http://zero.webappsecurity.com/ Adresine gidin
     */

    @Test
    public void test01() {
        // 1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

//        2.Sign in butonuna basin
        driver.findElement(By.cssSelector("i[class='icon-signin']")).click();


//        3.Login kutusuna “username” yazin
//        4.Password kutusuna “password.” yazin
//        5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("username" + Keys.TAB, "password" + Keys.TAB + Keys.TAB + Keys.ENTER);

        bekle(2);
        driver.navigate().back();//-->Sayfaya giriş yapabilmek için back() kullandık

//        6.Pay Bills sayfasina gidin

        WebElement onlineBankingSekmesi = driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBankingSekmesi.click();

        WebElement payBillsSekmesi = driver.findElement(By.cssSelector("span[id='pay_bills_link']"));
        payBillsSekmesi.click();

//        7.“Purchase Foreign Currency” tusuna basin

        driver.findElement(By.cssSelector("a[href='#ui-tabs-3']")).click();

//        8.“Currency” drop down menusunden Eurozone’u secin

        WebElement currency = driver.findElement(By.cssSelector("#pc_currency"));
        Select currencySelect = new Select(currency);
        bekle(1);
        currencySelect.selectByVisibleText("Eurozone (euro)");

//        9.“amount” kutusuna bir sayi girin

        driver.findElement(By.cssSelector("#pc_amount")).sendKeys("250");
        bekle(1);
//        10.“US Dollars” in secilmedigini test edin

        WebElement dollarsRadioButton = driver.findElement(By.cssSelector("#pc_inDollars_true"));

        Assert.assertTrue(!dollarsRadioButton.isSelected());

//        11.“Selected currency” butonunu secin  #pc_inDollars_false

        driver.findElement(By.cssSelector("#pc_inDollars_false")).click();
        bekle(1);

//        12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin

        driver.findElement(By.cssSelector("#pc_calculate_costs")).click();
        bekle(1);
// sonra “purchase” butonuna basin  #purchase_cash

        driver.findElement(By.cssSelector("#purchase_cash")).click();
        bekle(1);
//“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

        WebElement fCCSPText = driver.findElement(By.cssSelector("div#alert_content"));

        String expextedResult = "Foreign currency cash was successfully purchased.";
        String actualResult = fCCSPText.getText();

        Assert.assertTrue(actualResult.equals(expextedResult));
        bekle(1);

        driver.close();
    }
}
