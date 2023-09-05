package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class HomeWork_02 {


    @Test
    public void writeExcelTest() throws IOException {


        //1)Yeni bir Class olusturalim WriteExcel
        //2)Yeni bir test method olusturalim writeExcelTest()

        String sayfaAdi = "Sayfa1";
        FileInputStream fis = new FileInputStream("src/test/java/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        workbook.getSheet(sayfaAdi).getRow(0).    //3)Adimlari takip ederek 1.satira kadar gidelim
                createCell(4).                       //4)5.hucreye yeni bir cell olusturalim
                setCellValue("Nufus");                  //5)Olusturdugumuz hucreye “Nufus” yazdiralim


        //6)2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet(sayfaAdi).getRow(1).createCell(4).setCellValue(1500000);


        //7)10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet(sayfaAdi).getRow(9).createCell(4).setCellValue(250000);

        //8)15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet(sayfaAdi).getRow(14).createCell(4).setCellValue(54000);

        // 9)Dosyayi kaydedelim   //10)Dosyayi kapatalim
        FileOutputStream fos = new FileOutputStream("src/test/java/resources/ulkeler.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();

    }
}
