package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_UploadFile extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim

        WebElement dosyaSec =  driver.findElement(By.id("file-upload"));
       // dosyaSec.click();

        //Yuklemek istediginiz dosyayi secelim.

        // "C:\Users\Sibi\Desktop\B171.txt"
        String dosyayolu = "C:\\Users\\Sibi\\Desktop\\B171.txt";
        dosyaSec.sendKeys(dosyayolu);
        bekle(2);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //"File Uploaded!" textinin goruntulendigini test edelim

        WebElement fileUploadText = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("File Uploaded!",fileUploadText.getText());
    }

    @Test
    public void test02() {
        // Test sayfasını aç
        driver.get("https://www.ilovepdf.com/compress_pdf");

        // Dosya seçme düğmesini bul ve tıkla
        driver.findElement(By.xpath("//*[.='Select PDF files']")).click();

        // Dosya yüklemek için Robot sınıfını kullan
        String dosyaYolu = "buraya pdf uzantili dosya yolu gerekiyor";
        bekle(3);
        uploadFilePath(dosyaYolu);
    }
}
