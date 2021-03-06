package jv.entity.listProducts;

import jv.entity.Category;
import jv.entity.Product;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by user on 07.08.2017.
 */
@Entity
@NoArgsConstructor
@DiscriminatorValue("Gloves")
public class Gloves extends Product {
    public Gloves(String name, int price, String maker, String size, String color, String material, String description, String type, Category category){
        super(name, price, maker, size, color, material, description, type, category);
    }
}
