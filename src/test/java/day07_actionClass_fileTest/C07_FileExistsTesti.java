package day07_actionClass_fileTest;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileExistsTesti {
    @Test
    public void test(){
        //Calistigimiz package ve profe yoluna ulasip dinamik yapalim
        String dinamikDosyaYolu=System.getProperty("user.dir")+"/src/test/java/day07_actionClass_fileTest/text.txt";//ikinci kismi content rooth ile aldik
        System.out.println(dinamikDosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
