package c03_assertion_dropdownMenu;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseEach;

public class C08_DropdownMenu extends TestBaseEach {


    @Test
    public void test(){

        // 1. http://zero.webappsecurity.com/
        // Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@class='icon-signin']")).click();

        // 3. Login kutusuna “username” yazin
        WebElement loginKutusu = driver.findElement(By.id("user_login"));
        loginKutusu.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        WebElement passwordKutusu = driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");

        // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun,
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        driver.navigate().back();

        // 6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[.='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dDm = driver.findElement(By.id("pc_currency"));
        Select select = new Select(dDm);

        select.selectByValue("EUR");

        // 9. “amount” kutusuna bir sayi girin
        // 10. “US Dollars” in secilmedigini test edin
        // 11. “Selected currency” butonunu secin
        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.
        //Selenium Team14
    }
}
