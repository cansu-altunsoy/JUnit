package c02_jUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07_JUnitAssertion {


    static WebDriver driver;

    @BeforeAll
    static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    static void teardown(){
        driver.quit();
    }


    @Test
    public  void test01 (){ // anasayfaTesti
        // 1- method testotomasyonu ana sayfaya gidin ve
        // url testotomasyonu icerdigini kontrol edin

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();


        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik), "Url beklendigi gibi geldi");

    }


    @Test
    public void test02() { // urunaramaTesti
        // 2- method'da fon icin arama yapin ve
        // arama sonucunca urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        List<WebElement> bulunanUrunSayisi = driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualUrunSayisi = bulunanUrunSayisi.size();

        Assertions.assertTrue(actualUrunSayisi > 0, "Urun bulundu");


    }


    @Test
    public void test03() { //ilkUrunIsimTesti

        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();

        // ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsmiElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimicerik = "phone";
        String actualIsimicerik = ilkUrunIsmiElementi.getText().toLowerCase();

        Assertions.assertTrue(actualIsimicerik.contains(expectedIsimicerik), "Urun ismi fon icermiyor");


    }
}
