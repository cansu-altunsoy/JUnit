package c07_waits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_ExplicitWait {

    WebDriver driver;

    @Test
    public void implicitlyWaitTesti() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[.='Remove']")).click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement istGoneYaziElement = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));

        Assertions.assertTrue(istGoneYaziElement.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("(//*[@*='button'])[1]")).click();

        //5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackMesaji = driver.findElement(By.xpath("//*[.=\"It's back!\"]"));

        Assertions.assertTrue(itsBackMesaji.isDisplayed());


        ReusableMethods.bekle(3);
        driver.quit();


    }

    @Test
    public void explicityWaitTesti() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[.='Remove']")).click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //WebElement istGoneYaziElement = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));

        /*
        istGoneYaziElementi'nin gorunur olmasi icin BEKLEME(wait)'ye ihtiyac var ama explicitlyWait icin de locate'e
        ihtiyac var...

        Boylece tavuk mu yumurtadan, yumurta mi tavuktan durumu olusur

        Selenium bu donguyu cozmek icin ;
        explicitly wait'de 3 adim yerine 2 adim atmamizi saglayan bir cozum uretmistir,
        bu iki adimla locate ve bekleme islemini  bir satirda yapiyoruz

         */

        // 1. adim wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // 2. ve 3. adim : bekleme yapmadan locate etmek mumkun olmadigindan
        //                  bekleme ve locate'i tek adimda yapacagiz


        WebElement istGoneYaziElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's gone!\"]")));

        Assertions.assertTrue(istGoneYaziElement.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("(//*[@*='button'])[1]")).click();


        //5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYaziElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"It's gone!\"]")));


        ReusableMethods.bekle(1);
        driver.quit();


    }


}
