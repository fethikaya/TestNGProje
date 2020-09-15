package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {


    @Test
    public void test () throws IOException {

        String dosyaYolu = "src/test/resources/ULKELER.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fileInputStream); // Okumak için obje oluşurduk

        Sheet sheet   = workbook.getSheetAt(0);
        // kaçıncı sayfaya gitmek istiyorsunuz. Sayfa indeksi yaz. index sıfırdan başlar

        Row row     = sheet.getRow(0); // Satır seçtik. index numarası verilir. index sıfırdan başlar

        Cell ulkeler      = row.getCell(0); // Hücreyi seçtik.
        Cell baskentler  = row.getCell(1);
        Cell meshurlar = row.getCell(2);

        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        // Kısa yol
        workbook.getSheetAt(0).getRow(2).getCell(1);
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));

        // Excel'e git, birinci sayfa, dördüncü satır ve 2 hücreye git

        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2)); // 1 sayfa 8 satır 3 hücre

        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0)); // 1 sayfa 11 satır 1 hücre

        // Son satır (Row) ın numarasını almak içni, index sıfırdan başlar

        int satirSayisi = workbook.getSheetAt(0).getLastRowNum() + 1;
        System.out.println("Satır Sayısı : " + satirSayisi );  // Satır sayısını verir


        // Boş satır sayısını almaz. Sadece dolu satırları alır
        // index 1'den başlar

        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println(doluSatirSayisi);

        // Tüm ülkleri almak. Bir stünün tümünü almak

        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum();
        for (int i =0; i <= sonSatirinIndexi; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
            // ilk sutunu tamamını yazdırdık.
        }


        for (int i =0; i <= sonSatirinIndexi; i++) {
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(1));
            // İkinci sutunu tamemen yazdırdık
        }


        // Tüm satıra bakmak (Satırın tüm hüclerine bakmak)
        // Satırın son sütünün indeksini almak. index 1 dan başlar

        // bir satırın son sütunun indexini alma
        // 1'den başlıyor

        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("Son Sütun İndex : " + sonSutunIndex);

        for(int k = 0; k < sonSutunIndex ; k++) {
            System.out.println("4. Satır " + k + ". Sütun :" + workbook.getSheetAt(0).getRow(3).getCell(k));

        }

       fileInputStream.close();

       // workbook.close();
       // fileInputStream.close();



    }


}