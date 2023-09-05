package day13_Exception_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase{
    @Test
    public void test01() {
        /*
        STALEELEMENTREFERENCEEXCEPTION
            Bir webelementi locate ettikten sonra sayfada refresh(navigate.refresh),back() yada forward() işlemi
        yaptıysanız ve tekrar locate'ini aldığınız webelementi kullanmak isterseniz bu hatayı alırsınız.
        Çünkü sayfa yenileme, sayfada ileri geri yapma işleminden sonra driver locate'ini aldığını elementi
        eskimiş element olarak görür ve bu hatayı handle etmek için o elementi tekrar locate etmeniz gerekir.
    List<Webelement> linkler = driver.findElements(By.xpath("sdfsdf"))
        Yukarıdaki linklerin olduğu listeyi bir loop içinde hepsine klik yapıcaz
        for(i=0, i<linkler.size, i++){
        linkler.get(i).click
        driver.navigate().back()
        linkler = driver.findElements(By.xpath("sdfsdf"))-->Eğer tekrar liste atama yapmazsak aynı şekilde
        listin içindeki elementleri eskimis kabul edip STALEELEMENTREFERENCEEXCEPTION fırlatacak.
        Dolayısıyla loop içinde list'e tekrar elementlerin atamasını yaparsak bu exception'ı handle etmiş oluruz
        */
        driver.get("https://techproeducation.com");

        //Events linkine tıklayalım
        WebElement link = driver.findElement(By.xpath("(//*[.='Events'])[1]"));
        link.click();
        bekle(2);

        //Back() ile ana sayfaya dönelim
        driver.navigate().back();
        bekle(2);

        //Tekrar Events linkine tıklayalım
        link.click();//-->StaleElementReferenceException

    }

    @Test
    public void test02() {
        driver.get("https://amazon.com");

        // arama kutusunda iphone aratalim

   WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
   aramaKutusu.sendKeys("iphone", Keys.ENTER);
   // back() ile ana sayfaya donelim
        driver.navigate().back();

        // Tekrar arama kutusunda samsung aratlaim
        // asagidaki gibi yeniden elemenetin locate' ini alirsak problem cozulur
      //   WebElement aramaKutusuWE = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("samsung",Keys.ENTER);

        /*
        refresh, back , forward gibi islemlerinden sonra eger elementin locate' ini tazelemezsek
        StaleElementReferenceException hatasini yukaridaki ornekteki gibi aliriz
         */
    }

    @Test
    public void test03() {
        driver.get("https://amazon.com");

        // arama kutusunda iphone aratalim

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        // refresh() ile sayfayi yenile
        driver.navigate().back();

        // Tekrar arama kutusunda samsung aratlaim
        // asagidaki gibi yeniden elemenetin locate' ini alirsak problem cozulur
        //   WebElement aramaKutusuWE = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("samsung",Keys.ENTER);


    }
}
