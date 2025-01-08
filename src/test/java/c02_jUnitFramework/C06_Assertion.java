package c02_jUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_Assertion {
    /*

    Bu gorev icin her test method'undan sonra kapatmak mantikli degil
    bunun yerine class calismaya basladiginda hic bir method calismadan once driver'i olusturmak
     ve tum method'lari calisip bittikten sonra kapatmak daha mantikli

       @BeforeAll ve  @AfterAll

     */
    //===============================================================================================================


    /*
    JUnit bir method'unun PASSED veya FAILED olmasina kodlarin calisip bitip bitmemesine gore karar verir

    Biz if-else ile test yaparsak if else FAILED yazdirsa bile kodlar problem olmadan calismaya devam ettigi icin
    method'un sonunda JUnit test PASSED olarak algilar ve yesil tik koyar

    Ozellikle toplu test calistirmalarda konsolu inceleyip
    bir cok yazi arasindan Test PASSED veya Test FAILED sonucunu aramak
    ve kac testin failed oldugunu hesaplamak neredeyde imkansizdir.


    Eger if ile test yapiyorsak ve failed oldugunda Junit'inde bunu algilamasini istiyorsak
       throw keyword'u ile kontrollu olarak exception olusturabiliriz

     */


    // farkli test method'u olusturarak asagidaki testleri gerceklerstirin
    static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }


    @Test
    public void test01() { // anasayfaTesti
        // 1- method testotomasyonu ana sayfaya gidin ve
        // url testotomasyonu icerdigini kontrol edin

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Faıled");
            throw new RuntimeException("url birbirinden farkli");
        }

    }


    @Test
    public void test02() { // urunaramaTesti
        // 2- method'da fon icin arama yapin ve
        // arama sonucunca urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        List<WebElement> bulunanUrunSayisi = driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualUrunSayisi = bulunanUrunSayisi.size();

        if (actualUrunSayisi > 0) {
            System.out.println("Urun bulma testi PASSED");
        } else {
            System.out.println("Urun bulma testi FAILED");
            throw new RuntimeException("Urun bulunamadi");
        }

    }


    @Test
    public void test03() { //ilkUrunIsimTesti

        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();

        // ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsmiElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimicerik = "phone";
        String actualIsimicerik = ilkUrunIsmiElementi.getText().toLowerCase();

        if (actualIsimicerik.contains(expectedIsimicerik)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
            throw new RuntimeException("Ilk urun ismi expected kelimeyi icermiyor");
        }


    }
}
