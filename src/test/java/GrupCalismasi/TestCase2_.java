package GrupCalismasi;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase2_ extends TestBase {

        @Test
        public void test1()  {
       //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");
            //3. Verify that home page is visible successfully
            String actualTitle= driver.getTitle();
            String expecTitle="Automation";
            Assert.assertTrue(actualTitle.contains(expecTitle));
            //4. Click on 'Signup / Login' button
            driver.findElement(By.xpath("//a[@href='/login']")).click();
            //5. Verify 'Login to your account' is visible
            WebElement text= driver.findElement(By.xpath("//h2[.='Login to your account']"));
            Assert.assertTrue(text.isDisplayed());
            //6. Enter correct email address and password
            Faker faker=new Faker();
            driver.findElement(By.cssSelector("input[type='email']")).sendKeys("abc123@abc1234");
            driver.findElement(By.cssSelector("input[type='password']")).sendKeys("midir");
            //7. Click 'login' button
            driver.findElement(By.cssSelector(".btn.btn-default")).click();

            //8. Verify that 'Logged in as username' is visible
            WebElement logout = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
            Assert.assertTrue(logout.isDisplayed());
            //9. Click 'Delete Account' button
            driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

            driver.findElement(By.xpath("//span[.='Close']")).click();

            //10. Verify that 'ACCOUNT DELETED!' is visible
            WebElement element= driver.findElement(By.xpath("//b[.='Account Deleted!']"));
            Assert.assertTrue(element.isDisplayed());



    }
}
