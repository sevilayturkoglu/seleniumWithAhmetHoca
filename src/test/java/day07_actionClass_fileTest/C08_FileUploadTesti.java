package day07_actionClass_fileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_FileUploadTesti extends TestBase {
    @Test
    public void test(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim
       String dinamikDosyaYolu=System.getProperty("user.home")+"\\Downloads\\logo.png";//gonderdigimiz dosyayi downloadsa indirmistik,oradan aldik
        //"C:\Users\sevil\Downloads\logo.png" ilk bolumu dinamic yaptik
      //  String dinamikDosyaYolu="C:\\Users\\sevil\\Desktop\\Deneme1";
        //driver.findElement(B)
        //3.Yuklemek istediginiz dosyayi secelim.
        WebElement choose= driver.findElement(By.id("file-upload"));
        //choose.sendKeys(dinamikDosyaYolu);
        choose.sendKeys(dinamikDosyaYolu);
        //4.Upload butonuna basalim.
       driver.findElement(By.id("file-submit")).click();

       //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUpLoad= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUpLoad.isDisplayed());

        /*String dosyaYolu="C:\\Users\\sevil\\Downloads\\TheDelta.docx";

       WebElement choose= driver.findElement(By.id("file-upload"));
       choose.sendKeys(dosyaYolu);
       driver.findElement(By.id("file-submit")).click();
       String actualText= driver.findElement(By.tagName("h3")).getText();
       String expectedText="File Uploaded!";
       Assert.assertEquals(expectedText,actualText);*/



       /* String text="C:\\Users\\sevil\\IdeaProjects\\seleniumTeam108\\src\\test\\java\\day07_actionClass_fileTest\\text.txt";
        WebElement choose= driver.findElement(By.id("file-upload"));
        choose.sendKeys(text);
        driver.findElement(By.id("file-submit")).click();
        String actualText= driver.findElement(By.tagName("h3")).getText();
        String expectedText="File Uploaded!";
        Assert.assertEquals(expectedText,actualText);*/
    }
}
