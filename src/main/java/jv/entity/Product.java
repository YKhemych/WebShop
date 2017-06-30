package jv.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 29.06.2017.
 */
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
    private double price;
    private String maker;

    private String details;

    @OneToMany(fetch =FetchType.LAZY, mappedBy = "product")
    private List<Photo> photos;
    @OneToMany(fetch =FetchType.LAZY, mappedBy = "product")
    private List<Comment> comments;

}
