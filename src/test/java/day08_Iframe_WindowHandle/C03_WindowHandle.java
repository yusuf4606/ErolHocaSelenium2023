package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techProWindowHandle = driver.getWindowHandle();
        bekle(2);
        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education", driver.getTitle());

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String yotubeWindowHandle = driver.getWindowHandle();
        bekle(2);

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techProWindowHandle);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(yotubeWindowHandle);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);

    }

    @Test
    public void windowHandle2() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techProWindowHandle = driver.getWindowHandle();
        bekle(2);
        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education", driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String yotubeWindowHandle = driver.getWindowHandle();
        bekle(2);

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        bekle(2);
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techProWindowHandle);
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(yotubeWindowHandle);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
    }

    @Test
    public void windowHandle3() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        bekle(2);
        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education", driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");

        bekle(2);

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");

        bekle(2);

        List<String> pencerelerListesi = new ArrayList<>(driver.getWindowHandles());
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(pencerelerListesi.get(0));
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(pencerelerListesi.get(1));
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(pencerelerListesi.get(2));
        selectWindow(0);

    }
}
