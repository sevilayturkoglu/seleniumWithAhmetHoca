package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SlaytSoruBen {
   static WebDriver driver;

   /* public SlaytSoruBen(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id ="login-button")
    public WebElement img1;

    @Test
    public  void sales() {
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        img1.click();


    }*/

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }@AfterClass
    public static void teardown(){
      // driver.close();
    }@Test
    public  void sales(){
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilk= driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']"));
        String urunText=ilk.getText();
        System.out.println(urunText);
        ilk.click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
       WebElement sepet= driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']"));
        String expectedSepet = "Sauce Labs Backpack";
        String actualSepet=sepet.getText();
        Assert.assertEquals("Sepet bos",actualSepet,expectedSepet);
        //9. Sayfayi kapatin

    }
}
