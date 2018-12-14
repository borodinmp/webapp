package home.service;

import home.domain.Information;
import home.repos.InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindService {

    private Iterable<Information> information;

    @Autowired
    private InfoRepo infoRepo;

    public Iterable find (String filter, String selectFilter) {

        if(filter != null & !filter.isEmpty() & selectFilter.equals("1")) {
            information = infoRepo.findByNameOrgLikeOrInnLikeOrOgrnLikeOrAddress(filter, filter, filter, filter);
        } else if(filter != null & !filter.isEmpty() & selectFilter.equals("2")) {
            information = infoRepo.findByNameOrg(filter);
        } else if(filter != null & !filter.isEmpty() & selectFilter.equals("3")) {
            /*information = infoRepo.findByInn(filter);*/
        } else if(filter != null & !filter.isEmpty() & selectFilter.equals("4")) {
            information = infoRepo.findByOgrn(filter);
        } else if(filter != null & !filter.isEmpty() & selectFilter.equals("5")) {
            information = infoRepo.findByAddress(filter);
        } else information = infoRepo.findAll();

        return information;
    }

    public Iterable<Information> getInfo() {
        return information;
    }

}
