package com.unchained.Unchained.Controller;


import com.unchained.Unchained.Data.Domain.User;
import com.unchained.Unchained.Service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@Controller
public class UserController {

    @Autowired
    UserDetailsServiceImp userService;

    @PostMapping(path = "/user/register")
    public ResponseEntity<Void> postRegister(@RequestBody User user) {
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
            //TODO: log to a file if exception is thrown
        }
        return ResponseEntity.ok().build();
        //TODO: log to a file if ok
    }

    @PutMapping(path = "/profile")
    public ResponseEntity<User> putUser(@RequestBody User user) {
        try {
            user.setUserId(userService.getCurrentUser().getUserId());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
            //TODO: log to a file if error
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public @ResponseBody User getProfile() {
        return userService.getCurrentUser();
        //TODO:Log to file
    }

}
