package c05_WindowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01KontrolluWindowDegistirme extends TestBaseEach {


    @Test
    public void test01() {


        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // whd'ini kaydedin ve yazdirin
        String testOtomasyonuWhd = driver.getWindowHandle();
        System.out.println("test otomasyonu handle degeri :" + testOtomasyonuWhd);

        ReusableMethods.bekle(2);

        // yeni bir tab acip, yeni tab'da wisequarter sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");


        // whd'ini kaydedin ve yazdirin

        String wiseWhd = driver.getWindowHandle();
        System.out.println("Wise handle degeri :" + wiseWhd);

        ReusableMethods.bekle(2);

        // yeni bir window acarak, arabam.com sayfasina gidin

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.arabam.com");


        // whd'ini kaydedin ve yazdirin

        String arabamWhd = driver.getWindowHandle();
        System.out.println("Arabam handle degeri :" + arabamWhd);
        ReusableMethods.bekle(2);

        /*
        Eger bize verilen gorevde, Yeni bir Tab veya yeni bir Window acilmasi isteniyorsa
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.WINDOW);
        ile yeni bir Tab veya Window acip, driver'i yeni window'a otomatik olarak gecirebiliriz

        Eger testimiz sirasinsa birden fazla  window aciliyorsa driver'i istedigimiz  window'a
        gecirmek icin hedef window'un WindowHandle degerini girmeliyiz
         driver.switchTo().window(wiseWhd);

         Eger birden fazla window aciyorsak ve geri donmemiz gerekecekse acilan
         her window'un window handle degerini kaydetmek faydali olacaktır

         */

        // wisequarter'in acik oldugu window'a donun
        // ve url'in wisequarter icerdigini test edin
        driver.switchTo().window(wiseWhd);

        String expectedIcerik = "wisequarter";
        String actualIcerik = driver.getCurrentUrl();

        Assertions.assertTrue(actualIcerik.contains(expectedIcerik));
        ReusableMethods.bekle(2);


        // testotomasyonu'nun acik oldugu window'a donun ve
        // url'in testotomasyonu icerdigini test edin
        driver.switchTo().window(testOtomasyonuWhd);
        String expectedTestotomasyonu = "testotomasyonu";
        String actualTestotomasyonu = driver.getCurrentUrl();

        Assertions.assertTrue(actualTestotomasyonu.contains(expectedTestotomasyonu));


    }

}
