package c09_excel_getScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

import java.io.File;
import java.io.IOException;

public class C06_WebElementScreenShot extends TestBaseEach {


    @Test
    public void test01() throws IOException {

        // testotomasyonu anasayfaya gidelim
        driver.get("https://www.testotomasyonu.com");

        // Account linkine tiklayin

        driver.findElement(By.xpath("//span[.='Account']")).click();

        // Kullanici adi wise@gmail.com girin
        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys("wise@gmail.com");

        // password olarak 12345 girin
        WebElement paswordKutusu = driver.findElement(By.id("password"));
        paswordKutusu.sendKeys("12345");

        // sing in butonuna basarak sisteme giris yapin
        driver.findElement(By.id("submitlogin"))
                .click();


        // giris yapilabildigini test etmek icin
        // Logout butonunun gorunur oldugunu test edin
        WebElement logoutButton = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButton.isDisplayed());


        // Logout butonunun fotografini cekin

        // 1. adim screenshot alacagimiz webelementi locate edip kaydedelim
        // biz yukarda Logout butonunu locate ettik

        // 2. adim resmi kaydedecegimiz File'i olusturalim

        File asilResim = new File("target/screenshots/webElementSecreenshot.jpeg");


        // 3. screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = logoutButton.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı asil dosyaya kaydedelim

        FileUtils.copyFile(geciciDosya, asilResim);


        //logput butonuna basarak sistemden cıkıs yapin

        logoutButton.click();


    }

}
