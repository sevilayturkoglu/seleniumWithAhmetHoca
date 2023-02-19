package day03_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin");

        // 2- Add Element butonuna basin

       driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        //3- Delete butonu’nun gorunur oldugunu test edin

     WebElement delete= driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
       if(delete.isDisplayed()){
           System.out.println("pass");
       }else {
           System.out.println("fail");
       }
        //4- Delete tusuna basin
        delete.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemove=driver.findElement(By.xpath("//h3"));

        if(addRemove.isDisplayed()){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
    }
}
