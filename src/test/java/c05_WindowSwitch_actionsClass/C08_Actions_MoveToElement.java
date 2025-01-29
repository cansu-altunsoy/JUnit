package c05_WindowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C08_Actions_MoveToElement extends TestBaseEach {


    @Test
    public void test01() {

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement kidsWearMenu = driver.findElement(By.xpath("(//li[@class='has-sub'])[7]"));

        actions.moveToElement(kidsWearMenu).perform();

        //3- “Boys” linkine basin
        WebElement boysLink = driver.findElement(By.xpath("//*[.='Boys']"));
        boysLink.click();

        //4- Acilan sayfadaki ilk urunu tiklayin
        WebElement firstProduct = driver.findElement(By.xpath("(//*[@*='product-box mb-2 pb-1'])[1]"));
        firstProduct.click();


        //4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        WebElement isimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsim = "Boys Shirt White Color";
        String actualIsim = isimElementi.getText();


        Assertions.assertEquals(actualIsim, expectedIsim);

        ReusableMethods.bekle(2);

    }
}
