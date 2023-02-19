package day03_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Cookies {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.google.com");

       //cookies handle
        driver.findElement(By.xpath("//div[text()='Accept all']")).click();

        //arama cubuguna java yaz arat
        WebElement aramaCubuk=driver.findElement(By.xpath("//input[@name='q']"));
        aramaCubuk.sendKeys("java"+ Keys.ENTER);

        //bulunan sayinin 100 binden cok olup olmadigini gor
        WebElement sayiStr= driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sayiStrText = sayiStr.getText();
        System.out.println(sayiStrText);//About 1,300,000,000 results (0.38 seconds)

        String[]sayiar=sayiStrText.split(" ");
        String str=sayiar[1];
       str=str.replaceAll("\\D","");
       int sayi=Integer.parseInt(str);

        if(sayi>100000){
    System.out.println("Pass");
       }else{
    System.out.println("Failed");
}
    }
}
