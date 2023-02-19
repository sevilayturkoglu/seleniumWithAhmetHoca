package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class dene {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Navigate to website https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        //Framesi tikla
        driver.findElement(By.id("frames")).click();
        //Content frame git
        driver.switchTo().frame("content");
        //Load white page tikla
        driver.findElement(By.xpath("//a[.='Load white page']")).click();
        Thread.sleep(2000);
        //Back to original page tikla
        driver.findElement(By.xpath("//a[.='Back to original page']")).click();
        //Ana html frame geri don
        driver.switchTo().defaultContent();
        //footer frame git
        driver.switchTo().frame("footer");
        //Footer da bulunam Green Page tikla
        driver.findElement(By.xpath("//a[.='Green Page']")).click();
        //Ana html ye geri don
        driver.switchTo().defaultContent();

    }
}
