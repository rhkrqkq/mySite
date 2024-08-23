package com.example.mySite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/mysite")
    public String index() {
        return "handle";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/post/list";
    }
}
