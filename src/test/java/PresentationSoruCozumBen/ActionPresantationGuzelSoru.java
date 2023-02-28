package PresentationSoruCozumBen;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionPresantationGuzelSoru extends TestBase {
    @Test
    public void test() {
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        WebElement first= driver.findElement(By.xpath("//button[.='Hover Over Me First!']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(first).perform();
        //3- Link 1" e tiklayin
        driver.findElement(By.linkText("Link 1")).click();
        //4- Popup mesajini yazdirin
        String actualalertText = driver.switchTo().alert().getText();
        System.out.println(actualalertText);
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement ClickHold= driver.findElement(By.id("click-box"));
        actions.clickAndHold(ClickHold).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        String clickText=driver.findElement(By.id("click-box")).getText();
        System.out.println(clickText);

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick= driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClick).perform();
    }
}
