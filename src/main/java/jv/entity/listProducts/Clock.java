package jv.entity.listProducts;

import jv.entity.Category;
import jv.entity.Product;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by user on 07.08.2017.
 */
@Entity
@DiscriminatorValue("Clock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clock extends Product {
    private String mechanism;
    private String glass;
    private String dialType;
    private String waterResistance;
    public Clock(String name, int price, String maker, String size, String color, String material, String description, String type, String mechanism, String glass, String dialType, String waterResistance, Category category){
        super(name, price, maker, size, color, material, description, type, category);
        this.mechanism = mechanism;
        this.glass = glass;
        this.dialType = dialType;
        this.waterResistance = waterResistance;
    }

}
