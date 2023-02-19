package day02_WebElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_Locators {
    public static void main(String[] args) {

        //1- https://www.amazon.com/ sayfasına gidin.
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        //  2- Arama kutusuna “city bike” yazip aratin
       WebElement cityAra= driver.findElement(By.id("twotabsearchtextbox"));
       cityAra.sendKeys("city bike");
       cityAra.submit();
        //  3- Görüntülenen sonuçların sayısını yazdırın
WebElement sayi=driver.findElement(By.className("rush-component"));
        System.out.println(sayi.getText());
        // 4- Listeden ilk urunun resmine tıklayın.
        driver.findElement(By.className("s-image")).click();
    }
}
