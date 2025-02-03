package C06_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C08_FileUpload extends TestBaseEach {

    @Test
    public void test01() {

        //1.https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload ");

        //2.chooseFile butonuna basalim
        //3.Yuklemek istediginiz dosyayi secelim.

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        /*

        WebDriver ile bilgisayarimizdaki fiziki dosya yapisina mudahale edemeyecegimiz icin
        Selenium bize sendKeys(dosyaYolu) Yapma firsati verir

         */

        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\deneme.txt";
        chooseFile.sendKeys(dinamikDosyaYolu);
        ReusableMethods.bekle(2);

        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();


        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileYazielementi = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(fileYazielementi.isDisplayed());

        ReusableMethods.bekle(2);


    }
}
