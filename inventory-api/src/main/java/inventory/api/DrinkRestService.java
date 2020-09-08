package inventory.api;

import inventory.api.dto.DrinkRequest;
import inventory.api.dto.DrinkType;
import inventory.api.dto.Outcome;

public interface DrinkRestService {

    int getDrinkCount(DrinkType drinkType);

    Outcome addDrinks(DrinkRequest drinkRequest);

    Outcome removeDrinks(DrinkRequest drinkRequest);
}

