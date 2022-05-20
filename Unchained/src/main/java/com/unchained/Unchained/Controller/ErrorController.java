package com.unchained.Unchained.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Author: Lennart
@Controller
@RequestMapping(path = "/error")
public class ErrorController {

    @GetMapping
    public String get403view(){
        return "403.html";
    }

    @GetMapping
    public String get404view() { return "404.html";}

}
