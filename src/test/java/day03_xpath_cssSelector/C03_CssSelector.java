package day03_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_CssSelector {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
       // 3- Browseri tam sayfa yapin
       // 4- Sayfayi “refresh” yapin
       // 5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin

        String ecxpectedTitle="Spend less";
        String actualTitle=driver.getTitle();
        if(actualTitle.contains("Amazon.com. Spend less. Smile more.")){
            System.out.println("Pass");
        }else{
            System.out.println("fail");
            System.out.println(actualTitle);
        }

        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
       // 6- Gift Cards sekmesine basin

driver.findElement(By.cssSelector("a[data-csa-c-content-id='nav_cs_gc']")).click();

       // 7- Birthday butonuna basin
//driver.findElement(By.cssSelector("a[aria-label='Birthday']>img")).click();ben sonradan yaptim
         driver.findElement(By.cssSelector("a[aria-label='Birthday']")).click();
        //8-  Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();
        //9-  Gift card details’den 25 $’i  secin
        driver.findElement(By.cssSelector("#gc-mini-picker-amount-1")).click();
        //10- Urun ucretinin 25$ oldugunu test edin
        WebElement ucretElementi= driver.findElement(By.cssSelector("#gc-live-preview-amount"));
        String expectedUcret="$25.00";
        String actualUcret= ucretElementi.getText();
        if (expectedUcret.equals(actualUcret)){
            System.out.println("Ucret Testi PASSED");
        }else{
            System.out.println("Ucret testi FAILED" +
                    "\nActual ucret : " + actualUcret);
        }
        //11- Sayfayi kapatin
        driver.close();
    }
}
