package day01_seleniumGiris;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Amazon ana sayfaya gidin gittiginiz sayfadaki
        driver.get("https://www.amazon.com");

        // title ve url yi yazdirin
        System.out.println("title= " + driver.getTitle());
        System.out.println("url= " + driver.getCurrentUrl());

        // Amazon ana sayfaya gittignizi test edin
        if (driver.getTitle().equals("Amazon.com. Spend less. Smile more.")) {
            System.out.println("Test pass");
        } else {
            System.out.println("fail");
        }
        if (driver.getCurrentUrl().equals("https://www.amazon.com/")) {
            System.out.println("Test pass");
        } else {
            System.out.println("fail");
        }
    }
}