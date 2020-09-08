package inventory.dl;

import inventory.dl.domain.Drink;
import inventory.dl.domain.DrinkType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface DrinkRepository extends CrudRepository<Drink, String> {

    @Query(value = "SELECT d FROM Drink d WHERE d.drinkType = :drinkType")
    Drink findByDrinkType(@Param("drinkType") DrinkType drinkType);
}
