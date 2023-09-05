package day11_Faker_Files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesExists {
    @Test
    public void test01() {
        /*
        Bilgisayarimizdaki bir dosyanin varligini test edebilmek icin
        -- oncleikle dosyanin yolunualimak gerekir
        --  Files.exists(Paths.get(dosyaYolu)) Files classindan exists() methodu ile dosya yolunun varligini test edebiliriz
        yukaridaki kod true veya false return eder
        dolayisiyla bu kodu Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))) seklinde yazarak dosya vaersa test passed yoksa failed olur
         */

        /*

         */
        // Masaüstünde bir dosya olusturalim
        // w10 ve alti surumlerde dosyanin uzerine imleci getirip SHIFT+SAG TIK yapinca "Yol olarak kopyala" secenegine tiklayarak aliriz
        // C:/Users/Sibi/Desktop/B171.txt
        String dosyaYolu = "C:/Users/Sibi/Desktop/B171.txt";

        // Ve dosyanin varligini dogrulayalim
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test02() {
        /*
    Ortak calismalarda bir server uzerinden bir dosya yolu almak istersek, her kullanicinin bilgisayarinin anayolu
    farkli olabilir ve serverdeki dosyanin yolu ortaktir. Dolyaisiyla Syste.getProperty(user,home) methodu ile
    bilgisasyarimizin ana yolunu alabilir, serverdaki ortak yol ile bunu birlestirip dosyanin yolunu dinamik olarak
    alabiliriz
         */

        // Test01 methodundaki gibi dosyanin yolunu dogrulayalim

        System.out.println(System.getProperty("user.home"));
        String farkliYol = System.getProperty("user.home");   //--> Herkeste farkli olan yol

        // "C:\Users\Sibi           \Desktop\B171.txt"
        // "C:\Users\Sibi\Desktop\B171.txt"
        String ortakYol = "/Desktop/B171.txt";   // --> Server ' daki dosyanin yolu
        String dosyaYolu = farkliYol+ortakYol;   // -- Bu sekilde dosyanin yolunu aldik


        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
