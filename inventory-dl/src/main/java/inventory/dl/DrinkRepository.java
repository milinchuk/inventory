package inventory.dl;

import inventory.dl.domain.Drink;
import inventory.dl.domain.DrinkType;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface DrinkRepository extends Repository<Drink, String> {

    Drink findByDrinkType(DrinkType drinkType);

    Drink save(Drink drink);
}
