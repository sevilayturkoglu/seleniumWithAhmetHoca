package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class C06_DriverManageMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.drver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        System.out.println("maximize size= "+driver.manage().window().getSize());
        System.out.println("Maximizeget position"+driver.manage().window().getPosition());

        driver.manage().window().fullscreen();
        System.out.println("full size= "+driver.manage().window().getSize());
        System.out.println("Fullget position"+driver.manage().window().getPosition());


    }
}
