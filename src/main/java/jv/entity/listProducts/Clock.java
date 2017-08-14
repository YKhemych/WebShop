package jv.entity.listProducts;

import jv.entity.Product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by user on 07.08.2017.
 */
@Entity
@DiscriminatorValue("Clock")
public class Clock extends Product {
    private String mechanism;
    private String glass;
    private String dialType;
    private String waterResistance;
}
