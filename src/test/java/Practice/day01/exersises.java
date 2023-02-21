package Practice.day01;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class exersises {
    public static void main(String[] args) {
        //Automation Exercise Category Testi
        //1- Bir test class'i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //3- Category bolumundeki elementleri locate edin
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='panel panel-default']"));
        //4- Category bolumunde 3 element oldugunu test edin
        int actualElementSize=elements.size();
        int expectedElementSize=3;
        Assert.assertEquals(expectedElementSize,actualElementSize);
        //5- Category isimlerini yazdirin
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        //6- Sayfayi kapatin
       // driver.close();
    }
}
