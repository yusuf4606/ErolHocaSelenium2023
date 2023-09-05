package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C01_Faker {
    @Test
    public void faker() {
        /*
        Faker class'i ile fake datalar olusturabilmek icin oncelikle maven.repository.com adresinden github-javafaker dependency alinip pom.xml e attik

        Faker class'indan bir obje olusturup isim,soyisim,sehir adress vb .. fake datalar olusturabiliriz
         */

        Faker faker = new Faker();

        // faker objesi ile fake isim yazdiralim

        System.out.println(faker.name().firstName());

        // faker objesi ile fake soyisim yazdiralim

        System.out.println(faker.name().lastName());

        // faker objesi ile fake isim-soyisim yazdiralim

        System.out.println(faker.name().fullName());

        // faker objesi ile fake sehir yazdiralim

        System.out.println(faker.address().city());

        // faker objesi ile fake fulladres yazdiralim

        System.out.println(faker.address().fullAddress());

        // faker objesi ile fake email yazdiralim

        System.out.println(faker.internet().emailAddress());

        // faker objesi ile fake rastgele 15 haneli bir number yazdiralim

        System.out.println(faker.number().digits(15));




    }
}
