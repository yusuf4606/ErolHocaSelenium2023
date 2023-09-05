package day07_Dropdown_Alert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import java.util.List;

public class HomeWork1 extends TestBase {

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //   1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdown = driver.findElement(By.cssSelector("select#dropdown"));

        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByIndex(1);     // index ile 1. secenek secildi
        selectDropdown.getFirstSelectedOption().getText();

//        3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        selectDropdown.selectByVisibleText("Option 1");
        selectDropdown.getFirstSelectedOption().getText();

//        4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> dropdownTumSecenekler = selectDropdown.getOptions();
        dropdownTumSecenekler.stream().forEach(t -> System.out.println(t.getText()));

//        5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

        if (dropdownTumSecenekler.size() == 4) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
