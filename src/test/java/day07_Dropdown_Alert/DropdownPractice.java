package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class DropdownPractice extends TestBase {
    /*
     Bir class oluşturun: C3_DropDownAmazon
     https://www.amazon.com/ adresine gidin.
    - Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori
    sayisinin 45
    oldugunu test edin
    -Test 2
    1.Kategori menusunden Books secenegini secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin
     */

    @Test
    public void test01() {
      //  https://www.amazon.com/ adresine gidin.
        driver.get("https://amazon.com");

//        Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement aramaKutusuDDM = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select selectDDM = new Select(aramaKutusuDDM);
        List<WebElement>  amazonDDMList  = selectDDM.getOptions();
        System.out.println("amazonDDMList.size() = " + amazonDDMList.size());
        amazonDDMList.stream().forEach(t-> System.out.println(t.getText()));

        Assert.assertEquals(45,amazonDDMList.size());
    }

    @Test
    public void test02() {
//  https://www.amazon.com/ adresine gidin.
        driver.get("https://amazon.com");
        bekle(2);
        driver.navigate().refresh();
        WebElement aramaKutusuDDM = driver.findElement(By.cssSelector("#searchDropdownBox"));

//        -Test 2
//        1.Kategori menusunden Books secenegini secin
        bekle(2);
        selectVisibleText(aramaKutusuDDM,"Books");

//        2. Arama kutusuna Java yazin ve aratin
        bekle(2);
     WebElement searchBox =    driver.findElement(By.cssSelector("#twotabsearchtextbox"));
     searchBox.sendKeys("Java"+ Keys.ENTER);

//        3. Bulunan sonuc sayisini yazdirin
        WebElement result= driver.findElement(By.xpath("//span[.='1-16 of over 20,000 results for']"));

        String resultText = result.getText();

//        4. Sonucun Java kelimesini icerdigini test edin
       Assert.assertTrue(resultText.contains("Java"));
    }
}
