package c04_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C06_AyniWindowGezinme extends TestBaseEach {

    @Test
    public void test01() {

        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        //window handle degeri ve url'i yazdırın
        System.out.println("Anasayfa url :" + driver.getCurrentUrl());
        System.out.println("Anasayfa handle degeri :" + driver.getWindowHandle());

        // Electronic linkine tiklayin
        driver.findElement(By.xpath("(//*[@class='has-sub'])[1]")).click();

        System.out.println("Electronic url :" + driver.getCurrentUrl());
        System.out.println("Electronic handle degeri :" + driver.getWindowHandle());

        // ilk urune tiklayin
        driver.findElement(By.xpath("(//*[@class='product-box mb-2 pb-1'])[1]")).click();


        // window handle degerini ve url'i yazdirin
        System.out.println("İlk urun url :" + driver.getCurrentUrl());
        System.out.println("İlk urun handle degeri :" + driver.getWindowHandle());


        // account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']")).click();


        // windowhandle degerini ve url'i yazdirin

        System.out.println("Account  url :" + driver.getCurrentUrl());
        System.out.println("Account handle degeri :" + driver.getWindowHandle());

        ReusableMethods.bekle(2);


    }
}
