package day15_ExtentReport_Webtable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTable extends TestBase {
    @Test
    public void test01() {
        /*
        table      --> tablo ismi
        thead  --> tablodaki sutun basliklari
        tr       --> satir
        td    --> veri
        tbody  --> table body
         */
        //https://the-internet.herokuapp.com/tables sayfasına gidelim

        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Table1’i print edin
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("table1.getText() = " + table1.getText());

        //Task 2 : 3. Row' datalarını print edin  Task 3 : Son row daki dataları print edin

        //Task 3 : Son row daki dataları print edin
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        /*
            Xpath kullanımında eğer bir webtable'da son satır bilgisi istenirse yukarıdaki örnekteki gibi
        satır içindeki index yerine last() function'ı kullanabilirisiniz
         */
        System.out.println("Son Satir Verileri :" + sonSatir.getText());

        //Task 4 : 5. Column datalarini print edin
        //Task 4 : 5. Column(sütun) datalarini print edin
        WebElement besinciBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println("Beşinci Sütundaki Başlık : " + besinciBaslik.getText());
        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(e -> System.out.println(e.getText()));


        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData  Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin

        printData(2, 3);

        /*
        ÖDEV:
        3. Satırdaki 1. ve 2. sütun bilgilerini yazdırınız. //-->position()>=1 and position()<=2
        */

        System.out.println("3. Satırdaki 1. ve 2. sütun bilgileri ");

        List<WebElement> row3cell1cell2 = driver.findElements(By.xpath("(//tbody)[1]/tr[3]/td[position()<=2]"));

        row3cell1cell2.forEach(t-> System.out.print(t.getText()+" "));


    }

    private void printData(int satir, int sutun) {
        System.out.println("******************************************");
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(satirSutun.getText());
    }

        /*
        ÖDEV:
        3. Satırdaki 1. ve 2. sütun bilgilerini yazdırınız. //-->position()>=1 and position()<=2
        */


}

