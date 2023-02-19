package day02_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElements {
    public static void main(String[] args) throws InterruptedException {
        /*
            driver'a weblementi tarif etme islemine Locate ,
            bu tarifi yapabilmek icin kullanabilecegim degiskenlere de LOCATOR denir
            8 tane Locator vardir
            Locator'larin 6 tanesi webelement'in ozelliklerine baglidir
                - id
                - classname
                - name
                - tagname
                - linkText
                - partialLinkText
            Geriye kalan 2 locator ise her turlu webelementi locate etmek icin kullanilabilir
                - xpath
                - cssSelector
         */

        System.setProperty("webdriver.chrome.drive","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //amazona git
        driver.get("https://amazon.com");
        //arama kutusuna locate edip bir webelement olarak kaydedin
        WebElement aramaBox=driver.findElement(By.id("twotabsearchtextbox"));

        //arama kutusuna "Nutella" yaz arat
        aramaBox.sendKeys("Nutella");
        aramaBox.submit();
        // driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(3000);


    }
}
