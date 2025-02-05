package c08_webTables_ExcelOtomasyon;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class C02_KlasikOlmayanTablo extends TestBaseEach {

    @Test
    public void test01() {

        //1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElemetleriList = driver.findElements(By.xpath("//*[@role='hrow'] /div[@role='hdata']"));

        System.out.println("Başlıklar Listesi :" + ReusableMethods.stringListeyeDonustur(baslikElemetleriList));

        // 3. 3.sutunun basligini yazdirin
        System.out.println("3. sutun basligi :" + baslikElemetleriList.get(2).getText());


        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumBodyElementleriLists = driver.findElements(By.xpath("//*[@role='trow'] /div[@role='tdata']"));

        System.out.println(ReusableMethods.stringListeyeDonustur(tumBodyElementleriLists));

        // 5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tabloda ki data sayısı :" + tumBodyElementleriLists.size());


        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElemetleriList =
                driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("Tablodaki satır sayısı :" + satirElemetleriList.size());

        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tabloda ki sutun sayisi :" + baslikElemetleriList.size());


        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//*[@role='trow'] /div[@role='tdata'][3]"));

        System.out.println("Üçüncü sutun dataları :" + ReusableMethods.stringListeyeDonustur(ucuncuSutunElementleriList));


        //10. Bir method olusturun, Test methodundan satir ve sutun verildiginde datayi dondursun

        System.out.println(getHucreData(1, 1)); // DELL Core I3 11th Gen

        System.out.println(getHucreData(2, 2)); // Electronics

        System.out.println(getHucreData(3, 4)); // Go


        // 9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin

        for (int i = 1; i < satirElemetleriList.size(); i++) {

            String satirdakiCategoryDegeri = getHucreData(i, 2);
            String satirdakiUrunFiyati = getHucreData(i, 3);

            if (satirdakiCategoryDegeri.equalsIgnoreCase("Furniture")) {
                System.out.println(satirdakiUrunFiyati);
            }

        }

        ReusableMethods.bekle(2);


    }

    public String getHucreData(int satirNo, int sutunNo) {

        //     //*[@role='trow'][   2    ] /div[@role='tdata'][   2   ]

        String dinamikXpath = "//*[@role='trow'][" + satirNo + "] /div[@role='tdata'][" + sutunNo + "]";

        WebElement hedefHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        return hedefHucreElementi.getText();

    }

}