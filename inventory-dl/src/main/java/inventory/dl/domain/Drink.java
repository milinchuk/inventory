package inventory.dl.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private DrinkType drinkType;

    @Column
    private int count;

    public Drink() {
    }

    public Drink(DrinkType drinkType, int count) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Drink drink = (Drink) o;
        return count == drink.count && Objects.equals(id, drink.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count);
    }
}
