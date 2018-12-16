package home.repos;

import home.domain.Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepo extends JpaRepository<Information, Long> {

    List<Information> findByNameOrgContainsOrInnContainsOrOgrnContainsOrAddressContains(
            String nameOrg, String inn, String ogrn, String addressOrg);

    List<Information> findByNameOrgContains(String nameOrg);

    Information findByNameOrg(String nameOrg);

    List<Information> findByInnContains(String inn);

    Information findByInn(String inn);

    List<Information> findByOgrnContains(String ogrnn);

    Information findByOgrn(String ogrn);

    List<Information> findByAddressContains(String address);

}


