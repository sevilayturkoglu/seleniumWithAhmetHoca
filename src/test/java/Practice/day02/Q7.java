package Practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q7 {
    /*..........Exercise1............
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin.
     */
    static WebDriver driver;
    WebElement searchBox;
    @BeforeClass
    public static void setUp() {
        //BeforeClass ile driver'i olusturun ve class icinde static yapin
        //    Maximize edin ve 10 sn bekletin
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.google.com");
        //
    }
@Before
        public void before(){
   // driver.get("http://www.google.com");
    }
    @Test
    public void test01(){
        //http://www.google.com adresine gidin

       driver.findElement(By.xpath("//div[.='Reject all']")).click();
        //   arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        searchBox=driver.findElement(By.xpath("//input[@class='gLFyf']"));
       searchBox.sendKeys("The Lord of the Rings"+ Keys.ENTER);

            WebElement sonuc1= driver.findElement(By.id("result-stats"));
        System.out.println(sonuc1.getText());
    }@Test
    public void test02(){
        //arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
        searchBox=driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.clear();
        searchBox.sendKeys("Brave Heart"+ Keys.ENTER);

        WebElement sonuc1= driver.findElement(By.id("result-stats"));
        System.out.println(sonuc1.getText());
    }@Test
    public void test03(){
        //   arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
        searchBox=driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.clear();
        searchBox.sendKeys("Harry Potter"+ Keys.ENTER);
        WebElement sonuc1= driver.findElement(By.id("result-stats"));
        System.out.println(sonuc1.getText());
    }
}
