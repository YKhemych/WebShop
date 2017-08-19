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
@DiscriminatorValue("SunGlass")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SunGlass extends Product {
    private String colorLeans;
    private String protectionLevel;
    public SunGlass(String name, int price, String maker, String size, String color, String material, String description, String type, String colorLeans, String protectionLevel, Category category){
        super(name, price, maker, size, color, material, description, type, category);
        this.colorLeans = colorLeans;
        this.protectionLevel = protectionLevel;
    }
}
