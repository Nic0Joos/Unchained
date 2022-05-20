package com.unchained.Unchained.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Author: Lennart
@Controller
@RequestMapping(path = "/about")
public class AboutUsController {

    @GetMapping
    public String getIndexView(){
        return "about-us.html";
    }

}
