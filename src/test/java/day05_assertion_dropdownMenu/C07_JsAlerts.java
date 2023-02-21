package day05_assertion_dropdownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utilities.TestBase;
import utilities.TestBaseClass;

public class C07_JsAlerts extends TestBaseClass {
    Alert alert;
    // Gerekli ayarlamalari yapip
// https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
// 3 test method'u olusturup her method'da bir JsAlert'e basin
// Ilgili method'lari kullanin
// https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
// 1.alert'e tiklayalim
// Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
// OK tusuna basip alert'i kapatalim
// https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
// 2.alert'e tiklayalim
// cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
// https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
// 3.alert'e tiklayalim
// Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
// Cikan sonuc yazisinin Abdullah icerdigini test edelim
    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 1.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
        alert = driver.switchTo().alert();
        String actualText = alert.getText();
        System.out.println(actualText);
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualText, expectedText);
// OK tusuna basip alert'i kapatalim
        alert.accept();
        System.out.println("hello 1");

    }
    @Test
    public void test02() {
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        bekle(2);
        driver.switchTo().alert().dismiss();
        bekle(2);
        String expectedSonucYazisi="You clicked: Cancel";
        String actualSonucYazisi= driver
                .findElement(By.xpath("//*[@id='result']"))
                .getText();
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
        System.out.println("hello 2");
    }

    @Test
    public void test03() {
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
// 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
// Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        alert=driver.switchTo().alert();
        alert.sendKeys("Abdullah");
        alert.accept();
// Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String actualSonucYazisi= driver
                .findElement(By.xpath("//*[@id='result']"))
                .getText();
        String excpectedSonuc="Abdullah";

        Assert.assertTrue(actualSonucYazisi.contains(excpectedSonuc));
        System.out.println("hello 3");
    }}