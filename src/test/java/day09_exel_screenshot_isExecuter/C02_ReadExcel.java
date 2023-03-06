package day09_exel_screenshot_isExecuter;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class C02_ReadExcel {
    @Test
            public void test() throws IOException {
        String dosyaYolu = "src/test/java/day09_exel_screenshot_isExecuter/ulkeler (12).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        //      - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .getCell(1));
        //      - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenData= workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .getCell(1)
                .toString();
        System.out.println("Istenen data : " + istenenData);
        //     2 - 1.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedData = "Kabil";
        String actualData = workbook
                .getSheet("Sayfa1")
                .getRow(1)
                .getCell(3)
                .toString();
        Assert.assertEquals(expectedData,actualData);
        //      - Satir sayisini bulalim
        // getLastRowNum() son satirin index'ini verir
        System.out.println("satir sayisi : " + (workbook.getSheet("Sayfa1").getLastRowNum()+1));
        //      - Sayfa2'deki satir sayisi ve Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Sayfa2 satir sayisi : " + (workbook.getSheet("Sayfa2").getLastRowNum()+1));
        System.out.println("Sayfa2 fiziki kullanilan satir sayisi : " +
                workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());
        //      - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> ulkelerMap = new TreeMap<>();
        int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 1; i <=sonSatirIndexi ; i++) { // basligi almamak icin 1'den baslattim
            String ulke= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String baskent=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            ulkelerMap.put(ulke,baskent);
        }
        for (Map.Entry<String, String> stringStringEntry : ulkelerMap.entrySet()) {
            System.out.println(stringStringEntry);
        }

      //  System.out.println(ulkelerMap);
        System.out.println(ulkelerMap.get("Syria"));



    }
    }

