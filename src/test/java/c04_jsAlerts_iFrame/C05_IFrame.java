package c04_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class C05_IFrame extends TestBaseEach {


    @Test
    public void test01() {

        // 1)http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/ ");

        //2)Cookies kabul edin

        //3) sayfadaki iframe sayısını bulunuz.

        List<WebElement> iframeListesi = driver.findElements(By.tagName("iframe"));

        System.out.println("Sayfada ki iframe sayisi :" + iframeListesi.size());


        //4) ilk iframe'deki (Youtube) play butonuna tıklayınız.

        driver.switchTo().frame(iframeListesi.get(0));

        WebElement playTusu = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        playTusu.click();

        driver.switchTo().defaultContent();

        //5) ilk iframe'den çıkıp ana sayfaya dönünüz
        //6) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız

        driver.switchTo().frame(iframeListesi.get(1));

        driver.findElement(By.tagName("a")).click();


        ReusableMethods.bekle(2);

    }


}
