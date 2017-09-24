package jv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Builder
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String picture;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public Photo(String picture, Product product){
        this.picture = picture;
        this.product = product;
    };

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                '}';
    }
}
