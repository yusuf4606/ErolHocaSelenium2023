package day09_BasicAuthentication_Cookies;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {

    @Test
    public void name() {
        /*
        Cookie denildiğinde aklımıza manage() methodu gelmeli. Manage() methodu ile cookielerle ilgili tüm işlemleri yaparız
        */
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

        //2-tum cookie'leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie c:cookieSet) {
            System.out.println(sayac+". cookie : "+c);
            System.out.println(sayac+". cookie Name : "+c.getName());
            System.out.println(sayac+". cookie Value : "+c.getValue());
            sayac++;
        }
        bekle(2);

        // 3- sayfadaki cookies sayisinin 5'ten buyuk oldugunu test edelim
        System.out.println("Cookieleerin sayisi = "+cookieSet.size());
        Assert.assertTrue(cookieSet.size()>5);
        bekle(2);

        //4-ismi 'i18n-prefs' olan cookie degerinin 'USD' oldugunu test edin
        String actualCoockieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD",actualCoockieValue);

        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin

                // 1. yol
                Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
                driver.manage().addCookie(cookie);
                bekle(2);
        System.out.println("----  ----   ----         ---------      -----------");
        cookieSet = driver.manage().getCookies(); //-->Ekleme yaptıktan sonra cookieSet'e tekrar tüm cookie'leri atadık
        int sayac1 = 1;
        for (Cookie c:cookieSet) {
            System.out.println(sayac1+". cookie : "+c);
            System.out.println(sayac1+". cookie Name : "+c.getName());
            System.out.println(sayac1+". cookie Value : "+c.getValue());
            sayac1++;
        }
                // 2. yol
                //  driver.manage().addCookie(new Cookie("en sevdigim cookie","cikolatali"));  // kisa yol

        //6-eklediginiz cookie'nin sayfaya eklendigini test
        Assert.assertTrue(cookieSet.contains(cookie));

        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookieSet = driver.manage().getCookies(); //-->Silme işleminden sonra cookieSet'i tekrar güncelledik

        System.out.println("******************************************");

        int sayac2 = 1;
        for (Cookie c:cookieSet) {
            System.out.println(sayac2+". cookie : "+c);
            System.out.println(sayac2+". cookie Name : "+c.getName());
            System.out.println(sayac2+". cookie Value : "+c.getValue());
            sayac2++;
        }
        Assert.assertFalse(cookieSet.contains(driver.manage().getCookieNamed("skin")));

        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());
    }
}
