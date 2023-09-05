package LMS_Homeworks.day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task_04 extends TestBase {
    //https://demoqa.com/ url'ine gidin.
    //Alerts, Frame & Windows Butonuna click yap
    //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
    //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
    //New Tab butonunun görünür olduğunu doğrula
    //New Tab butonuna click yap
    //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
    //İlk Tab'a geri dön
    //New Tab butonunun görünür olduğunu doğrula

    @Test
    public void test01() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        bekle(2);
        //Alerts, Frame & Windows Butonuna click yap
        WebElement alertFrameWindowButonu = driver.findElement(By.xpath("(//h5)[3]"));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        alertFrameWindowButonu.click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement text = driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']"));
        Assert.assertEquals("Please select an item from left to start practice.", text.getText());
        System.out.println("Assert 1 calisti..");

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//span[.='Browser Windows']")).click();
        bekle(2);

        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.cssSelector("#tabButton"));
        Assert.assertTrue(newTab.isDisplayed());
        System.out.println("Assert 2 calisti..");

        //New Tab butonuna click yap
        bekle(2);
        newTab.click();
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);
        WebElement thisIsASamplePage = driver.findElement(By.xpath("//h1"));

        Assert.assertTrue(thisIsASamplePage.isDisplayed());
        bekle(2);
        //İlk Tab'a geri dön

        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        //New Tab butonunun görünür olduğunu doğrula
        bekle(2);
        driver.findElement(By.cssSelector("#tabButton")); // StaleElementReferenceException' dan dolayi tekrar locate ettik
        Assert.assertTrue(newTab.isDisplayed());
        System.out.println("Assert 2 calisti..");
    }
}
