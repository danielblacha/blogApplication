package pl.akademiakodu.blogApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("name", "Daniel");
        return "index";
    }
}
