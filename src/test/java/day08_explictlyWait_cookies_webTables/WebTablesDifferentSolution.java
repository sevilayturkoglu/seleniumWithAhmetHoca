package day08_explictlyWait_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTablesDifferentSolution extends TestBase {

    @Test
            public void test(){

    //        1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");


    // 2. Headers da bulunan basliklari yazdirin
    List<WebElement> basliklar = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));

    int satirNo = 1;
        for (WebElement each : basliklar) {
        System.out.println("Baslik" + satirNo + "-" + each.getText());
        satirNo++;

    }
    bekle(2);

        // 3. 3.sutunun basligini yazdirin
        ////div[@class='rt-resizer']
        System.out.println("3.Stunun basligi: " + basliklar.get(2).getText());

    // 4. Tablodaki tum datalari yazdirin
    List<WebElement> tumDatalar = driver.findElements(By.xpath("//div[@class='ReactTable -striped -highlight']"));
        for (WebElement each : tumDatalar) {
        System.out.println("Tum Datalar :" +
                "\n" + each.getText());

    }

    // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
    int count = 0;

    List<WebElement> cells = driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (WebElement cell : cells) {
        if (!cell.getText().isEmpty() && cell.isDisplayed() && !cell.getText().isBlank()) {
            count++;
        }

    }

        System.out.println("Bos olmayan hucre sayisi : " + count);

    // 6. Tablodaki satir sayisini yazdirin
    List<WebElement> satirlar = driver.findElements(By.xpath("//div[@role='rowgroup'] "));
        System.out.println(satirlar);
        System.out.println("Satir sayisi: " + satirlar.size());


        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("sutun Sayisi :" + cells.size() / satirlar.size());
    // 8. Tablodaki 3.kolonu yazdirin
    List<WebElement> ucuncuSutun = driver.findElements(By.xpath("//div[@class='rt-td'][3]"));

    satirNo = 0;
        for (WebElement eachData : ucuncuSutun) {
        System.out.println(satirNo + "- " + eachData.getText());
        satirNo++;
    }

        // 9. Tabloda “First Name” i Cierra olan kisinin Salary’sini yazdirin
        for(int i=1; i<=satirlar.size();i++){
        if(getData(i,1).equals("Cierra")) {
            System.out.println("Salary :"+(getData(i,5) ));
        }
    }

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

        System.out.println(("Satir Sutun girilince cikan sonuc (1,5):"+getData(1,5)));
}

public String getData(int satirNo, int sutunNo){

        String dataXpath= "//div[@class='rt-tbody']/div["+satirNo+"]/div/div["+sutunNo+"]";
        String istenenData = driver.findElement(By.xpath(dataXpath)).getText();
        return istenenData;
        }
        }
