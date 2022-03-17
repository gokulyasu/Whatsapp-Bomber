package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import WhatsappDrivers.Driver;

@org.springframework.stereotype.Controller
public class Controller {
	Driver dt=new Driver();
  @GetMapping("/bomb")
  public String greetingForm(Model model) {
    model.addAttribute("greeting", new com.example.demo.Model());
    return "greeting";
  }

  @PostMapping("/bomb")
  public String greetingSubmit(@ModelAttribute com.example.demo.Model greeting, Model model) {
    model.addAttribute("greeting", greeting);
    dt.driver(greeting);
    return "result";
  }
  
  

}