package Practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q6 {
    @BeforeClass
    public static void setUp(){
        System.out.println("Before Class");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("After class");
    }
    @Before
    public void before(){
        System.out.println("before");
    }
    @After
    public void after(){
        System.out.println("after");
    }
    @Test
    public void ahmet(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Ahmet");
    }
    @Test
    public void bekir(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Bekir");
    }@Test
    public void cengiz(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Cengiz");
    }
}
