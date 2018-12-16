package home.service;

import home.controller.ControllerUtils;
import home.domain.Information;
import home.repos.InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.Map;

@Service
public class ValidationService {

    @Autowired
    InfoRepo infoRepo;

    public void validate(Information info, Model model, BindingResult bindingResult) {

        Information nameOrgFromDb = infoRepo.findByNameOrg(info.getNameOrg());
        Information innFromDb = infoRepo.findByInn(info.getInn());
        Information ogrnFromDb = infoRepo.findByOgrn(info.getOgrn());

        boolean isInnNumeric = info.getInn().chars().allMatch(x -> Character.isDigit(x));
        boolean isOgrnNumeric = info.getOgrn().chars().allMatch(x -> Character.isDigit(x));

        if (nameOrgFromDb != null) {
            model.addAttribute("checkNameOrg", "Организация с указанным наименованием уже присутствует в БД");
            model.addAttribute("info", info);
        } else if (innFromDb != null) {
            model.addAttribute("checkInn", "Организация с указанным инн уже присутствует в БД");
            model.addAttribute("info", info);
        } else if (!isInnNumeric) {
            model.addAttribute("checkInn", "Введены недопустимые символы");
            model.addAttribute("info", info);
        } else if (ogrnFromDb != null) {
            model.addAttribute("checkOgrn", "Организация с указанным огрн уже присутствует в БД");
            model.addAttribute("info", info);
        } else if (!isOgrnNumeric) {
            model.addAttribute("checkOgrn", "Введены недопустимые символы");
            model.addAttribute("info", info);
        } else if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("info", info);
        } else {
            model.addAttribute("info", null);
            infoRepo.save(info);
        }
    }

}
