package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWorkAutomationPractice {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    1.https://www.walmart.com/ sayfasina gidelim
        driver.get("https://youtube.com/");


    }

    @Test
    public void signInButton() throws InterruptedException {
        //    2.Sign in butonuna basalim

        Thread.sleep(2000);

        //'Sign in or create account' butonuna basin button[text()='Sign in or create account']


        //    3.Email kutusuna @isareti olmayan bir mail yazip enter’a
        //    bastigimizda “Invalid email address” uyarisi ciktigini test edelim



    }

    @After
    public void tearDown() throws Exception {

    }




}
