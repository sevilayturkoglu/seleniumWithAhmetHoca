package Practice.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {
    public static void main(String[] args) throws InterruptedException {
        // 1 - Driver olusturalim
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        // 2 - Java class'imiza chromedriver.exe'yi tanitalim
        WebDriver driver=new ChromeDriver();
        // 3 - Driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();
        // 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));/*selenium dan gelir,islem bitince devam eder
        sure bitmesini beklemez*/
        /*Thread.sleep(2000);//javadan gelir islem yapmak icin surenin bitmesini bekler*/
        //     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
        // 5 - "https://www.otto.de" adresine gidelim
        driver.get("https://www.otto.de");
        // 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
        String actualOttoTitle= driver.getTitle();
        // 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
        String actualOttoUrl= driver.getCurrentUrl();
        if(actualOttoTitle.contains("OTTO")&& actualOttoUrl.contains("otto")){
            System.out.println("Test pass");
        }else{
            System.out.println("Test failed");
        }
        // 8 - Ardindan "https://wisequarter.com/" adresine gidelim
        driver.navigate().to("https://wisequarter.com/");
        // 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
        //     kontrol edelim
        String wiseTitle= driver.getTitle();
        System.out.println(wiseTitle);

        boolean isTrue=wiseTitle.contains("Quarter");
      /*  if(isTrue){
            System.out.println("Test Pass");
        }else {
            System.out.println("Fail");
        }*/
        System.out.println(isTrue ? "Pass" : "Fail");
        // 10- Bir onceki web sayfamiza geri donelim
        // 11- Sayfayi yenileyelim
        // 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        // 13- En son adim olarak butun sayfalarimizi kapatmis olalim
    }
}
