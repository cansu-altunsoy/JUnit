package c02_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C08_BeforeVeAfterSartMi {

    // tek test method'u olusturarak asagidaki testleri gerceklerstirin
    WebDriver driver;

    /*
    Verilen görev tek bir test method'u ile yapilacak bir gorev olsa da
    Webdriver'i olusturma ve kapatma islemini ayri bir setup() ve teardown() ile yapmayi tercih ederiz

    Eger tek bir test method'unun icinde Webdriver olusturma ve sonunda driver'i kapatma islemlerini
    yaparsak Test failed oldugunda exception olustugu icin kodun
    calismasi durur ve son satirdaki driver.quit() calismaz

    ozellikle toplu calismalarda kapanmayan browser'larin olmasi guzel olmaz

     */

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void urunTesti() {

        // 1- method testotomasyonu ana sayfaya gidin ve
        // url testotomasyonu icerdigini kontrol edin

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();


        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik), "Url beklendigi gibi geldi");

        // 2- method'da fon icin arama yapin ve
        // arama sonucunca urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        List<WebElement> bulunanUrunSayisi = driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualUrunSayisi = bulunanUrunSayisi.size();

        Assertions.assertTrue(actualUrunSayisi > 0, "Urun bulundu");

        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();

        // ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsmiElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimicerik = "phone";
        String actualIsimicerik = ilkUrunIsmiElementi.getText().toLowerCase();

        Assertions.assertTrue(actualIsimicerik.contains(expectedIsimicerik), "Urun ismi fon icermiyor");


    }
}
