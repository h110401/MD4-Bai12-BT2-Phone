package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.academy.service.smart_phone.ISmartPhoneService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ISmartPhoneService smartPhoneService;

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("smartphones", smartPhoneService.findAll());
        return "/smart_phone";
    }
}
