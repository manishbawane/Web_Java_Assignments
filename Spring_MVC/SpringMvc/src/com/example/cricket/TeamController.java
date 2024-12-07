package com.example.cricket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class TeamController {

    @Autowired
    private CricketTeamService cricketTeamService;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("cricketTeam", new CricketTeam());
        return "add-team";
    }

    @PostMapping("/add")
    public String addTeam(CricketTeam cricketTeam) {
        cricketTeamService.addTeam(cricketTeam);
        return "redirect:/home";
    }

    @GetMapping("/view")
    public String showViewForm(Model model) {
        model.addAttribute("teamId", "");
        return "view-team";
    }

    @PostMapping("/view")
    public String viewTeam(String teamId, Model model) {
        CricketTeam team = cricketTeamService.getTeam(teamId);
        if (team != null) {
            model.addAttribute("team", team);
            return "team-details";
        } else {
            model.addAttribute("error", "Invalid Team ID");
            return "view-team";
        }
    }
}