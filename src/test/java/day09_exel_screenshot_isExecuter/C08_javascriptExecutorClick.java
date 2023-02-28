package day09_exel_screenshot_isExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_javascriptExecutorClick extends TestBase {
    @Test
    public void test(){
        //wisequarteara git
        driver.get("https://www.wisequarter.com");
        driver.navigate().refresh();

        WebElement otomasyonElementi= driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));
       bekle(2);
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()",otomasyonElementi);
        bekle(2);
        jse.executeScript("arguments[0].click()",otomasyonElementi);
        bekle(2);
        jse.executeScript("alert('JUnit Bitti')");


        /*// wisequarter anasayfaya gidelim
        driver.get("https://www.wisequarter.com");
        //refresh diyerek reklami gecin
        driver.navigate().refresh();

        // Java Test otomation tanitimina kadar asagi inin
        WebElement otomasyonElementi1= driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));

        bekle(2);
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;

        jse1.executeScript("arguments[0].scrollIntoView();",otomasyonElementi1);

        // ve resmi click yapin ?
        bekle(2);

        jse1.executeScript("arguments[0].click();",otomasyonElementi1);

        // ekrana "JUnit bitti" yazdirin
        bekle(2);

        jse1.executeScript("alert('JUnit Bitti');");
        bekle(3);*/

    }
}
