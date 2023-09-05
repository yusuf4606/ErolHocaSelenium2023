package day08_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Pratik01 extends TestBase {
    // https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe
    // Iframe içine geçiş yap
    // Iframe içerisindeki metni al
    // Iframe'den çıkış yap


    @Test
    public void test01() {
        // https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe");

        // cookies kabul et
        driver.findElement(By.cssSelector("#accept-choices")).click();
        bekle(2);
        // Iframe içine geçiş yap

        driver.switchTo().frame("iframeResult");
        bekle(2);
        WebElement iframeIc = driver.findElement(By.xpath("//iframe[@src='demo_iframe.htm']"));
        // Iframe içerisindeki metni al
        driver.switchTo().frame(iframeIc);
        bekle(2);
        WebElement iframeText = driver.findElement(By.xpath("//h1[.='This page is displayed in an iframe']"));
        System.out.println("Iframe icindeki text = " + iframeText.getText());
        bekle(2);
        driver.switchTo().defaultContent();

    }
}
