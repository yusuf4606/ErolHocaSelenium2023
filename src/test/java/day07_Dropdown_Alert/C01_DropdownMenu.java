package day07_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropdownMenu {
    /*
       Dropdown menü; alt başlıkların listelendiği sayfadaki bir webelemente denir.
   Dropdown webelementine sendKeys() methodu ile listede bulunan seçeneklerden istediğimizi gönderebiliriz.
   Gönderemediğimiz durumlarda Select class'ından bir obje oluşturarak bu oluşturduğumuz objeye parametre olarak
   locate ettiğimiz dropdown webelementini yazarız. Bu oluşturduğumuz obje ile byIndex,byvisibletext ve byValue
   methodları ile dropdown menudeki seceneklerden istediğimizi secebiliriz. getOptions() methodu ile tüm dropdown
   menüdeki seçenekleri listeleyebiliriz. getFirstSelectedOption() methodu ile dropdown menüde ilk seçili olan seçeneği
   getirir.
   Bir Dropdown menu <select> tag'ına sahip değilse Select class'ını kullanamazsınız
    */
    /*
Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
-3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }



    @Test
    public void test01() {
//        1.Method:
//        a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        //        b. Select objesi olustur
        Select selectYil = new Select(year);
        Select selectAy = new Select(month);
        Select selectGun = new Select(day);



//        c. Select object i kullanarak 3 farkli sekilde secim yapiniz
//        select.getOptions(); // hepsini getir
//        select.getFirstSelectedOption();  // secili olani getir
//        select.deselectAll(); // secili olanlari sil

        selectYil.selectByIndex(5);   // besinci indexteki ni secti
        selectAy.selectByVisibleText("May");
        selectGun.selectByValue("22");

    }
    @Test
    public void test02() {
//        2.Method:
//        a. Tüm eyalet isimlerini yazdıralım
        WebElement eyaletler = driver.findElement(By.cssSelector("select#state"));
        Select select = new Select(eyaletler);

        // System.out.println(select.getOptions().get(2).getText());  // 2. indexteki elemani yazdirir
        List<WebElement> eyaletListesi = select.getOptions();
        eyaletListesi.forEach(t-> System.out.println(t.getText()));  //--> Lambda ile yazdirdik
    }

    @Test
    public void test03() {
//        3.Method:
//        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

        WebElement state = driver.findElement(By.cssSelector("select#state"));

        Select select = new Select(state);
        Assert.assertEquals("Select a State",select.getFirstSelectedOption().getText());
    }

    @After
    public void tearDown() throws Exception {

    }
}
