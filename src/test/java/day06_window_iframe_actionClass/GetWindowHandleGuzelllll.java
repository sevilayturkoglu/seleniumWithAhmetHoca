package day06_window_iframe_actionClass;
import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class GetWindowHandleGuzelllll extends TestBase {
    @Test
    public void test() {
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String ilkWHD = driver.getWindowHandle();

        //● Sayfa title’nin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");

        //● Sayfa title’nin “wisequarter” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Bootcamp"));
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com");

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");
        //● Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        bekle(1);
        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(ilkWHD);
        bekle(1);
        String actualUrl = driver.getCurrentUrl();
        String expectUrl = "https://www.amazon.com/";
        bekle(1);
        Assert.assertEquals("yoooookkk", expectUrl, actualUrl);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles
        ) {
            driver.switchTo().window(each);
            if (driver.getTitle().contains("walmart")) {

                break;
            }
        }

    }
}
