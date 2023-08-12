package day04_GetTagNameGetAttribute_Xpat_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//      a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
//      b.Search(ara) “city bike”
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Thread.sleep(2000);
        searchBox.sendKeys("city bike"+Keys.ENTER);
                    /*
                Xpath kullanımına // sembolleri ile başlarız. Bu sembollerden sonra tag name belirtmemiz gerekir.
            tag name yerine * sembolunü kullanabilirsiniz. Bu sembol tag name farketmeksizin anlamına gelir.
            sonra köşeli parantez açıp kullanacağımız attribüte'ten önce @ sembolu kullanmalıyız. Sonrasında da
            attribüte yazılıp = TEK TIRNAK içince atributün değeri yazılmalıdır ve köşeli parantez kapatılır.
            SYNTAX:
                    //tagName[@attributeName='atributeDeğeri']
                    //*[@*='atribüteDeğeri'] --> Eğer bu kullanımda birden fazla sonuç verirse * koyduğumuz yerlere
                                                 tagName ve attributeName'i belirtmemiz gerekir. Buna rağmen birden fazla
                                                 sonuç verirse o webelementin index'ini aşağıdaki şekilde belirtiriz.
                                                 (//tagName[@attributeName='atributeDeğeri'])[index]
                Xpath kullanamadığız zaman bir webelementin locate'i ile alakalı birden fazla sonuç çıkarsa bütün sonuçları
            bir list'e atıp index ile o webelemnti handle etmen gerekecekti. Dolayısıyla yukarıdaki örnekteki gibi
            xpath kullanımında birden fazla sonuç alırsak direk xpath üzerinden index ile bunu çözebiliriz.
             */
//      c.Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın

        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String [] sonucSayisi = sonuc.getText().split(" ");
        System.out.println("sonuc sayisi :  "+sonucSayisi[2]);


//      d.Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
      //driver.findElement(By.xpath("//img[@class='s-image']")).click();    // asagidaki yontem de bu yontem de ayni isi goruyor
      driver.findElement(By.xpath("(//h2//a)[1]")).click();
      // xpath alirken direk tag'lari kullanarak unique  sonuc vermezse yukaridaki ornekteki gibi index ile elementi handle edebiliriz

      Thread.sleep(2000);


      // sayfayi kapat
        driver.close();
    }
}
