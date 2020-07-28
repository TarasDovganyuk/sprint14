package com.softserve.edu.controller;


import com.softserve.edu.model.Marathon;
import com.softserve.edu.service.MarathonService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/delete/{marathonId}")
    public String deleteMarathon(@PathVariable(name="marathonId") Long id) {
//        marathonService.deleteMarathonById(id);
        return "marathons";
    }


//    @GetMapping("/addMarathon")
//    public String addMarathon(Model model) {
//        return "addMarathon";
//    }
//
//    @PostMapping("/addMarathon")
//    public String addMarathon(@ModelAttribute(name="marathon") Marathon marathon) {
//        marathonService.createOrUpdate(marathon);
//        return "redirect:/marathons";
//    }



    //TODO implement other needed methods
}
