package day05_assertion_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertion {
   static WebDriver driver;
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
   @BeforeClass
           public static void setup(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.get("https://www.youtube.com");
     WebElement cookiesKabulButonu= driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse'])[2]"));

     cookiesKabulButonu.click();
   }
   @AfterClass
   public static void teardown(){
      driver.close();
   }
   @Test
   public void tese1(){
      //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
      String actualTitle= driver.getTitle();
      System.out.println(actualTitle);
      String expectedTitle="YouTube";
      Assert.assertEquals(actualTitle,expectedTitle);

   }
   @Test
   public void imageTest(){
      //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
      WebElement logoElementi= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
      Assert.assertTrue(logoElementi.isDisplayed());


      // Assert.assertTrue(logoElementi.isDisplayed());
   }
   @Test
   //    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
   public void searchBox(){

//Assert.assertTrue(driver.findElement(By.id("search")).isEnabled());
      WebElement searchBox= driver.findElement(By.xpath("//input[@id='search']"));
      Assert.assertTrue(searchBox.isEnabled());
   }@Test
   //    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
   public void wrongTitle(){



     String expectedTitle="youtube";
      String actualTitle=driver.getTitle();
      Assert.assertNotEquals(actualTitle,expectedTitle);
   }
}
