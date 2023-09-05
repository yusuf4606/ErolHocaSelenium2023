package day08_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class HomeWork1 extends TestBase {

    @Test
    public void test01() {
        //    https://html.com/tags/iframe/ gidiniz
        driver.get("https://html.com/tags/iframe/");
        bekle(2);

        //    youtube daki play butonuna basınız

        driver.switchTo().frame(0);
        bekle(1);
        driver.findElement(By.cssSelector("button[class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
    }
}
