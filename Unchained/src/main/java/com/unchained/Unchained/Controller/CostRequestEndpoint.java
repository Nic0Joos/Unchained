package com.unchained.Unchained.Controller;

import com.unchained.Unchained.Data.Domain.CostRequest;
import com.unchained.Unchained.Service.CostRequestService;
import com.unchained.Unchained.Service.UserDetailsServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Author: Nico

@Controller
@RequestMapping(path = "/api")
public class CostRequestEndpoint {

    @Autowired
    private CostRequestService costRequestService;

    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;

    Logger logger = LoggerFactory.getLogger(CostRequestEndpoint.class);

    @GetMapping(path="/costrequest")
    public @ResponseBody CostRequest getShippingCosts(@RequestBody CostRequest costRequest){
        try {
            costRequest.setPrice(costRequestService.getCosts(costRequest.getPallets(), userDetailsServiceImp.getCurrentUser().getTraveldistance()));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return costRequest;
    }
}
