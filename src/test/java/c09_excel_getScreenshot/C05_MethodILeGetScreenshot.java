package c09_excel_getScreenshot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C05_MethodILeGetScreenshot extends TestBaseEach {

    @Test
    public void test01() {


        // testotomasyonu sayfasina gidin
        driver.get("https:/www.testotomasyonu.com");

        // phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        // arama sonucunda urun bulunabildigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucu = "";
        String actualsAramaSonucu = sonucYaziElementi.getText();

        Assertions.assertNotEquals(unExpectedSonucu, actualsAramaSonucu);

        ReusableMethods.bekle(1);

        // tum sayfa screenshot alin

        ReusableMethods.tumSayfaScreenshotIsimli(driver, "aramaTesti");


        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();


        // acilan urun isminde case sensitive olmadan "phone" bulundugunu test edin
        WebElement ilkUrunIsimElenti = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualIsimIcerik = ilkUrunIsimElenti.getText().toLowerCase();

        Assertions.assertTrue(actualIsimIcerik.contains(expectedIsimIcerik));


        // sayfanin fotografını cekin
         //ReusableMethods.tumSayfaScreenshotIsimli(driver, "ilkUrunIsmi");
        ReusableMethods.tumSayfaScreenshotTarihli(driver);


        ReusableMethods.bekle(1);


    }
}
