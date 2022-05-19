package com.unchained.Unchained.Controller;

import com.unchained.Unchained.Data.Domain.CostRequest;
import com.unchained.Unchained.Service.CostRequestService;
import com.unchained.Unchained.Service.LoggerService;
import com.unchained.Unchained.Service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private LoggerService loggerService;


    @PostMapping(path="/costrequest", consumes = {"application/json"}, produces = {"application/json"})
    public @ResponseBody ResponseEntity<CostRequest> getShippingCosts(@RequestBody CostRequest costRequest){
        try {
            costRequest.setPrice(costRequestService.getCosts(costRequest.getPallets(), 50));// userDetailsServiceImp.getCurrentUser().getTraveldistance()));
        } catch (Exception e) {
            loggerService.logSystem("warning",e.toString());
        }
        return ResponseEntity.ok().build();
    }

}
