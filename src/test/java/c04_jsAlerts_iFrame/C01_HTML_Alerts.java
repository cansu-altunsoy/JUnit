package c04_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBaseAll;

public class C01_HTML_Alerts extends TestBaseAll {


    @Test
    public void test01() {

        driver.get("https://www.google.com");


        // cookies onaylama yapalim
        // driver.findElement(By.xpath("//div[text()='Accept all']")).click();

        ReusableMethods.bekle(3);


    }


}
