package com.unchained.Unchained.Service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileHandlingService {


    public File returnCostFile() throws Exception {

        File costFile = new File("src/main/resources/costs.txt");

        return costFile;
    }

    public File returnDistanceFile() {

        File distanceFile = new File("src/main/resources/distances.xlsx");
        return distanceFile;

    }


    public void saveCostFile(File file) {

        //Innputstream reads file
        //Outputstream changes the file

    }
}
