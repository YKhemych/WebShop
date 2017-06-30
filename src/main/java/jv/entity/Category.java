package jv.entity;

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


    public Category(String name) {
        this.name = name;
        this.idFatherCategoryes = 0;
    }
}
