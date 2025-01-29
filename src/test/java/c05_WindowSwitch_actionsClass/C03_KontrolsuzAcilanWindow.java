package c05_WindowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C03_KontrolsuzAcilanWindow extends TestBaseEach {


    @Test
    public void test01() {


        driver.get("https://the-internet.herokuapp.com/windows");

        String ilkWindowWhd = driver.getWindowHandle();


        // sayfadaki elemental selenium linkini tiklayin
        WebElement seleniumLink = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        seleniumLink.click();


        // acilan yeni window'a gecip
        String ikinciwindowWhd = "";
        Set<String> acikTumWhd = driver.getWindowHandles();

        for (String eac : acikTumWhd) {

            if (!eac.equals(ilkWindowWhd)) {
                ikinciwindowWhd = eac;
            }
        }

        driver.switchTo().window(ikinciwindowWhd);


        // buyuk basligin "Elemental Selenium" oldugunu test edin

        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi, actualYazi);

        ReusableMethods.bekle(2);


    }
}
