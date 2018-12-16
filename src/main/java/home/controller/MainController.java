package home.controller;

import home.domain.Information;
import home.repos.InfoRepo;
import home.service.FindService;
import home.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    FindService findService;

    @Autowired
    MainService mainService;

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
            @Valid Information info,
            BindingResult bindingResult,
            Model model) {

        mainService.validate(info, model, bindingResult);

        Iterable<Information> infos = infoRepo.findAll();
        model.addAttribute("infos", infos);

        return "main";
    }

}