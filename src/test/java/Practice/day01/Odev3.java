package Practice.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Navigate to website https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        //    Under the ORIGINAL CONTENTS
        //    click on Alerts
        driver.findElement(By.id("alerts")).click();
        //    print the URL
        System.out.println(driver.getCurrentUrl());
        //    navigate back
        Thread.sleep(1000);
        driver.navigate().back();
        //    print the URL
        System.out.println(driver.getCurrentUrl());
        //    Click on Basic Ajax
        driver.findElement(By.id("basicajax")).click();
        //    print the URL
        System.out.println(driver.getCurrentUrl());
        //    enter value 20 and ENTER
        driver.findElement(By.id("lteq30")).sendKeys("20"+ Keys.ENTER);
        //    and then verify Submitted Values is displayed open page
        driver.findElement(By.xpath("//p[.='Submitted Values']")).isDisplayed();
        System.out.println(driver.findElement(By.xpath("//p[.='Submitted Values']")).getText());
        //    close driver
        driver.close();
    }
}
