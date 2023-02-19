package day02_WebElements_Locators;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverManageMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chromre.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        System.out.println(driver.manage().window().getSize());
        System.out.println(driver.manage().window().getPosition());
        //olculeri degistirelim
        driver.manage().window().setSize(new Dimension(500,500));
        driver.manage().window().setPosition(new Point(40,100));
        //yeni sizeleri yazdiralim
        System.out.println(driver.manage().window().getSize());
        System.out.println(driver.manage().window().getPosition());
    }
}
