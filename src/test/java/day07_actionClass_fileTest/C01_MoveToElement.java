package day07_actionClass_fileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_MoveToElement extends TestBase {
    @Test
    public void test(){
        //1- https://www.amazon.com/ adresine gidindr
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan "Account & Lists" menusunun acilmasi icin
        WebElement account= driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(account).perform();
        //   mouse'u bu menunun ustune getirin
        //3- "Create a list" butonuna basin
       driver.findElement(By.xpath("//span[.='Create a List']")).click();
        //4- Acilan sayfada "Your Lists" yazisi oldugunu test edin
        WebElement your= driver.findElement(By.id("my-lists-tab"));
        Assert.assertTrue(your.isDisplayed());
        bekle(2);
    }
}
