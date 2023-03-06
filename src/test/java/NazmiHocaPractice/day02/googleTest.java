package NazmiHocaPractice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class googleTest {
    // ilgili kurulumlari tamamlayalim
    // Kullanici https://www.google.com adresine gider
    // Kullanici cookies i kabul eder
    // Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer
    // Para birimlerinin karsilastirmasini alir
    // Karsilastirilacak olan para biriminin 1.5 den kucuk oldugu test edilir

    WebDriver driver;
    String http="https://www.";
    @Before
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void googleTest(){
        driver.get(http+"google.com");
       WebElement cookies= driver.findElement(By.xpath("//div[.='Reject all']"));
       cookies.click();
        WebElement googleAramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        googleAramaKutusu.sendKeys("Dollar to Pound"+ Keys.ENTER);
        String sayi=driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']")).getText();
        System.out.println(sayi);
        double db=Double.parseDouble(sayi);

        Assert.assertTrue(db<1.5);
    }
    @After
    public void tearDown(){
       // driver.close();
    }
    }

