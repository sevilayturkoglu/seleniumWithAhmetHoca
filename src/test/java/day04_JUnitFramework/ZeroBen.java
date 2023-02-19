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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ZeroBen {
   static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }@AfterClass
    public  static void teardown(){
        //driver.close();
    }@Test
    public  void zero(){
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
driver.findElement(By.id("signin_button")).click();
//3. Login alanine “username” yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");
        //4. Password alanine “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //6. Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//strong[.='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        Select payee=new Select(driver.findElement(By.id("sp_payee")));
        payee.selectByVisibleText("Bank of America");
        System.out.println(payee.getFirstSelectedOption().getText());
        payee=new Select(driver.findElement(By.id("sp_account")));
        payee.selectByIndex(3);
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
       driver.findElement(By.id("sp_amount")).sendKeys("200");
        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        driver.findElement(By.id("sp_description")).sendKeys("Borc Odemesi");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini test edin
      WebElement message= driver.findElement(By.xpath("//span[.='The payment was successfully submitted.']"));
        Assert.assertTrue("message is not displayed",message.isDisplayed());
    }
}
