package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    @Test
    public void iframe() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
        WebElement anaSayfadakiText = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']"));
        String actualResult = anaSayfadakiText.getText();

        Assert.assertTrue(actualResult.contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim

        driver.switchTo().frame(0); // driver i index kullanarak iframe e gecis yaptirdik
        bekle(2);
        WebElement applicationLists = driver.findElement(By.xpath("//h1"));
        bekle(2);

        String expectedText = "Applications lists";

        Assert.assertEquals(expectedText,applicationLists.getText());


        //Son olarak anasayfadaki footer daki 'Povered By' yazisini varligini test edilip
        //driver.get(driver.getCurrentUrl());
        //driver.navigate().refresh();-->Refresh() methodu'da bizi anasayfaya götürür fakat iframe içinde bir form
        // doldurma gibi işlemler yaparsak bunları sıfırlar.
        // refresh() kullandığımızda tüm elementleride yenilediği için tekrar locate almamız
        // gerekebilir.-->staleElementReferansException

        driver.switchTo().defaultContent(); // de kullanabiliriz driver.navigate().refresh();
        bekle(2);
        WebElement poweredByText = driver.findElement(By.xpath("//*[text()='Povered By']"));

        Assert.assertTrue(poweredByText.getText().contains("Povered By"));

        /*
        Iframe(inline frame) bir html dökümanının içine yerleştirilmiş başka bir html dökümanına denir.
    Iframe'deki bir webelementi locate etmek için driver'imizi yine geçiş komutları için kullandığımız
    switchTo() methodu ile iframe'e geçirmeliyiz. Sayfada kaçtane iframe olduğuna bakarak index(index 0'dan başlar) ile
    geçiş yapabiliriz, iframe'i locate ederekte geçiş yapabiliriz yada iframe tag'ındaki id ve name attribute
    değerleri ilede geçiş yapabiliriz.
    SYNTAX;
            driver.switchTo().frame(index yada iframeWE yada iframe id/name atribute değeri)
     */


    }
}
