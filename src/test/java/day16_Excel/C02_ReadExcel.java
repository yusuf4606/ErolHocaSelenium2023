package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel extends TestBase {
    @Test
    public void test01() throws IOException {
        //BlurentalCar sitesine gidelim
        driver.get("https://www.bluerentalcars.com/");

        //Login butonuna basalim
        driver.findElement(By.xpath("(//a)[1]")).click();
        bekle(2);
        //Excel dosyasındaki herhangi bir kullanıcı ile login olalim
        FileInputStream fis = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String userName = workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String password = workbook.getSheet("customer_info").getRow(1).getCell(1).toString();

        WebElement email = driver.findElement(By.cssSelector("#formBasicEmail"));
        email.sendKeys(userName, Keys.TAB, password, Keys.ENTER);

        //Login olduğumuzu doğrulayalım
        WebElement loginName = driver.findElement(By.xpath("//*[@id='dropdown-basic-button']"));
        loginName.click();
        bekle(2);

        WebElement profile = driver.findElement(By.xpath("//*[.='Profile']"));
        profile.click();

        WebElement emailText = driver.findElement(By.xpath("//em"));
        Assert.assertEquals(userName,emailText.getText());
    }
}
