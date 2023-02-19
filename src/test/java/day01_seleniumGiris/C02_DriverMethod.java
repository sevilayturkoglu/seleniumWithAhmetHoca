package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");//copy path ile content rooth yap dosya yolunu buraya ikinci kisma ekle
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.wisequarter.com");
        Thread.sleep(3000);
        driver.close();
    }
}
