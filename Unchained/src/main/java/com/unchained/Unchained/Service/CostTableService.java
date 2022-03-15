package com.unchained.Unchained.Service;

import org.springframework.stereotype.Service;


@Service
public class CostTableService {


    public double getCosts(int pallets, int km) throws Exception {
        double shippingCosts;

        final double[][] CostTable = {
        {58.65, 87.00, 114.50, 137.10, 160.80, 181.65, 201.45, 220.30, 238.35, 255.35, 271.45, 286.55},
        {67.00, 99.40, 130.85, 156.75, 183.80, 207.55, 230.25, 251.85, 251.85, 272.40, 291.90, 310.25},
        {75.40, 111.90, 147.15, 176.35, 206.65, 233.50, 259.00, 283.35, 306.45, 328.40, 348.95, 368.40},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
        {1, 2, 1, 4, 5, 6, 7, 8, 9, 10, 11, 12},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11 ,12},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
        };

        if (pallets >= 13 || km >= 361){
            throw new Exception("Too much pallets used or too many kilometers to ship");
        } else if(km % 30 == 0) {
            shippingCosts = CostTable[pallets-1][(km/30)-1];
        } else {
            shippingCosts = CostTable[pallets-1][(km/30)];
        }
        return shippingCosts;
    }


}
