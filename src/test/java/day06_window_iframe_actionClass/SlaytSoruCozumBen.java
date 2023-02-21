package day06_window_iframe_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class SlaytSoruCozumBen extends TestBase {
    @Test
    public void test() {
    //Yeni bir class olusturalim: MouseActions3
    //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
   //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
   //mouse’u bu menunun ustune getirin
        WebElement accountList= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();

    //3- “Create a list” butonuna basin
        WebElement create= driver.findElement(By.xpath("//span[.='Create a List']"));
        actions.moveToElement(create).click(create).perform();
        //create.click();
     //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String actualMsg=driver.findElement(By.cssSelector("#my-lists-tab")).getText();
        String expectedMsg="Your Lists";
        Assert.assertEquals(expectedMsg,actualMsg);
    }
}
