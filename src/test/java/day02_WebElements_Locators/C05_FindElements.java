package day02_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_FindElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        //arama kutusuna java yazip aratin
      WebElement searchBox=  driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java"+ Keys.ENTER);
        // searchBox.submit();
        //arama sonuclarinda yazan yazilari yazdirmaya calisin
       List<WebElement> aramaSonuclariElement=driver.findElements(By.className("sg-col-inner"));
        System.out.println(aramaSonuclariElement.size());
        int no=1;
        for (WebElement each:aramaSonuclariElement
             ) {
            System.out.println(no+"-"+each.getText());
           no++;
        }
    }
}
