package inventory.service.core;

import inventory.dl.DrinkRepository;
import inventory.dl.domain.Drink;
import inventory.dl.domain.DrinkType;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class DrinkService {

    private DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public int getDrinkCount(DrinkType drinkType) {
        Drink drink = drinkRepository.findByDrinkType(drinkType);

        if (drink != null) {
            return drink.getCount();
        }

        return 0;
    }

    public Drink addDrinks(DrinkType drinkType, int count) {
        Drink drink = drinkRepository.findByDrinkType(drinkType);

        if (drink != null) {
            int oldCount = Optional.of(drink.getCount()).orElse(0);
            drink.setCount(oldCount + count);
            return drinkRepository.save(drink);
        }

        drink = new Drink(drinkType, count);

        return drinkRepository.save(drink);
    }

    public Drink removeDrinks(DrinkType drinkType, int countToRemove) {
        Drink drink = drinkRepository.findByDrinkType(drinkType);

        if (drink == null) {
            throw new IllegalArgumentException(String.format("Machine doesn't have %s drink type", drinkType));
        }

        int oldCount = Optional.of(drink.getCount()).orElse(0);

        if (countToRemove > oldCount) {
            throw new IllegalArgumentException("Machine has less drink than demand");
        }

        drink.setCount(oldCount - countToRemove);
        return drinkRepository.save(drink);
    }
}

