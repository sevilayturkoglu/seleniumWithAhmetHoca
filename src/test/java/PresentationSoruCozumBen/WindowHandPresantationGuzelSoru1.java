package PresentationSoruCozumBen;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class WindowHandPresantationGuzelSoru1 extends TestBase {
    @Test
    public void test() {
        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        WebElement sey= driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(sey);
        String ilkSayfaWinHandle= driver.getWindowHandle();
        //div[.='Watch on']
        System.out.println(driver.getTitle());
        //3- video’yu gorecek kadar asagi inin
        WebElement videoLink= driver.findElement(By.xpath("//div[@class='ytp-impression-link-logo']"));
        Actions actions=new Actions(driver);
        actions.scrollToElement(videoLink).perform();
        //4- videoyu izlemek icin Play tusuna basin
        driver.findElement(By.xpath("//div[@class='ytp-impression-link-logo']")).click();
        driver.switchTo().parentFrame();
        //5- videoyu calistirdiginizi test edin
        String ikinciWindow="";
        //Set<String> windowslar= driver.getWindowHandles();

        for (String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(ilkSayfaWinHandle)){
                ikinciWindow=windowHandle;
            }
        }
        driver.switchTo().window(ikinciWindow);
        String actualTitle= driver.getTitle();
        String expectedTitle="Massive volcanoes & Flamingo colony - Wild South America - BBC - YouTube";
        Assert.assertEquals(expectedTitle,actualTitle);
    }}

