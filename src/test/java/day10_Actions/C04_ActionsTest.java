package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsTest extends TestBase {
    @Test
    public void test01() {
        // https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        // Drag me to my target webelemenetini Drop here webelementi uzerine birakalim

        frameIndex(0); //-- > iframe gectik , cunku sayfada iframe vardi ve istedigimiz webelementler iframe icindeydi
        bekle(2);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform(); // --> Drag webelementini alip drop webelenetinin uzerine birakir

    }

    @Test
    public void test02() {
        // https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        // Drag me to my target webelemenetini Drop here webelementi uzerine birakalim

        frameIndex(0); //-- > iframe gectik , cunku sayfada iframe vardi ve istedigimiz webelementler iframe icindeydi
        bekle(2);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        bekle(2);
        actions.clickAndHold(drag).          // Drag webelemetini tut ve bekle
                moveToElement(drop).        // Drag webelemntini drop webelentinin uzerine goturur
                release().                  // basili tuttugumuz webelementi serbest birakir
                perform();
    }

    @Test
    public void test03() {

        // https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        // Drag me to my target webelemenetini Drop here webelementi uzerine birakalim

        frameIndex(0); //-- > iframe gectik , cunku sayfada iframe vardi ve istedigimiz webelementler iframe icindeydi
        bekle(2);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
       // WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        bekle(2);
        actions.clickAndHold(drag).moveByOffset(160,25).release().perform();

        // Drag webelementinin drop webelementinin uzerine birakildigini test ediniz
        WebElement droppedText = driver.findElement(By.xpath("//*[.='Dropped!']"));
        Assert.assertTrue(droppedText.isDisplayed());
    }
}
