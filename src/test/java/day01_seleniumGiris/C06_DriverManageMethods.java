package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_DriverManageMethods {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.drver","drivers/chromedriver_win32.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        System.out.println("maximize size= "+driver.manage().window().getSize());
        System.out.println("Maximizeget position"+driver.manage().window().getPosition());

        driver.manage().window().fullscreen();
        System.out.println("full size= "+driver.manage().window().getSize());
        System.out.println("Fullget position"+driver.manage().window().getPosition());
    }
}/*
echo "# seleniumWithAhmetHoca" >> README.md
        git init
        git add README.md
        git commit -m "first commit"
        git branch -M main
        git remote add origin https://github.com/sevilayturkoglu/seleniumWithAhmetHoca.git
        git push -u origin main*/