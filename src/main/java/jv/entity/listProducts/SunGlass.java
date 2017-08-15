package jv.entity.listProducts;

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
}
