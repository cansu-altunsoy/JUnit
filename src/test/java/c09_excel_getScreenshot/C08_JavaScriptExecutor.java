package c09_excel_getScreenshot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C08_JavaScriptExecutor extends TestBaseEach {


    @Test
    public void test01() {

        driver.get("https://testotomasyonu.com/form");

        // isitme kaybi checkbox gorunecek kadar asagi inin
        //1. adim jse obj olusturma

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // 2. adim kullanmak istedigimiz Webelementi locate edip kaydedin

        WebElement isitmeKybiCheckBox = driver.findElement(By.id("hastalikCheck5"));
        // 3. adim jse.executeScript() ile istenen islemi yapin

        //jse.executeScript("arguments[0].scrollIntoView(true)",isitmeKybiCheckBox); ====> webelemnenti gosterir ama tam ortalamaz

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", isitmeKybiCheckBox);

        // jse kullanarak isitme Kaybi checkbox'iişaretleyin
        jse.executeScript("arguments[0].click();", isitmeKybiCheckBox);

        ReusableMethods.bekle(1);

        jse.executeScript("alert('JUnit Bittiii');");

        ReusableMethods.bekle(3);


    }


}
