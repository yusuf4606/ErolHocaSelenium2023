package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class HomeWork_01 {
    @Test
    public void test01() throws IOException {

        String sayfaAdi = "Sayfa1";
        //-1.satirdaki 2.hucreye gidelim ve yazdiralim

        FileInputStream fis = new FileInputStream("src/test/java/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println("satir1Hucre2 : " + workbook.getSheet(sayfaAdi).getRow(0).getCell(1)); // satir1Hucre2 : Başkent (İngilizce)

        //-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

        String satir01Hucre02 = workbook.getSheet(sayfaAdi).getRow(0).getCell(1).toString();
        System.out.println("satir01Hucre02 = " + satir01Hucre02); // satir01Hucre02 = Başkent (İngilizce)

        //-2.satir 4.cell’in afganistan’in baskenti oldugunu test  edelim

        String satir2Hucre4 = workbook.getSheet(sayfaAdi).getRow(1).getCell(3).toString();
        String afganistanBaskent = "Kabil";
        Assert.assertEquals(afganistanBaskent,satir2Hucre4);

        //-Satir sayisini bulalim

        int satirSayisi = workbook.getSheet(sayfaAdi).getLastRowNum();
        System.out.println("satirSayisi = " + satirSayisi);  //190

        //-Fiziki olarak kullanilan satir sayisini bulun

        int kullanilanSatirSayisi = workbook.getSheet(sayfaAdi).getPhysicalNumberOfRows();
        System.out.println("kullanilanSatirSayisi = " + kullanilanSatirSayisi);

        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String> landNameCityName = new LinkedHashMap<>();

        int nameOfLandSize = workbook.getSheet(sayfaAdi).getPhysicalNumberOfRows();

        for (int i = 0; i <nameOfLandSize ; i++) {
            String nameOfLand = workbook.getSheet(sayfaAdi).getRow(i).getCell(0).toString();
            String nameOfCity = workbook.getSheet(sayfaAdi).getRow(i).getCell(1).toString();
            landNameCityName.put(nameOfLand,nameOfCity+"\n");

        }
        System.out.print(landNameCityName);

    }
}
