package C06_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_FormDoldurma extends TestBaseEach {

    @Test
    public void test01() {

        // 1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up ']")).click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstNameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.click(firstNameKutusu)
                .sendKeys("Cansu")
                .sendKeys(Keys.TAB)
                .sendKeys("Altinsoy")
                .sendKeys(Keys.TAB)
                .sendKeys("cansu@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        // ve Sign Up butonuna basalim
        driver.findElement(By.id("btn-submit-form")).click();

        //5- Kaydin olusturuldugunu test edin
        // Kayit yapinca bizi otomatik olarak giris sayfasına yonlendiriyor
        //kaydın olustugunu test edebilmek icin giris yapalim

        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        WebElement submitKutusu = driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys("cansu@gmail.com");
        passwordKutusu.sendKeys("12345");
        submitKutusu.click();


        WebElement logoutButtonu = driver.findElement(By.xpath("//span[.='Logout']"));
        Assertions.assertTrue(logoutButtonu.isDisplayed());

        ReusableMethods.bekle(3);


    }
}
