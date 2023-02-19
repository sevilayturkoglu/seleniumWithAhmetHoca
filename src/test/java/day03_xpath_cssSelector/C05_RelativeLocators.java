package day03_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativeLocators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        WebElement cityBerlin= driver.findElement(By.xpath("//*[@*='pid7_thumb']"));
        WebElement cityNyork= driver.findElement(By.xpath("//*[@*='pid3_thumb']"));
        WebElement cityBoston= driver.findElement(By.xpath("//*[@*='pid6_thumb']"));
        WebElement citySailor= driver.findElement(By.xpath("//*[@*='pid11_thumb']"));
        WebElement cityLondon= driver.findElement(By.xpath("//*[@*='pid5_thumb']"));

 /*
            Selenium4 ile yeni gelen bir ozellik
            Olur da bir elementi locate edemezseniz
            2 sey ile o elementi locate edebiliriz
                1- etrafindan bir web element(sag,sol,ustunde,altinda veya yakininda)
                2- locate edemediginiz webelement'e ait bir ozellik (tag, attribute)
         */
        WebElement berlin1=driver.findElement(RelativeLocator.with(By.tagName("img")).below(cityNyork));
        System.out.println("berlin1 id : "+berlin1.getAttribute("id")); // pid7_thumb
        WebElement berlin2= driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(cityBoston));
        System.out.println("berlin2 id : "+berlin2.getAttribute("id")); // pid7_thumb
        WebElement berlin3= driver.findElement(RelativeLocator.with(By.tagName("img")).above(citySailor));
        System.out.println("berlin3 id : "+berlin3.getAttribute("id")); // pid7_thumb
    }
}
