package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ZeroTest {
   @Test
    public void test01(){
       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
     //  1. http://zero.webappsecurity.com sayfasina gidin
       driver.get("http://zero.webappsecurity.com");
     //  2. Signin buttonuna tiklayin
       driver.findElement(By.id("signin_button")).click();
     //  3. Login alanine  “username” yazdirin
       driver.findElement(By.id("user_login")).sendKeys("username");
     //  4. Password alanine “password” yazdirin
       driver.findElement(By.id("user_password")).sendKeys("password");
     //  5. Sign in buttonuna tiklayin
       driver.findElement(By.xpath("//input[@name='submit']")).click();
       //sayfa nin gittigi yerden geri gelmemiz lazim
       driver.navigate().back();
     //  6. Online Banking tikla ve Pay Bills sayfasina gidin ve tiklayin
      driver.findElement(By.xpath("//strong[.='Online Banking']")).click();
      driver.findElement(By.id("pay_bills_link")).click();
     //  7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
      driver.findElement(By.id("sp_amount")).sendKeys("200");
    // 8. tarih kismina “2020-09-10” yazdirin
      driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
      // 9. Pay buttonuna tiklayin
      driver.findElement(By.id("pay_saved_payees")).click();
     //  10. “The payment was successfully submitted.” mesajinin ciktigini test edin
      WebElement succes= driver.findElement(By.id("alert_content"));
      System.out.println(succes.isDisplayed());
      String actualMessage=succes.getText();
      System.out.println(actualMessage);
      driver.close();
   }
}
