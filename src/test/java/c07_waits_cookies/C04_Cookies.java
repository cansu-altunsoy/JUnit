package c07_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C04_Cookies extends TestBaseEach {


    @Test
    public void test01() {

        // Google'a gidelim
        driver.get("https://www.google.com");


        // cookies cıkarsa kabul edelim
        // driver.findElement(By.xpath("//div[.='Accept all']")).click();


        //sayfada kac adet cookies bulundugunu yazdirin
        Set<Cookie> tumCookiesSeti = driver.manage().getCookies();
        System.out.println("SAtfada ki cookies sayısı : " + tumCookiesSeti.size());


        // tum cookies'leri yazdirin
        System.out.println(tumCookiesSeti);

        // daha derli toplu yazdiralim

        int siraNo = 1;

        for (Cookie eachCookies : tumCookiesSeti) {

            System.out.println(siraNo + " .cookies" + eachCookies);
            siraNo++;

        }


        // cookies'lerin isimlerini yazdirin
        siraNo = 1;

        for (Cookie eachCookie : tumCookiesSeti) {

            System.out.println(siraNo + " .cookie ismi :" + eachCookie.getName());
            siraNo++;

        }


        // ismi :NID olan cookie'nin degerinin 24 oldugunu test edin
        String expectedIsim = "NID";
        String actualIsim = driver.manage().getCookieNamed("NID").getName();

        Assertions.assertEquals(expectedIsim, actualIsim);


        // ismi enSevdigimCookie, degeri cikolataliCookie olan bir cookie olusturup
        // sayfaya ekleyin

        Cookie cookie = new Cookie("enSevdigimCookie", "cikolataliCookie");
        driver.manage().addCookie(cookie);


        System.out.println("=====================");
        // tum cookies'leri yazdirin

        tumCookiesSeti = driver.manage().getCookies();
        siraNo = 1;

        for (Cookie eachCookie : tumCookiesSeti) {

            System.out.println(siraNo + " .cookie ismi :" + eachCookie.getName());
            siraNo++;

        }


        // cookie'yi ekleyebildigimizi test edin

        Assertions.assertTrue(tumCookiesSeti.contains(cookie));


        // ismi  OGPC olan cookie'yi silin
        driver.manage().getCookieNamed("OGPC");


        tumCookiesSeti = driver.manage().getCookies();
        siraNo = 1;

        for (Cookie eachCookie : tumCookiesSeti) {

            System.out.println(siraNo + " .cookie ismi :" + eachCookie.getName());
            siraNo++;

        }


        // ve silindigini test edin
        boolean socsVarMi = false;

        for (Cookie eacOgpc : tumCookiesSeti) {

            if (eacOgpc.getName().equals("OGPC")) {
                socsVarMi = true;

            }
        }

        // tum cookie'lerin isimlerini kontrol ettik
        // varsa sonuc True olacak

        Assertions.assertTrue(socsVarMi);


        // tum cookie'leri silin
        driver.manage().deleteAllCookies();

        // silindigini test edin
        tumCookiesSeti = driver.manage().getCookies();

        Assertions.assertEquals(0, tumCookiesSeti.size());


        ReusableMethods.bekle(2);


    }
}
