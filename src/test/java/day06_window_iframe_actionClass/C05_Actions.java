package day06_window_iframe_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C05_Actions extends TestBase {
    @Test
    public void test(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions sagClick=new Actions(driver);
        WebElement cizgili= driver.findElement(By.id("hot-spot"));
        sagClick.contextClick(cizgili).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlert="You selected a context menu";
       String actualAlert =driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlert,actualAlert);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWHD=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> tumWHDSeti= driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each :tumWHDSeti
                ) {
            if(!each.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=each;
            }
        }driver.switchTo().window(ikinciSayfaWHD);
        String expectedYazi="Elemental Selenium";
        String actualYazi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);

    }
}
