package c01_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_GoogleTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.google.com/ adresine gidin
        driver.get(" https://www.google.com/ ");

        //3- cookies uyarisini kabul ederek kapatin
        //driver.findElement(By.xpath("//div[.='Accept all']")).click();

        ReusableMethods.bekle(1);

        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed");
        }


        //5- Arama cubuguna “Nutella” yazip aratin

        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@name='q']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


        //6- Sayfayi kapatin
        ReusableMethods.bekle(5);
        driver.quit();


    }
}
