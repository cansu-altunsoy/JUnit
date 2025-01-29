package c05_WindowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C02_KontrolsuzHandle extends TestBaseEach {


    @Test
    public void test01() {

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        WebElement yazielemti = driver.findElement(By.tagName("h3"));

        String expectedYazi = "Opening a new window";
        String actualYazi = yazielemti.getText();

        Assertions.assertEquals(expectedYazi, actualYazi);


        //  ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(actualTitle, expectedTitle);
        ReusableMethods.bekle(2);


        String ilkWindowWhd = driver.getWindowHandle();


        //  ● Click Here butonuna basın.

        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        ReusableMethods.bekle(2);

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        System.out.println("Click Here bastıktan sonra title : " + driver.getTitle());

        /*
          driver.getWindowHandle();
          method'u icerisinde oldugu window'un window handle degerini bize getirir ve
          biz de kaydedebiliriz

          bir window'un whd'ini kaydettikten sonra nerede olursak olalim
           driver.switchTo().window(hedefWindowunWHD); ile bu window'a gecis yapabiliriz

           Kontrolsuz window acildiginda driver beklemedigi bir durum oldugundan
           yeni window'a gecmez, window'da kalir

           yeni window'a gecemedigimiz icin, yeni window'un whd'ini de alamayiz

         */


        Set<String> tumWhdSeti = driver.getWindowHandles();
        System.out.println("Ilk window'un whd : " + ilkWindowWhd);
        System.out.println("Tum window handle degerleri seti :" + tumWhdSeti);
        String ikinciWhd = "";

        for (String eachWhd : tumWhdSeti) {
            if (!ilkWindowWhd.equals(eachWhd)) {

                ikinciWhd = eachWhd;
            }
        }

        System.out.println("İkinci Whd :" + ikinciWhd);
        driver.switchTo().window(ikinciWhd);
        System.out.println("İkinci window'un title degeri :" + driver.getTitle());


        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.

        yazielemti = driver.findElement(By.tagName("h3"));

        expectedYazi = "New Window";
        actualYazi = yazielemti.getText();

        Assertions.assertEquals(expectedYazi, actualYazi);

        //  ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin
        driver.switchTo().window(ilkWindowWhd);

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualYazi);


    }
}
