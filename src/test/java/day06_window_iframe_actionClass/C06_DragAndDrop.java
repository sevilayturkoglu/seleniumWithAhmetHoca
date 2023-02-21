package day06_window_iframe_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_DragAndDrop extends TestBase {
    @Test
    public void test(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropAble=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMe,dropAble).perform();
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualYazi=driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        String expectedYazi="Dropped!";
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
