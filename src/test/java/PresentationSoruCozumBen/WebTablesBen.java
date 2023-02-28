package PresentationSoruCozumBen;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class WebTablesBen extends TestBase {
    @Test
    public void test() {
        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //3.Web table tum body’sini yazdirin
        //   WebElement tumBody= driver.findElement(By.xpath("//tbody"));
       /* List<WebElement> elements = driver.findElements(By.xpath("//tbody"));
        for (WebElement each:elements
             ) {
            System.out.println(each.getText());
        }
*/
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));

        Assert.assertEquals(10, satirlarListesi.size());

        //5.Tum satirlari yazdirin
        //6. Web table’daki sutun sayisinin 14 olduğunu test edin
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        Assert.assertEquals(14, sutunSayisi.size());

        //7. 5.sutunu yazdirin
        System.out.println("==========5.Sutun=================");
        sutunSayisi = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement each : sutunSayisi
        ) {
            System.out.println(each.getText());

        }
        //Row 3 tumunu yazdir
        System.out.println("===========3.Rowlar=================");
        List<WebElement> ucRow= driver.findElements(By.xpath("//tbody/tr[3]"));
        for (WebElement each3:ucRow
        ) {
            System.out.println(each3.getText());
        }


        System.out.println("*******************************");
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
//methodu kullanarak 3.satir 7.sutunu yazdir
        System.out.println(Element(3, 7).getText());




    }

    public WebElement Element(int satir, int sutun) {

        String str="//tbody/tr["+satir +"]/td["+sutun+"]";
        WebElement don= driver.findElement(By.xpath(str));
        return don;
    }





}
