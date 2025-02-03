package c06_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_dosyaYolunuDinamikYapma {

    @Test
    public void test01() {


        String downloadDeneme = "\\Users\\Cansu\\Downloads\\deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(downloadDeneme)));


        String dinamikAnaDosyaYolu = System.getProperty("user.home");
        System.out.println(dinamikAnaDosyaYolu);


        /*
        Eger dosya yolunu normal olarak yazarsak  \Users\Cansu\Downloads\deneme.txt sadece dosya yolunu olusturan kişinin
        pc de calışır, başka pc de calışmaz, Java ortak calisabilmemiz icin
         her pc de farkli olan bastaki kismi alabilecegimiz bir kod hazirlamistir

         Herkeste farkli olan kisi: \Users\Cansu
        Herkeste ortak olan kisim : \Downloads\deneme.txt

         */


        String dinamikDownloads = System.getProperty("user.home") + "/Downloads/deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDownloads)));


        String downloadsDeneme = "\\Users\\Cansu\\Downloads\\deneme.txt";

        Assertions.assertTrue(Files.exists(Paths.get(downloadsDeneme)));


        //  Herkeste farkli olan kisim:  C:\Users\Cansu\IdeaProjects\Team_JUnit
        //  Herkeste ayni olan kisim :  \src\test\java\day09\deneme.txt==> Abslout degeri

        System.out.println(System.getProperty("user.dir"));

        String dinamikPojeDosyaYolu = System.getProperty("user.dir");

        dinamikAnaDosyaYolu = dinamikPojeDosyaYolu + "\\src\\test\\java\\day09_actionsClass_fileTestleri\\deneme.txt";


        Assertions.assertTrue(Files.exists(Paths.get(dinamikAnaDosyaYolu)));


    }
}
