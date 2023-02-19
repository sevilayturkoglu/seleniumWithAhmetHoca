package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //Amazon ana sayfaya git
        driver.get("https://www.amazon.com");

        //wisequarter sayfaya git
        driver.get("https://www.wisequarter.com");

        //yeniden amazona geri gel
        driver.navigate().back();

        // wisequartera geri don
        driver.navigate().forward();

        //navigate to ,driver.get()ile ayni islemi yapar
        driver.navigate().to("https://www.youtube.com");

        driver.navigate().refresh();

        Thread.sleep(3000);
        driver.close();
    }
}
