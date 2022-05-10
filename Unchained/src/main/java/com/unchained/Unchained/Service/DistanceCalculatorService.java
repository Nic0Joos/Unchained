package com.unchained.Unchained.Service;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

//Autor:

//Inspired from https://www.youtube.com/watch?v=KeBTs5Nm0Tg

@Service
public class DistanceCalculatorService {


    public int getDistance(int ZIPCode) throws Exception {

        //Read and create sheet from excel
        FileInputStream Input = new FileInputStream("src/main/resources/Distances.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(Input);
        XSSFSheet sheet =  workbook.getSheet("Distances");

        //Create Hashmap from sheet
        int rows = sheet.getLastRowNum();
        HashMap<String,String> Distances = new HashMap<String,String>();

        //Storing data to Hashmap
        for(int i = 0; i<=rows; i++) {
           String key = sheet.getRow(i).getCell(0).getRawValue();
           String value = sheet.getRow(i).getCell(1).getRawValue();
           Distances.put(key, value);
        }

        //Retrieve the kilometers from Hashmap
        String SearchKey = Integer.toString(ZIPCode);
        String SearchResult = Distances.get(SearchKey);
        int TravelDistance;

        if (SearchResult == null) {
            throw new Exception("Uncommon ZIPCode" + ZIPCode);
        } else {
            TravelDistance = Integer.parseInt(SearchResult);
            return TravelDistance;
        }
    }
}
