package inventory.service.rest;

import inventory.api.dto.Outcome;
import inventory.service.core.DrinkService;
import inventory.api.DrinkRestService;
import inventory.api.dto.DrinkRequest;
import inventory.api.dto.DrinkType;

public class DrinkRestServiceImpl implements DrinkRestService {

    private DrinkService drinkService;

    public DrinkRestServiceImpl(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    public int getDrinkCount(DrinkType drinkType) {
        inventory.dl.domain.DrinkType type = getDomainDrinkType(drinkType);

        return drinkService.getDrinkCount(type);
    }

    public Outcome addDrinks(DrinkRequest drinkRequest) {
        inventory.dl.domain.DrinkType type = getDomainDrinkType(drinkRequest.getDrinkType());

        drinkService.addDrinks(type, drinkRequest.getCount());

        return new Outcome(Outcome.Status.SUCCESS);
    }

    public Outcome removeDrinks(DrinkRequest drinkRequest) {
        inventory.dl.domain.DrinkType type = getDomainDrinkType(drinkRequest.getDrinkType());

        Outcome outcome = new Outcome();
        try {
            drinkService.removeDrinks(type, drinkRequest.getCount());
            outcome.setStatus(Outcome.Status.SUCCESS);
        } catch (IllegalArgumentException e) {
            outcome.setStatus(Outcome.Status.FAIL);
            outcome.setMessage(e.getMessage());
        }

        return outcome;
    }

    private inventory.dl.domain.DrinkType getDomainDrinkType(DrinkType drinkType) {
        return inventory.dl.domain.DrinkType.valueOf(drinkType.name());
    }
}
