package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBaseClass {
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
       /* WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();*/

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }/*

    @AfterClass
    public static void teardown() {
        driver.quit();
    }*/

    public  void bekle(int saniye) {//try catch alinca artik bir daha exception firlatma istemeyecek,more action ile try cach yaptik kisaca
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}