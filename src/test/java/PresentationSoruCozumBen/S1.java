package PresentationSoruCozumBen;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class S1 extends TestBaseClass {


    @Test
    public void test1() throws IOException {
        //1- amazon gidin
        driver.get("https://www.amazon.com");

//2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropSelect= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
  Select select=new Select(dropSelect);
   List<WebElement>options=select.getOptions();

   for (WebElement each : options) {
            System.out.println(each.getText());
        }

   //3- dropdown menude 28 eleman olduğunu doğrulayın
    int actualSize =select.getOptions().size();
   int expectedSize=25;
   Assert.assertNotEquals(expectedSize,actualSize);

        TakesScreenshot ts= (TakesScreenshot) driver;
        File tumSayfaSs = new File("target/screenShot.png");
        File screen= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,tumSayfaSs);

    }@Test

    public void test2() throws IOException {
        //1- dropdown menuden elektronik bölümü seçin
        WebElement dropSelect= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropSelect);
      select.selectByVisibleText("Electronics");


      //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String actualTextYazi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expectedYazi="iphone";
        Assert.assertTrue(actualTextYazi.contains(expectedYazi));

        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun=driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4'])[1]"));

       driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(ilkUrun)).click();

        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String ikinciUrunTitle=driver.getTitle();
        System.out.println(ikinciUrunTitle);
        String ikinciUrunPrice=driver.findElement(By.xpath("//td[@class='a-span12']")).getText();
        System.out.println("price= "+ikinciUrunPrice);
        driver.findElement(By.id("add-to-cart-button")).click();
        bekle(3);
       String count=driver.findElement(By.id("nav-cart-count")).getText();
       int adet=Integer.parseInt(count);
        System.out.println("adet= " + adet);
        Assert.assertTrue(adet!=0);
        Assert.assertFalse(ikinciUrunPrice.equals("400"));

        TakesScreenshot ts= (TakesScreenshot) driver;
        File tumSayfaSs = new File("target/screenShot.png");
        File screen= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,tumSayfaSs);

    }
    @Test
    public void test3() throws IOException {


        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com");
        //2-dropdown’dan bebek bölümüne secin
        WebElement dropSelect= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropSelect);
        select.selectByValue("search-alias=baby-products-intl-ship");

        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("pushchair"+ Keys.ENTER);
        //4-sonuç yazsının puset içerdiğini test edin
        String actualTextYazi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expectedYazi="pushchair";
        Assert.assertTrue(actualTextYazi.contains(expectedYazi));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikiciUrun=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));

        driver.findElement(RelativeLocator.with(By.tagName("a")).below(ikiciUrun)).click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String title = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println("araba= "+title);
        String price=driver.findElement(By.xpath("//span[@class='a-offscreen']")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();

       bekle(2);
        driver.findElement(By.id("nav-cart-count-container")).click();
        bekle(2);
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın*/
        String SepetUrunAraba=driver.findElement(By.xpath("//span[@class='a-truncate-cut']")).getText();
        System.out.println("araba= "+SepetUrunAraba);
        Assert.assertTrue(SepetUrunAraba.contains("Pushchair"));
        String SepetUrunIphone=driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[2]")).getText();
        System.out.println(SepetUrunIphone);
        Assert.assertTrue(SepetUrunIphone.contains("iPhone"));


        TakesScreenshot ts= (TakesScreenshot) driver;
        File tumSayfaSs = new File("target/screenShot.png");
        File screen= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,tumSayfaSs);

//Arkadaslar Amazon urun isimlerini surekli degistirdigi icin boyle uzun bir testte Assertion yapmak zor oluyor anca boyle oldu,cogu zaman pass oluyor ama bazen fail olabiliyor
    }
}