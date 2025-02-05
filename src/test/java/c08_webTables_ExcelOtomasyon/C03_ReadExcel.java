package c08_webTables_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        // Excel'deki bilgileri kullanabilmek icin once excel'deki datalara
        // ulasmamiz lazim, bilgisayarimizdaki dosyaya selenium WebDriver ile ulasamayacagımız icin
        // Java'dan yardım almalıyız

        // 1. adim dosya yolunu alalim
        String dosyaYolu = "src/test/java/day11_webTables_ExcelOtomasyon/ulkeler.xlsx";

        // 2. adim Java ile dosyaya erismek icin
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);


        // 3. adim excel'den alinan bilgileri
        // kodlarimizin icinde olusturacagımız bir obje olarak kaydedelim

        Workbook workbook = WorkbookFactory.create(fileInputStream);  // Artik fiziki olarak excel dosyasindaki tum bilgileri
        // kodlarimiz icerisinde olusturdugumuz workbook objesine kaydettik


        // excel'in kopyası olan worbook'da istedigimiz bilgiye ulasalim


        // Sayfa1'deki 5. satir, 3. hucrede olan bilgiyi yazdirin
        //  woorkbook da java'daki genel kabule uygun olarak index kullanir
        // index 0'dan basladigi icin
        // 5. satir icin index==> 4, 3. hucre icin index==>2 secilmelidir

        Sheet sheet1 = workbook.getSheet("sayfa1");  // exxcel'de sayfalara gittik

        Row row = sheet1.getRow(4); // satirlara erisim saglariz

        Cell cell = row.getCell(2); // sutunlara erisim saglariz


        // her seferinde row ve cell olusturmaya gerek yok
        // Sayfa1'deki 15.satir, 2.hucrede olan bilgiyi yazdirin

        System.out.println(workbook.getSheet("Sayfa1").getRow(14).getCell(1)); // Dhaka


        // son satir numarasini yazdirin
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()); // 190
        // bu son satirin index'idir

        System.out.println("Son satir no : " + (workbook.getSheet("Sayfa1").getLastRowNum() + 1));


        // Kullanilan satir sayisini yazdirin
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows()); // 191


    }
}
