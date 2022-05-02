package com.unchained.Unchained.Controller;

import com.unchained.Unchained.Data.Domain.CostRequest;
import com.unchained.Unchained.Service.CostRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class CostRequestEndpoint {

    @Autowired
    private CostRequestService costRequestService;

    Logger logger = LoggerFactory.getLogger(CostRequestEndpoint.class);

    @PostMapping(path="/costrequest")
    public @ResponseBody CostRequest getShippingCosts(@RequestBody CostRequest costRequest){
        try {
            costRequest.setPrice(costRequestService.getCosts(costRequest.getPallets(), costRequest.getKm()));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return costRequest;
    }
}
