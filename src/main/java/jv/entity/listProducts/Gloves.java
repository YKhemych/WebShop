package jv.entity.listProducts;

import jv.entity.Product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by user on 07.08.2017.
 */
@Entity
@DiscriminatorValue("Gloves")
public class Gloves extends Product {
}