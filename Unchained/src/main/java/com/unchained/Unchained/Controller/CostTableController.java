package com.unchained.Unchained.Controller;

import com.unchained.Unchained.Data.Domain.CostRequest;
import com.unchained.Unchained.Service.CostTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/shippingcosts")
public class CostTableController {

    @Autowired
    private CostTableService costTableService;

    @GetMapping
    public CostRequest getShippingCosts(@RequestBody CostRequest costRequest){
        try {
            costRequest.setPrice(costTableService.getCosts(costRequest.getPallets(), costRequest.getKm()));
        } catch (Exception e) {
            //TODO
        }

        return costRequest;

    }
}
