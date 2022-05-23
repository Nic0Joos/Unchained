package com.unchained.Unchained.Controller;


import com.unchained.Unchained.Service.UserDetailsServiceImp;
import com.unchained.Unchained.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/api")
public class AdminController {

    @Autowired
    private UserService userDetailsServiceImp;


    @GetMapping
    public String getAdminView(){
       if(userDetailsServiceImp.getCurrentUser().isAnAdmin()) {
           return "index.html";
       } else {
           return "403.html";
       }
    }

}