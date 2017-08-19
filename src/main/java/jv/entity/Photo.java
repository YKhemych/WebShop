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
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public Photo(String picture, Product product){
        this.picture = picture;
        this.product = product;
    };

}
