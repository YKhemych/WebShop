package jv.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 29.06.2017.
 */
@Inheritance
//@DiscriminatorColumn
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private String dtype;
    private String name;
    private int price;
    private String maker;

    private String size;
    private String color;
    private String material;
    @Column(length = 2550)
    private String description;
    private String type;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private OrderProduct orderProduct;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @OneToMany(fetch =FetchType.LAZY, mappedBy = "product")
    private List<Photo> photos;
    @OneToMany(fetch =FetchType.LAZY, mappedBy = "product")
    private List<Comment> comments;

    public Product(String name, int price, String maker, String size, String color, String material, String description, String type, Category category){
        this.name = name;
        this.price = price;
        this.maker = maker;
        this.size = size;
        this.color = color;
        this.material = material;
        this.description = description;
        this.type = type;
        this.category = category;
    }

}
