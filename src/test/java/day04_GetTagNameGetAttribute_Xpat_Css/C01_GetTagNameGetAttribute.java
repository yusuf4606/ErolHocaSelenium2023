package day04_GetTagNameGetAttribute_Xpat_Css;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GetTagNameGetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        // arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='searchHeaderInput']"));

        // arama kutusunun tag name'inin input oldugunu test edelim
        String aramaKutusuTagName= aramaKutusu.getTagName();
        String aramaKutusuTagNameExpectedResult = "input";

        if (aramaKutusuTagName.equals(aramaKutusuTagNameExpectedResult)){
            System.out.println("Arama Kutusu TagName Test Passed");
        } else {
            System.out.println("Arama Kutusu TagName Test Failed");
        }
        // arama kutusunun class attribute nün degerinin 'form-input' oldugunu test ediniz
        String aramaKutusuAttributeName= aramaKutusu.getAttribute("class");
        String aramaKutusuAttributeNameExpectedResult = "form-input";

        if (aramaKutusuAttributeName.equals(aramaKutusuAttributeNameExpectedResult)){
            System.out.println("Arama Kutusu AttributeName Test Passed");
        } else {
            System.out.println("Arama Kutusu AttributeName Test Failed");
        }
        // sayfayi kapat
        driver.close();

        // //*[@id="react-header"]/div[2]/div/div/nav/div[3]/div/form

    }
}
