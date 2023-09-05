package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class HomeWork3 extends TestBase {

    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidelim

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

//programming languages ddm den istediğiniz 4 seçeneği seçiniz

        WebElement languages = driver.findElement(By.cssSelector("select[name='Languages']"));
        Select selectLanguages = new Select(languages);

        selectLanguages.selectByValue("java");
        bekle(1);
        selectLanguages.selectByValue("js");
        bekle(1);
        selectLanguages.selectByValue("python");
        bekle(1);
        selectLanguages.selectByValue("ruby");
        bekle(1);


        //sadece seçili olan option'ları yani seçenekleri yazdıralim

        List<WebElement> seciliOlanLanguages = selectLanguages.getAllSelectedOptions();
        seciliOlanLanguages.stream().forEach(t -> System.out.println("Secili olanlar "+t.getText()));

        //Seçeneklerden 4 tane seçtiğimizi doğrulayalım

        Assert.assertEquals(3, seciliOlanLanguages.size());


        //Seçtiğimiz seçeneklerden ilkini yazdıralım,

        System.out.println("Secilen seceneklerden ilki : "+selectLanguages.getFirstSelectedOption().getText());

        // ilk seçeneğin Java olduğunu doğrulayalım

        String expectedResult = "Java";
        String actualResult = selectLanguages.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedResult, actualResult);
        bekle(2);

        //Seçtiğimiz seçeneklerin hepsini kaldıralim

        selectLanguages.deselectAll();
        bekle(2);

        //visibleText olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim


        selectVisibleText(languages,"Python");

        /*
        TestBase' deki method asagidadir

        public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);

    }
         */
    }


}
