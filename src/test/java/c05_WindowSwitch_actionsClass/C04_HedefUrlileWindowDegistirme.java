package c05_WindowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C04_HedefUrlileWindowDegistirme extends TestBaseEach {


    @Test
    public void test01() {

        driver.get("https://the-internet.herokuapp.com/windows");

        String ilkWindowWhd = driver.getWindowHandle();

        // sayfadaki elemental selenium linkini tiklayin
        WebElement seleniumLink = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        seleniumLink.click();


        // acilan yeni window'a gecip
        String hedefUrl = "https://elementalselenium.com/";

        Set<String> tumWindowWhdseti = driver.getWindowHandles();
        /*
        Bir for-each loop ile tum whd'lerini gozden gecirip, her windowhandle
         degerinin sayfasina gecelim. Eger gectigimiz sayfada url hedefUrl'e esit ise loop'u bitirelim
         */

        for (String each : tumWindowWhdseti) {

            driver.switchTo().window(each);

            if (driver.getCurrentUrl().equals(hedefUrl)) {
                break;
            }
        }

        // buyuk basligin "Elemental Selenium" oldugunu test edin
        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi, actualYazi);

        ReusableMethods.bekle(2);


    }
}
