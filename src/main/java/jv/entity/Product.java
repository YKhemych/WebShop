package jv.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 29.06.2017.
 */
@Inheritance
@DiscriminatorColumn
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
    private String name;
    private int price;
    private String maker;

    private String size;
    private String color;
    private String material;

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

}
