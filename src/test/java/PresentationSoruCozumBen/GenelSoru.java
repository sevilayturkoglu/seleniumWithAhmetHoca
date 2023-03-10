package PresentationSoruCozumBen;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class GenelSoru extends TestBase {
    @Test
    public void test1(){
      /*  1."http://webdriveruniversity.com/" adresine gidin
        2."Login Portal" a kadar asagi inin
        3."Login Portal" a tiklayin
        4.Diger window'a gecin
        5."username" ve "password" kutularina deger yazdirin
        6."login" butonuna basin
        7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        8.Ok diyerek Popup'i kapatin
        9.Ilk sayfaya geri donun
        10.Ilk sayfaya donuldugunu test edin*/

        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String windowHandle1= driver.getWindowHandle();
        String ilkSayfatitle=driver.getTitle();
        System.out.println(windowHandle1+"***");
        //2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//h1[.='LOGIN PORTAL']")));
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[.='LOGIN PORTAL']")).click();
        //4.Diger window'a gecin
        String window2="";
        for (String handle : driver.getWindowHandles()) {
            if(!handle.equals(windowHandle1)){
                window2=handle;

            }
        }
        driver.switchTo().window(window2);
        System.out.println(window2);

        //5."username" ve "password" kutularina deger yazdirin
        driver.findElement(By.id("text")).sendKeys("hello");
        driver.findElement(By.id("password")).sendKeys("1234");
        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualalertText = driver.switchTo().alert().getText();
        String expectedAlertText="validation failed";
        Assert.assertEquals(expectedAlertText,actualalertText);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(windowHandle1);
        //10.Ilk sayfaya donuldugunu test edin
        String actualTitle=driver.getTitle();
        Assert.assertEquals(ilkSayfatitle,actualTitle);
        ReusableMethods.tumSayfaScreenshot(driver);
    }
}
