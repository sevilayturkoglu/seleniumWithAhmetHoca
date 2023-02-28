package day08_explictlyWait_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C06_WebTables extends TestBase {
    @Test
    public void test() {

        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan basliklari yazdirin
       System.out.println("****************TUM HEADERS BASLIKLARI************************");
        List<WebElement> headersBaslik = driver.findElements(By.xpath("//div[@class='rt-tr']/div"));
        int count=1;
        for (WebElement each:headersBaslik
             ) {
            System.out.println(count+"-"+each.getText());
            count++;
        }
        // 3. 3.sutunun basligini yazdirin
       String ucuncuBaslik= driver.findElement(By.xpath("//div[@class='rt-tr']/div[3]")).getText();
        System.out.println("Ucuncu Sutun Basligi= "+ucuncuBaslik);

        // 4. Tablodaki tum datalari yazdirin
        System.out.println("****************TUM TABLE************************");
        System.out.println(driver.findElement(By.xpath("//div[@class='rt-tbody']")).getText());//Hedars olmadan
        System.out.println("**************TUM TABLE WITH HEADERS*****************");
        System.out.println(driver.findElement(By.xpath("//div[@class='rt-table']")).getText());//headerslarla beraber tum table yazdiriryor

        System.out.println("****************TABLE DATA TOPLU WITH LIST************************");
        count=1;
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div"));//sadece tablo ici datalari yazdiriyor
        for (WebElement each:elements
             ) {
            System.out.println(count+"-"+each.getText());
            count++;
        }
        System.out.println("****************TUM DATA CELL************************");
        count=1;
        List<WebElement> AllCell = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div"));//tum hucreleri yazdirir
        for (WebElement each:AllCell
             ) {
            System.out.println(count+"-"+each.getText());
            count++;
        }
        //5-Dolu hucreleri yazdirin
        count=0;
        List<WebElement> AllCell1 = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div"));//tum hucreleri yazdirir
        for (WebElement each:AllCell1
        ) {
            if(!each.getText().isBlank()){
                count++;
            }
        }
        System.out.println("dolu cell= "+count);

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> rowSayisi = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        int satirSayisi=rowSayisi.size();
        System.out.println("Satir Sayisi= "+satirSayisi);

        // 7. Tablodaki sutun sayisini yazdirin
        int sutunSayisi=headersBaslik.size();
        System.out.println("Sutun Sayisi= "+sutunSayisi);

        // 8. Tablodaki 3.kolonu yazdirin
        System.out.println("***************UCUNCU COLUMN*************************");
        List<WebElement> ucuncuKolonelements = driver.findElements(By.xpath("//div[@class='rt-tbody']//div//div[3]"));
        count=1;
        for (WebElement each:ucuncuKolonelements
             ) {
            System.out.println(count+"-"+each.getText());
            count++;
        }

        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin

      //  System.out.println("Kierra's Salary= "+getData(3, 5)); //method ile kisa yoldan salary alimi

        List<WebElement> eachElements = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[1]"));
    String personName="Kierra";
    int istenilenBilgiStunNo=5;
        for(int i=1; i<=eachElements.size();i++){
            if(getData(i,1).equals(personName)) {
                System.out.println(personName+" Salary :"+(getData(i,istenilenBilgiStunNo) ));
            }
        }

      //Methodun calismasini kontrol edelim
     //   Ikinci satirdaki Alden in Emailini  alalim
        System.out.println("Alden eMail= "+getData(2,4));

        System.out.println(getData(2, 4));

    }//10. bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
    public String getData(int satir,int sutun){

        String element1="//div[@class='rt-tr-group']["+satir+"]/div/div["+sutun+"]";
        String istenenText=driver.findElement(By.xpath(element1)).getText();
        return istenenText;
    }

}
