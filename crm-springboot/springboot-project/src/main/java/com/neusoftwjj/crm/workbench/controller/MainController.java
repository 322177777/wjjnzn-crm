package com.neusoftwjj.crm.workbench.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/workbench/main/index.do")
    public String index(){
        return "workbench/main/index";
    }
}
