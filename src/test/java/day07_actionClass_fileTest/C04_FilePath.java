package day07_actionClass_fileTest;

import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilePath {
    @Test
    public void test(){
       //"C:\Users\sevil\Desktop\dene"
       String dosya="C:\\Users\\sevil\\Desktop\\dene";
       boolean sonuc= Files.exists(Paths.get(dosya));
        System.out.println(sonuc);
        System.out.println(System.getProperty("user.home"));//ana dosya yolunu almak icin yapilir  C:\Users\sevil

        dosya=System.getProperty("user.home")+"\\Desktop\\dene";
        System.out.println(dosya);//C:\Users\sevil\Desktop\dene

        //C:\Users\sevil\IdeaProjects\seleniumTeam108\src\test\java\day07_actionClass_fileTest\text.txt //projede olusturdugumuz dosya yolu

        System.out.println(System.getProperty("user.dir"));//C:\Users\sevil\IdeaProjects\seleniumTeam108

    }
}
