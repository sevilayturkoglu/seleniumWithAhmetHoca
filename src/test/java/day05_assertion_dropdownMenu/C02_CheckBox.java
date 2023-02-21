package day05_assertion_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    //     https://the-internet.herokuapp.com/checkboxes
    // b. Checkbox1 ve checkbox2 elementlerini locate edin.
    // c. Checkbox1 seçili değilse onay kutusunu tıklayın
    // d. Checkbox2 seçili değilse onay kutusunu tıklayın
    //e.Checkboxlardan ikisininde secili oldugunu test edin
    WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // a. Verilen web sayfasına gidin.
        //     https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }@After
    public void teardown(){
        driver.close();
    }@Test
    public void test1(){
        // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement cehck1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement cehck2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        // c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if(!cehck1.isSelected()){
            cehck1.click();
        }
        // d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!cehck2.isSelected()){
            cehck2.click();
        }
        //e.Checkboxlardan ikisininde secili oldugunu test edin
        Assert.assertTrue(cehck1.isSelected()&&cehck2.isSelected());
    }

}
