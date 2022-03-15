package com.unchained.Unchained.api;

import com.unchained.Unchained.Data.Domain.CostRequest;
import com.unchained.Unchained.Service.CostTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class CostTableEndpoint {

    @Autowired
    private CostTableService costTableService;

    Logger logger = LoggerFactory.getLogger(CostTableEndpoint.class);

    @GetMapping(path="/costrequest")
    public @ResponseBody CostRequest getShippingCosts(@RequestBody CostRequest costRequest){
        try {
            costRequest.setPrice(costTableService.getCosts(costRequest.getPallets(), costRequest.getKm()));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return costRequest;
    }
}
