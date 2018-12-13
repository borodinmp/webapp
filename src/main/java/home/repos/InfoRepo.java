package home.repos;

import home.domain.Information;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InfoRepo extends CrudRepository <Information, Long> {

    List<Information> findByNameOrgLikeOrInnLikeOrOgrnLikeOrAddress(String nameOrg, String inn, String ogrn, String addressOrg);

    List<Information> findByNameOrg(String nameOrg);

    List<Information> findByInn(String inn);

    List<Information> findByOgrn(String ogrnn);

    List<Information> findByAddress(String address);

}


