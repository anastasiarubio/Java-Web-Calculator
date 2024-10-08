package com.example.calculator_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class CalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @GetMapping("/")
    public String showForm() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculateSum(@RequestParam("number1") int number1,
                               @RequestParam("number2") int number2,
                               Model model) {
        logger.info("Received number1: " + number1 + ", number2: " + number2);
        int sum = number1 + number2;
        model.addAttribute("result", sum);
        return "calculator";
    }
}