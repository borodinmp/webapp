package home.controller;

import home.domain.Information;
import home.repos.InfoRepo;
import home.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
    public class MainController {

    @Autowired
    FindService findService;

    @Autowired
    InfoRepo infoRepo;

    @GetMapping("/")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,
                       @RequestParam(required = false, defaultValue = "") String selectFilter,
                       Model model) {

        findService.find(filter, selectFilter);
        Iterable<Information> infos = findService.getInfo();

        model.addAttribute("infos", infos);
        model.addAttribute("filter", filter);
        model.addAttribute("selectFilter", selectFilter);

        return "main";
    }

    @PostMapping("text")
    public String add(
            Information info,
            Model model) {

        infoRepo.save(info);

        Iterable<Information> infos = infoRepo.findAll();
        model.addAttribute("infos", infos);

        return "main";
    }

}