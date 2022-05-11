package com.unchained.Unchained.Controller;

import com.unchained.Unchained.Service.FileHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController("/api")
public class FileHandlingController {

    @Autowired
    FileHandlingService fileHandlingService;


    @GetMapping("/costfile")
    public File getCostFile(){

        File costfile = null;

        try {
            costfile = fileHandlingService.returnCostFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return costfile;
    }

    @GetMapping("/distancefile")
    public File getDistanceFile(){

        File DistanceFile = null;

        try {
            DistanceFile = fileHandlingService.returnDistanceFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return DistanceFile;
    }

    @PostMapping(path = "/costfile,", consumes = "application/json", produces = "application/json")
    public void saveCostFile(File file){
        try {
            fileHandlingService.saveCostFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
