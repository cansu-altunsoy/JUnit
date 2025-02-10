package c09_excel_getScreenshot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C07_MethodileScreenshot extends TestBaseEach {

    @Test
    public void test01() {

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

        // ReusableMethods.webElementScreenshotIsimli(logoutButton,"loginButtonTesti");
        //ReusableMethods.webElementScreenshotTarihli(logoutButton);
        ReusableMethods.webElementScreenshotTarihliVeIsimliVeTarihli(logoutButton, "LoginTesti");


        //logput butonuna basarak sistemden cıkıs yapin
        logoutButton.click();


    }
}
