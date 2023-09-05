package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Faker_Test extends TestBase {
    @Test
    public void test01() {


        //1. "https://facebook.com" Adresine gidin

        driver.get("https://facebook.com");
        bekle(1);

        // cerezleri kabul et

        driver.findElement(By.xpath("//*[@data-cookiebanner='accept_button']")).click();
bekle(1);
//2. “create new account” butonuna basin
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        bekle(1);
// 3. “firstName” giris kutusuna bir isim yazin
// 4. “surname” giris kutusuna bir soyisim yazin
// 5. “email” giris kutusuna bir email yazin
// 6. “email” onay kutusuna emaili tekrar yazin
// 7. Bir sifre girin
//8. Tarih icin gun secin
//9. Tarih icin ay secin
//10. Tarih icin yil secin
//11. Cinsiyeti secin
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        firstName.sendKeys(faker.name().firstName(),   // fake isim yazdirdik
                Keys.TAB,faker.name().lastName(),                   // fake soyisim yazdirdik
                Keys.TAB,email);                                    // fake email girdik
                bekle(2);
        WebElement emailTekrar = driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']"));
        emailTekrar.sendKeys(email,                   // fake email tekrar girdik
                Keys.TAB,                                          // password kutusuna geldik
                faker.internet().password(),                       // fake password girdik
                Keys.TAB,                                          // tab a bastik 2 defa
                Keys.TAB,"2",
                Keys.TAB,"6",
                Keys.TAB,"2000");    // buradan sonra iki defa tab a basip Keys.Arrow_Right yaparsak erkek secenegini
        // isaretleyebiliriz veya asagidaki gibi devam edebiliriz
        bekle(2);
      WebElement erkek =   driver.findElement(By.xpath("//input[@value='2']"));
      erkek.click();

//12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test  edin.
        Assert.assertTrue(erkek.isSelected());

        bekle(2);

        // Kaydol button a tikla

        driver.findElement(By.cssSelector("button[name='websubmit']")).click();



    }

}
