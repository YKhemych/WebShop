package jv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@EqualsAndHashCode
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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE ,fetch = FetchType.LAZY, mappedBy = "product")
    private List<OrderProduct> orderProduct;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH ,fetch = FetchType.LAZY)
    private Category category;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE ,fetch =FetchType.LAZY, mappedBy = "product")
    private List<Photo> photos;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE ,fetch =FetchType.LAZY, mappedBy = "product")
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

//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", maker='" + maker + '\'' +
//                ", size='" + size + '\'' +
//                ", color='" + color + '\'' +
//                ", material='" + material + '\'' +
//                ", description='" + description + '\'' +
//                ", type='" + type + '\'' +
//                ", photos=" + photos +
//                '}';
//    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", maker='" + maker + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
