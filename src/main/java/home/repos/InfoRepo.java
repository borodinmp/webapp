package home.repos;

import home.domain.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InfoRepo extends JpaRepository<Information, Long> {

    List<Information> findByNameOrgLikeOrInnLikeOrOgrnLikeOrAddress(String nameOrg, String inn, String ogrn, String addressOrg);

    List<Information> findByNameOrg(String nameOrg);

    Information findAllByNameOrg(String nameOrg);

    List<Information> findByInn(String inn);

    Information findAllByInn(String inn);

    List<Information> findByOgrn(String ogrnn);

    Information findAllByOgrn(String ogrn);

    List<Information> findByAddress(String address);

}


