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
public class MainService {

    @Autowired
    InfoRepo infoRepo;

    public void validate(Information info, Model model, BindingResult bindingResult) {

        Information nameOrgFromDb = infoRepo.findAllByNameOrg(info.getNameOrg());
        Information innFromDb = infoRepo.findAllByInn(info.getInn());
        Information ogrnFromDb = infoRepo.findAllByOgrn(info.getOgrn());

        if (nameOrgFromDb != null) {
            model.addAttribute("checkNameOrg", "Организация с таким наименованием уже присутствует в БД");
            model.addAttribute("info", info);
        } else if (innFromDb != null) {
            model.addAttribute("checkInn", "Организация с таким инн уже присутствует в БД");
            model.addAttribute("info", info);
        } else if (ogrnFromDb != null) {
            model.addAttribute("checkOgrn", "Организация с таким огрн уже присутствует в БД");
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
