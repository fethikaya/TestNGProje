package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void test () throws IOException {

        String dosyaYolu = ".\\src\\test\\resources\\ULKELER.xlsx";

                        //Java'da bir dosyayı açmak için bu kullanılır.
                        // Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

                        // Workbook (excel) dosyasını okumaya başladık.

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        // FileInput dosyadan yazı alıyor
        // FileOutput dosyaya yazı yazar, bunun için FileOutputStream class'ında dosya oluşturoyuruz.


        // 0 indexli satırın, 3. indekindeki hücreye Nufus hücresi eklecyeğiz.

        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NÜFUS"); // Degişiklik yaptık. ekledik
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("80000000");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("10000000");




        // İstediğimiz Hücreyi silme
        // 0 index satırın 1. indexli hücreyisil (Başkent)

        Cell silmekIstediginizHucre =workbook.getSheetAt(0).getRow(0).getCell(1);
                // Once siliniecek hucreyi belirliyoruz
        workbook.getSheetAt(0).getRow(0).removeCell(silmekIstediginizHucre);
            // sonra siliyoruz




        // Tüm satırı silme
        Row silinecekSatir = workbook.getSheetAt(0).getRow(1);
        workbook.getSheetAt(0).removeRow(silinecekSatir);


        workbook.write(fileOutputStream);  // veriye excel'e aktararak kayd ediyor.


    }

}
