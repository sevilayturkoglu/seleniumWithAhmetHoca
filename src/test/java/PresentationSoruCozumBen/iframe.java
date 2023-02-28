package PresentationSoruCozumBen;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class iframe extends TestBase {
    @Test
    public void test() {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
      String firstWindowHandle = driver.getWindowHandle();
        WebElement iframe = driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//span[.='Accept All']")).click();

        //2) sayfadaki iframe sayısını bulunuz.
       List<WebElement> countIframe = driver.findElements(By.tagName("iframe"));
       System.out.println(countIframe.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@width='560']")));
        driver.findElement(By.xpath("//div[@class='ytp-impression-link-logo']")).click();


        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
      driver.switchTo().parentFrame();

        String ikinciWind = "";
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(firstWindowHandle)) {
                ikinciWind = windowHandle;
            }
        }

        driver.switchTo().window(firstWindowHandle);


         //5) ikinci iframe'deki (Jmeter Made Easy) linke tiklayiniz
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='a077aa5e']")));
        Actions actions = new Actions(driver);
        WebElement meter = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
        actions.scrollToElement(meter).perform();
        meter.click();
        bekle(2);
        System.out.println(driver.getWindowHandle());
       // driver.switchTo().window(ikinciWind).close();

        //"https://www.guru99.com/live-selenium-project.html" sayfasinda oldugunuzu dogrulayiniz
        String ucuncuWind = "";
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().equals("https://www.guru99.com/live-selenium-project.html")) {
                ucuncuWind = windowHandle;
                break;
            }
        }
        driver.switchTo().window(ucuncuWind);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.guru99.com/live-selenium-project.html";
        Assert.assertEquals(expectedUrl, actualUrl);

    }
}