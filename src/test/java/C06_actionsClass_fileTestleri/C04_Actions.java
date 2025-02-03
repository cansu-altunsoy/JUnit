package C06_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C04_Actions extends TestBaseEach {


    @Test
    public void test01() {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverKutusu = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.moveToElement(hoverKutusu).perform();
        ReusableMethods.bekle(2);

        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[.='Link 1'])[1]")).click();

        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());


        //5- Popup'i tamam diyerek kapatin
        driver.switchTo()
                .alert()
                .accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickBox = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickBox).perform();
        ReusableMethods.bekle(1);

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickBox.getText());


        //8- “Double click me" butonunu cift tiklayin
        // cift tıklandigini test edin
        WebElement doubleClick = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();

        String expectedClassAttributeDegeri = "div-double-click double";
        String actualClassAttributeDegeri = doubleClick.getAttribute("class");

        Assertions.assertEquals(expectedClassAttributeDegeri, actualClassAttributeDegeri);


        ReusableMethods.bekle(3);


    }


}
