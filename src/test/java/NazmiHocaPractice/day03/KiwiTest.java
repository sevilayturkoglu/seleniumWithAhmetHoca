package NazmiHocaPractice.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class KiwiTest {
    //// https://www.kiwi.com sayfasina gidin
    //// Cookies i reddedin
    //// Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
    //// Sectiginiz dil ve para birimini dogrulayin
    //// Ucus secenegi olarak tek yon secelim
    //// Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
    //// Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
    //// Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
    //// Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim
    WebDriver driver;
    String http="https://www.";
    @Before
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }@Test
    public void test1(){
        driver.get("https://www.kiwi.com");
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1nfggrh-0 iFkUjC'])[3]")).click();
    }
}
