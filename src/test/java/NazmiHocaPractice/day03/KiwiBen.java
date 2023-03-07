package NazmiHocaPractice.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class KiwiBen {
    // https://www.kiwi.com sayfasina gidin
    // Cookies i reddedin
    // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
    // Sectiginiz dil ve para birimini dogrulayin
    // Ucus secenegi olarak tek yon secelim
    // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
    // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
    // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
    // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim
    WebDriver driver;

    @Before
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() throws InterruptedException {
        // https://www.kiwi.com sayfasina gidin
        driver.get("https://www.kiwi.com");
        // Cookies i reddedin
        driver.findElement(By.xpath("//*[.='Reject all']")).click();
        // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
        driver.findElement(By.xpath("//div[@class='CountryFlag__StyledShadow-sc-m27t9u-2 jjikbK']")).click();
        WebElement dropLanguage = driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));
        Select select = new Select(dropLanguage);
        select.selectByVisibleText("Türkçe");
        WebElement dropPara = driver.findElement(By.xpath("//select[@data-test='CurrencySelect']"));
        select = new Select(dropPara);
        select.selectByVisibleText("Turkish lira - TRY");
        driver.findElement(By.xpath("(//div[.='Save & continue'])[3]")).click();
        // Sectiginiz dil ve para birimini dogrulayin
        Assert.assertTrue(driver.findElement(By.xpath("(//div[.='TRY'])[2]")).getText().equals("TRY"));

        // Ucus secenegi olarak tek yon secelim
        driver.findElement(By.xpath("//div[.='Gidiş Dönüş']")).click();
        driver.findElement(By.xpath("//p[.='Tek Yön']")).click();
        Thread.sleep(2000);
        // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
        driver.findElement(By.xpath("(//*[@preserveAspectRatio='xMidYMid meet'])[29]")).click();

        driver.findElement(By.xpath("//input[@data-test='SearchField-input']")).sendKeys("Istanbul");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@data-test='PlacePickerRow-wrapper'])[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[2]")).sendKeys("Varsova");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@data-test='PlacePickerRow-wrapper']")).click();
        // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim

        driver.findElement(By.xpath("//*[@class='Checkbox__StyledIconContainer-sc-y66hzm-0 kPpSfm']")).click();

        driver.findElement(By.xpath("//input[@data-test='SearchFieldDateInput']")).click();

        driver.findElement(By.xpath("//div[@data-value='2023-03-16']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[.='Tarihleri ayarla']")).click();
        driver.findElement(By.xpath("//div[.='Ara']")).click();

        // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim

        WebElement aktarma= driver.findElement(By.xpath("(//*[.='Aktarmasız (direkt)'])[3]"));
      aktarma.click();
      Thread.sleep(3000);


        //driver.findElement(By.xpath("//span[.='En ucuz']")).click();
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[.='En ucuz']"))).click().perform();

// Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim

       String lowprices=driver.findElement(By.xpath("(//strong[@data-test='ResultCardPrice'])[1]")).getText();
        lowprices=lowprices.replaceAll("\\D","");
        System.out.println(lowprices);
        int doPrice=Integer.parseInt(lowprices);
        System.out.println(doPrice);
        Assert.assertTrue(doPrice<5000);



    }
}