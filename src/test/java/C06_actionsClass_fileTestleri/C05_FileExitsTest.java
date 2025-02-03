package C06_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExitsTest {

    @Test
    public void test01() {

        // day09 package'i altında  deneme dosyasinin var oldugunu test edin

        String denemeDosyasi = "src/test/java/day09_actionsClass_fileTestleri/deneme.txt";

        System.out.println(Files.exists(Paths.get(denemeDosyasi)));


        String denemeDosyasi2 = "src/test/java/day09_actionsClass_fileTestleri/deneme1.txt";
        System.out.println(Files.exists(Paths.get(denemeDosyasi2)));


        Assertions.assertTrue(Files.exists(Paths.get(denemeDosyasi)));


        Assertions.assertFalse(Files.exists(Paths.get(denemeDosyasi2)));


        // downloads klasorunde deneme.txt dosyasının var oldugunu test edin
        String downloadDeneme = "\\Users\\Cansu\\Downloads\\deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(downloadDeneme)));


    }
}
