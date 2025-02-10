package c09_excel_getScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenshotTumSayfa extends TestBaseEach {

    @Test
    public void test01() throws IOException {


        // testotomasyonu sayfasina gidin
        driver.get("https:/www.testotomasyonu.com");

        // phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        // arama sonucunda urun bulunabildigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucu = "0 Products Found";
        String actualsAramaSonucu = sonucYaziElementi.getText();

        Assertions.assertNotEquals(unExpectedSonucu, actualsAramaSonucu);

        ReusableMethods.bekle(1);

        // tum sayfanin screenshot alin

        // 1. adim tss objesini olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/tumSayfaSecreenshot.jpg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        FileUtils.copyFile(geciciDosya, asilResim);


        ReusableMethods.bekle(2);


    }
}
