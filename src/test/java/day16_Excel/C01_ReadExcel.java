package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        String dosyaYolu = "src/test/java/resources/Capitals.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın

        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("Sheet1").getRow(0).getCell(1);

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin

        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        // toString() yazarsak, eger bir veri yoksa NullPointerException atar ve hatamizi erkenden farkedebiliriz
        System.out.println("satir3Sutun1 = " + satir3Sutun1);
        Assert.assertEquals("France", satir3Sutun1);

        //Kullanılan satır sayısın bulun

        /*
        getPhysicalNumberOfRows() methodu dolu olan hücreleri sayarak satir sayisini verir. Index 1 den baslar
        getLastRowNum() methodu ise en son kullanilan hücreye kadar dolu veya bos butun satirlari sayar. Index 0 dan baslar
         */
        int kullanilanSatirsayisi = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
        System.out.println("kullanilanSatirsayisi = " + kullanilanSatirsayisi);

        //Sayfadaki satır sayısını yazdırınız
        System.out.println("Satir sayisi = " + workbook.getSheet("Sheet1").getLastRowNum());

        //Ülke-Başkent şeklinde verileri yazdırın

        for (int i = 0; i< workbook.getSheet("Sheet1").getPhysicalNumberOfRows();i++){
            for (int j = 0; j <workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells() ; j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
            }
            System.out.println();
        }

    }

    @Test
    public void test02() throws IOException{
        // Ulke-Baskent seklinde verileri yazdiralim MAP ile

        String dosyaYolu = "src/test/java/resources/Capitals.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        Map<String,String> ulkeBaskent = new LinkedHashMap<>();
        for (int i =0;i<workbook.getSheet("Sheet1").getPhysicalNumberOfRows();i++){
            String ulke = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String sehir = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,sehir+"\n");

        }
        System.out.println(ulkeBaskent);
    }
}
