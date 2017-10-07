package jv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int idFatherCategoryes;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, fetch =FetchType.LAZY, mappedBy = "category")
    private List<Product> products;

    public Category(String name) {
        this.name = name;
        this.idFatherCategoryes = 0;
    }
}
