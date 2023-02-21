package Practice.day01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class alertmis {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Navigate to website https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.id("alerts")).click();

        driver.findElement(By.xpath("//input[@onclick='show_alert()']")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        driver.findElement(By.id("confirmexample")).click();
        Thread.sleep(1000);
        System.out.println(alert.getText());
        alert.dismiss();
        System.out.println(driver.findElement(By.id("confirmreturn")).getText());

       driver.findElement(By.id("promptexample")).click();
        Thread.sleep(1000);
        System.out.println(alert.getText());
        alert.sendKeys("Selam");
        alert.accept();
        System.out.println(driver.findElement(By.id("promptreturn")).getText());
    }
}