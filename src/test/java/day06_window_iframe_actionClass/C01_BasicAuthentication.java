package day06_window_iframe_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_BasicAuthentication extends TestBase {

    @Test
    public void test01(){
        //1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
      // driver.get("https://the-internet.herokuapp.com/basic_auth");//bu adres ile giremeyiz cunki sifre ister
        //cunki basic authentication var,sifresiz siteye giremeyiz

        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        // Username    : admin
        //  password     : admin
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        String actual=driver.findElement(By.tagName("p")).getText();
        String expected="Congratulations";
        Assert.assertTrue(actual.contains(expected));

    }
}
