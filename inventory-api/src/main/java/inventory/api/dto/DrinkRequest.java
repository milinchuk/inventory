package inventory.api.dto;

import java.util.Objects;

public class DrinkRequest {

    private DrinkType drinkType;

    private int count;

    public DrinkRequest() {
    }

    public DrinkRequest(DrinkType drinkType, int count) {
        this.drinkType = drinkType;
        this.count = count;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DrinkRequest request = (DrinkRequest) o;
        return count == request.count && drinkType == request.drinkType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(drinkType, count);
    }
}
