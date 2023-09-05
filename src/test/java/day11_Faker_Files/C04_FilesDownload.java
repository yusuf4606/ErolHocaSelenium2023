package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilesDownload extends TestBase {
    @Test
    public void test01() {
        String farkliyol = System.getProperty("user.home");
        String ortakYol = "/Downloads/b10 all test cases, code.docx";
        String dosyaYolu = farkliyol+ortakYol;

        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi");
        }
        //        2.https://testcenter.techproeducation.com/index.php?page=filedownload adresine gidelim.

        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //        3.b10 all test cases dosyasını indirelim

        driver.findElement(By.xpath("//*[.='b10 all test cases, code.docx']")).click();
        bekle(5);

        //        4.Dosyanın başarıyla indirilip indirilmediğini test edelim
        // "C:\Users\Sibi\Downloads\b10 all test cases, code.docx"

        String farkliAnayol = System.getProperty("user.home");
        String ortakYoll = "/Downloads/b10 all test cases, code.docx";
        String path = farkliyol+ortakYol;
        System.out.println(Files.exists(Paths.get(path)));
        Assert.assertTrue(Files.exists(Paths.get(path)));




    }
}
