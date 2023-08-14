package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZeroWebappSecurityTekrar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("i[class='icon-signin']")).click();
        //Login alanine  "username" yazdirin
        //Password alanine "password" yazdirin
        //Sign in buttonuna tiklayin
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("username"+Keys.TAB,"password"+Keys.TAB+Keys.TAB+Keys.ENTER);
        //Online Banking altındaki Pay Bills sayfasina gidin
        Thread.sleep(3000);
        driver.navigate().back();//-->Sayfaya giriş yapabilmek için back() kullandık

        WebElement onlineBankingSekmesi = driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBankingSekmesi.click();

        WebElement payBillsSekmesi = driver.findElement(By.cssSelector("span[id='pay_bills_link']"));
        payBillsSekmesi.click();



        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //tarih kismina "2020-09-10" yazdirin
        //Pay buttonuna tiklayin

        WebElement amount = driver.findElement(By.cssSelector("input[id='sp_amount']"));
        amount.sendKeys("1604"+Keys.TAB,"2020-09-10"+Keys.TAB+Keys.TAB+Keys.ENTER);

        //"The payment was successfully submitted." mesajinin ciktigini control edin

        WebElement tPWSS = driver.findElement(By.xpath("(//span)[1]"));
        String expectedResult = "The payment was successfully submitted.";
        String actualResult = tPWSS.getText();
        if (actualResult.equals(expectedResult)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        // sayfayi kapat

        driver.close();
         /*
            ÖDEV:
            https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
            Add Element butonuna basin 100 kez basınız
            Delete butonuna 90 kez basınız
            Ve 90 kez basıldığını doğrulayınız
             */
    }
}
