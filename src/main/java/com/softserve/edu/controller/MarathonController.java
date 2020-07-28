package com.softserve.edu.controller;


import com.softserve.edu.model.Marathon;
import com.softserve.edu.model.User;
import com.softserve.edu.service.MarathonService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@Data
public class MarathonController {
    private MarathonService marathonService;


    @Autowired
    public void setMarathonService(MarathonService marathonService) {
        this.marathonService = marathonService;
    }

    @GetMapping("/marathons")
    public String getAllMarathons(Model model) {
        List<Marathon> marathons = marathonService.getAll();
        model.addAttribute("marathons", marathons);
        return "marathons";
    }

    @GetMapping("/delete/{marathonId}")
    public String deleteMarathon(@PathVariable(name="marathonId") Long id) {
        marathonService.deleteMarathonById(id);
        return "redirect:/marathons";
    }


    @GetMapping("/addMarathon")
    public String addMarathon(Model model) {
        Marathon marathon = new Marathon();
        model.addAttribute("marathon", marathon);
        return "addMarathon";
    }

    @PostMapping("/saveMarathon")
    public String addMarathon(@ModelAttribute(name="marathon") Marathon marathon) {
        marathonService.createOrUpdate(marathon);

        return "redirect:/marathons";
    }

    @GetMapping("/users/{marathonId}")
    public String getAllUsers(Model model, @PathVariable(name="marathonId") Long id) {
        Set<User> users = marathonService.getMarathonById(id).getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    //TODO implement other needed methods
}
