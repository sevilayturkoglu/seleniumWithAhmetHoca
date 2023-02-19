package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle());

        System.out.println(driver.getPageSource());//sayfanin html codlarini yazdirir

        //sayfa kodlari "As Wise Quarter IT bootcamp" iceriyor mu
        String expectedIcerik="As Wise Quarter IT bootcamp";
        String actualIcerik=driver.getPageSource();

        if(actualIcerik.contains(expectedIcerik)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }
    }
}
