package jv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.access.method.P;

import javax.persistence.*;

/**
 * Created by user on 30.07.2017.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private boolean reserved;
    private boolean confirmed;
    private boolean delivered;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH ,fetch = FetchType.LAZY)
    private User user;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH ,fetch = FetchType.LAZY)
    private Product product;

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", number=" + number +
                ", reserved=" + reserved +
                ", confirmed=" + confirmed +
                ", delivered=" + delivered +
                '}';
    }

    public OrderProduct(int number, User user, Product product) {
        this.number = number;
        this.user = user;
        this.product = product;
    }

}
