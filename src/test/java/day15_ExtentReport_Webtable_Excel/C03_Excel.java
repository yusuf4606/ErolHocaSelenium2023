package day15_ExtentReport_Webtable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_Excel {
    @Test
    public void test01() throws IOException {
        /*
        Eger projemizde excell dosyasondan veri almak istiyorsak oncelikle mmvnrepository.com adresinden
        poi aratip 'poi-ooxml' ve 'poi' dependency'lerini pom.xml' e yapistirmamiz gerekir,
        her iki dependency nin de versiyonlari ayni olmali
         */

        // -- 1 -- projemize resources package altina koydugumuz excell dosyamizin yolunu aliriz
        String dosyaYolu = "src/test/java/resources/Capitals.xlsx";

        // -- 2 -- dosyayi okuyabilmemiz icin javada akisa almamiz gerekir
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // -- 3 -- java ortaminda bir excell dosyasi olusturmak icin
        Workbook workbook = WorkbookFactory.create(fis);

        // -- 4 -- olusturulan excell dosyasinda sayfa secmemiz gerekir
        Sheet sheet = workbook.getSheet("Sheet1");

        // -- 5 -- belirttigimiz sayfadaki satir bilgisini secmemiz gerekir

        Row row = sheet.getRow(0);  // index sifirdan baslar

        // -- 6 -- belirttigimiz satirdaki hucre bilgisini secmemiz gerekir

        Cell cell = row.getCell(0); // 0. hucreyi verir

       //  System.out.println(); icinde cell bilgisini yazdirdigimizda 1. satir 1. hucredeki bilgiyi verir

        System.out.println(cell);

        /*
        NOT: Excel dosyanız açıkken işlem yapmayınız
        Excel dosyasında herhangi bir hücrede değişiklik yaptıysanız excel'i kapatırken kaydetmeyiniz
        */


    }

    @Test
    public void test02() throws IOException {
        // *** Pratik Cozum
        // 1. satir ve 1. sutun bilgisini yazdiralim

        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0)); // COUNTRY

    }
}
