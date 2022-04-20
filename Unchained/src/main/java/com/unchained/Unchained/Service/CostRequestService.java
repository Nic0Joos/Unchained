package com.unchained.Unchained.Service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;

@Service
public class CostRequestService {

    //TODO Log to file

    public double getCosts(int pallets, int km) throws Exception {

        double shippingCosts;

        File costFile = new File("src/main/resources/costs.txt");
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(costFile)));

        final int rows = 12;
        final int columns = 12;
        final double[][] CostTable = new double[rows][columns];

        while (scanner.hasNext()) {
            for (int i = 0; i<CostTable.length; i++) {
                String[] line = scanner.nextLine().trim().split(",");
                for  (int j = 0; j<line.length; j++) {
                    CostTable[i][j] = Double.parseDouble(line[j]);
                }
            }
        }

        if (pallets >= 13 || km >= 361) {
            throw new Exception("Too much pallets used or too many kilometers to ship");
        } else if(km % 30 == 0) { //Check for threshold (because up to and including 30)
            shippingCosts = CostTable[(km/30)-1][pallets-1];
        } else { //all other values that are not a threshold value
            shippingCosts = CostTable[km/30][pallets-1];
        }

        return shippingCosts;
    }


}
