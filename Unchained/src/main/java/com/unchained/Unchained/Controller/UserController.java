package com.unchained.Unchained.Controller;


import com.unchained.Unchained.Data.Domain.UnchainedUser;
import com.unchained.Unchained.Service.DistanceCalculatorService;
import com.unchained.Unchained.Service.LoggerService;
import com.unchained.Unchained.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//Author: Alex
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DistanceCalculatorService distanceCalculatorService;

    @Autowired
    LoggerService loggerService;

    @PostMapping(path = "/register", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Void> postRegister(@RequestBody UnchainedUser unchainedUser) {
        try {
            unchainedUser.setTraveldistance(distanceCalculatorService.getDistance(unchainedUser.getZipCode()));
            userService.saveUser(unchainedUser);
            loggerService.logUser("User: " + unchainedUser.getName() + " was created with Traveldistance: "+ unchainedUser.getTraveldistance());
        } catch (Exception e) {
            loggerService.logSystem("warning", e.toString());
            new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/profile")
    public ResponseEntity<UnchainedUser> putUser(@RequestBody UnchainedUser unchainedUser) {
        try {
            unchainedUser.setUserId(userService.getCurrentUser().getUserId());
        } catch (Exception e) {
            loggerService.logUser("User profile of " + unchainedUser + "was changed.");
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/profile", produces = "application/json")
    public @ResponseBody
    UnchainedUser getProfile() {
        return userService.getCurrentUser();
    }

    @GetMapping(path = "/user")
    public String getProfileView() {
        return "customer.html";
    }

    @GetMapping(path = "/register")
    public String getRegisterView(){
        return "register.html";
    }

    @GetMapping(path = "/login")
    public String getLoginView(){
        return "login.html";
    }

    @RequestMapping(value = "/validate", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Void> init() {
        return ResponseEntity.ok().build();
    }
}
