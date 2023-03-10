package day03_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_MavenIlkClas {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


       // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
       // 2- arama kutusunu locate edelim
        WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
        //3- “Samsung headphones” ile arama yapalim
        search.sendKeys("Samsung headphones"+ Keys.ENTER);
       // 4- Bulunan sonuc sayisini yazdiralim
        System.out.println(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span")).getText());
        //System.out.println(driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText());
       // 5- Ilk urunu tiklayalim
         driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
       // 6- Sayfadaki tum basliklari yazdiralim
        driver.navigate().back();

       List<WebElement> textAll= driver.findElements(By.xpath("//div[@class='sg-col-inner']"));
        for (WebElement each:textAll
             ) {
            System.out.println(each.getText());
        }
        Thread.sleep(3000);
        driver.close();
    }
}
