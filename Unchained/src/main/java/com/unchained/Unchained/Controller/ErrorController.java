package com.unchained.Unchained.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Author: Luca
@Controller
public class ErrorController {

    @GetMapping(path="/403")
    public String get403view(){
        return "403.html";
    }

    @GetMapping(path="/404")
    public String get404view() { return "404.html";}

}
