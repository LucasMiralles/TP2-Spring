package monprojet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import monprojet.entity.Country;
import org.springframework.data.jpa.repository.Query;
import monprojet.dto.PaysPop;
import java.util.List;


// This will be AUTO IMPLEMENTED by Spring 
//

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query (value = "SELECT SUM(population) " +
            "FROM City " +
            "WHERE country_id = :id",
            nativeQuery= true)
    public Integer getPopPays(Integer id);

    @Query(value = "SELECT Country.name as nom, SUM(population) as pop " +
            "FROM City INNER JOIN Country On Country.id = City.country_id " +
            "GROUP BY City.country_id",
            nativeQuery = true)
    public List<PaysPop> getListPopulationPays();
}
