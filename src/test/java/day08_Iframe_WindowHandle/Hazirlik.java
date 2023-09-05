package day08_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Hazirlik extends TestBase {
    @Test
    public void iframeTest01() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        // index ile iframe

        driver.switchTo().frame(0);
        bekle(2);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        bekle(2);
        paragraf.clear();
        bekle(2);

        paragraf.sendKeys("Iframe icindeyim ");
        bekle(1);


    }

    @Test
    public void iframeTest02() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        // id attribute u  ile iframe

        driver.switchTo().frame("mce_0_ifr");
        bekle(2);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        bekle(2);
        paragraf.clear();
        bekle(2);

        paragraf.sendKeys("Iframe icindeyim ");
        bekle(1);
    }@Test
    public void iframeTest03() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        // id attribute u  ile iframe

        driver.switchTo().frame("mce_0_ifr");
        bekle(2);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        bekle(2);
        paragraf.clear();
        bekle(2);

        paragraf.sendKeys("Iframe icindeyim ");
        bekle(1);
    }
}
