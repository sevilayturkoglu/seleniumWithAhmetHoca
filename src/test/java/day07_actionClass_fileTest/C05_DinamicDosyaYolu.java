package day07_actionClass_fileTest;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DinamicDosyaYolu {
    @Test
    public void test(){
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\dene";
        Assert.assertTrue(Files.exists((Paths.get(dosyaYolu))));

    }
}
