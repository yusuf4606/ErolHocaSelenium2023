package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_Alert extends TestBase {
    /*
    Eger bir sayfadaki butona tikldigimizda bir uyari penceresi cikiyorsa ve bu cikan uyari pencresine
    sag click yapilamiyorsa (incele/inspect) bu ttur uyari pencerelerine Java Script alert denir.
    bu uyari penceresi handle edilemedigi iciin driveri  bu pencereye gecis yaptirmak gerekir,
    bunun icinde switchTo() methodu kullanilir  driver.switchTo.alert() methodu ile alerte gecis yapariz
    ve alert'i onaylamak icin accept(), iptal etmek icin dissmis() , alert uzerindeki yaziyi almak icin getText()
    ve alertteki     mesaj kutusuna bir text gondermek icin  senkKeys() methodunu kullaniriz
    */

    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    "successfuly" icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

 */

    @Test
    public void acceptAlert() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(2);

        driver.switchTo().alert().accept();   // driver ' a alert e gec ve onayla komutunu verdik

        String resultMessage = driver.findElement(By.cssSelector("#result")).getText();
        String expectedMessage = "You successfully clicked an alert";
        bekle(1);
        Assert.assertEquals(expectedMessage, resultMessage);


    }

    @Test
    public void dissmisAlert() {
//        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//        "successfuly" icermedigini test edin.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);

        driver.switchTo() // -- gecis yap
                .alert() // -- alert e gecis yap
                .dismiss();  //  -- cancel

        String resultMessage = driver.findElement(By.xpath("(//p)[2]")).getText();
        String unexpectedMessage = "successfuly";
        Assert.assertFalse(resultMessage.contains(unexpectedMessage));
    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(2);
        driver.switchTo().alert().sendKeys("java");
        bekle(2);
        driver.switchTo().alert().accept();

        String resultMessage = driver.findElement(By.xpath("(//p)[2]")).getText();
        String expectedMessage = "java";

        Assert.assertTrue(resultMessage.contains(expectedMessage));

    }
}
