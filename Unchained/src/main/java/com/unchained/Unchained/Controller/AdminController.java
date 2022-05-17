/*package com.unchained.Unchained.Controller;

import com.unchained.Unchained.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping(path = "/api")
public class AdminController {


    //File upload of cost.txt / Distances.xlsx


    @Autowired
    FileService fileService;

    @PostMapping(path = "/costfile", consumes = "application/json",produces = "application/json")
    public void postCostFile() {
        File file = null;

        try {
            fileService.saveCostFile();
        } catch (Exception e) {

        }

    }

    @PostMapping(path = "/costfile", consumes = "application/json",produces = "application/json")
    public void postDistanceFile() {
        File file = null;

        try {
            fileService.saveCostFile();
        } catch (Exception e) {

        }

    }

}*/