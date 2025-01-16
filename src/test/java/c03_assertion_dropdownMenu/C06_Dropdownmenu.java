package c03_assertion_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.ArrayList;
import java.util.List;

public class C06_Dropdownmenu extends TestBaseEach {


    @Test
    public void test01() {

        // ● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        // 1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

        // 1. adim : dropdown menuyu locate edip, bir webelement olarak class'da kaydedelim
        WebElement gunDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));

        // 2. adim : bir select objesi olusturun ve parametre olarak
        // kullanmak istediginiz dropdown menuyu girin
        Select selectGun = new Select(gunDdm);

        //  3. adim : olusturdugumuz selectGun objesi sayesinde Select class'indaki
        //  hazir method'lar ile istenen islemleri yapabiliriz
        selectGun.selectByIndex(5);

        // 2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement ayDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDdm);
        selectAy.selectByValue("nisan");

        // 3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDdm);
        selectYil.selectByVisibleText("1990");

        // 4. Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

        // 5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayDdmElementleriList = selectAy.getOptions();

        for (WebElement eachElement : ayDdmElementleriList) {
            System.out.println(eachElement.getText());

        }

        // Ay dropdown menusunde "Ocak" degerinin bulundugunu test edin
        // 1. adim: dropdown uzerinden olusturdugumuz selectAy.getText()
        //  menudeki tum ay isimlerini getirir

        String expectedAyIcerik = "Ocak";
        String actualAyIcerik = ayDdm.getText();
        System.out.println("actualAyIcerik :" + actualAyIcerik);
        Assertions.assertTrue(actualAyIcerik.contains(expectedAyIcerik));

        // 2. yontem : tum opsiyonlarin yazilarini olusturdugumuz String bir listeye ekleyebiliriz
        List<String> tumListeStr = new ArrayList<>();

        for (WebElement eacBaslik : ayDdmElementleriList) {

            tumListeStr.add(eacBaslik.getText());
        }

        String expectedBaslikIsmi = "Ocak";

        System.out.println(tumListeStr.contains(expectedBaslikIsmi));


        // 3. yontem: ReusableMethods class'indaki method'u kullanalim
        // Assertions.assertTrue(ReusableMethods.stringListeyeDonustur(ayDdmElementleriList).contains(expectedBaslikIsmi)); tek satirda cozum
        List<String> ayDropdownMenuMetinleri = ReusableMethods.stringListeyeDonustur(ayDdmElementleriList);
        Assertions.assertTrue(ayDropdownMenuMetinleri.contains("Ocak"));

        // 6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expetedDropdownBoyutu = 13;
        int actualDropdownBoyutu = ayDdmElementleriList.size();


        Assertions.assertEquals(expetedDropdownBoyutu, actualDropdownBoyutu);

        ReusableMethods.bekle(2);


    }


}
