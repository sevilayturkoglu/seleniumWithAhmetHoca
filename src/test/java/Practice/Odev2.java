package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Odev2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        //Click on  Calculater under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
        //Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("6");
        //Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("6");
        //Click on Calculate as a multiple
        WebElement carpma= driver.findElement(By.id("function"));
        Select carp=new Select(carpma);
        carp.selectByVisibleText("times");
        driver.findElement(By.id("calculate")).click();
        //Get the result
        System.out.println(driver.findElement(By.id("answer")).getText());
        //Print the result
    }
}
