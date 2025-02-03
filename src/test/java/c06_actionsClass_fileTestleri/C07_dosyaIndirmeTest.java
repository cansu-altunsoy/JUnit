package c06_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBaseEach;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_dosyaIndirmeTest extends TestBaseEach {


    @Test
    public void test01() {


        // 1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");


        //2. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//*[.='download.jpeg']")).click();

        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Cansu\\Downloads\\85378a82-f7f5-4f2c-a49b-f642a9bbf161.tmp";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


    }

}
