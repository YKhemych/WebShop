package jv.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 29.06.2017.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Product product;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm" ,shape = JsonFormat.Shape.STRING,timezone = "Europe/Kiev")
    private Date date;

    @Column(length = 2550)
    private String comment;

    public Comment(Date date, String comment) {
        this.date = date;
        this.comment = comment;
    }

    public Comment(User user, Date date, String comment) {
        this.user = user;
        this.date = date;
        this.comment = comment;
    }

    public Comment(User user, Product product, Date date, String comment) {
        this.user = user;
        this.product = product;
        this.date = date;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                '}';
    }
}
