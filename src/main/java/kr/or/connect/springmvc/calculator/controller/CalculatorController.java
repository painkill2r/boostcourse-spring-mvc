package kr.or.connect.springmvc.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/plus")
    public String plusForm() {
        return "calculator/plusForm";
    }

    @PostMapping("/plus")
    public String plusResult(@RequestParam int value1,
                             @RequestParam int value2,
                             Model model) {

        model.addAttribute("value1", value1);
        model.addAttribute("value2", value2);
        model.addAttribute("result", value1 + value2);

        return "calculator/plusResult";
    }
}
