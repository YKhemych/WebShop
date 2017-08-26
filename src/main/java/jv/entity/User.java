package jv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;

    private String name;
    private String surname;
    private String country;
    private String city;
    private String street;
    private int zipCode;
    private String phone;

//    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE ,fetch =FetchType.LAZY, mappedBy = "user")
    private List<OrderProduct> orderProducts;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.DETACH ,fetch =FetchType.LAZY, mappedBy = "user")
    private List<Comment> comments;


    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;
    private boolean accountNonExpired = true;           //не закінчився срок використання
    private boolean accountNonLocked= true;             //не заблоковано
    private boolean credentialsNonExpired = true;       //повноваження не закінчилися
    private boolean enabled = true;                     //включений

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", country='" + country + '\'' +
//                ", city='" + city + '\'' +
//                ", street='" + street + '\'' +
//                ", zipCode=" + zipCode +
//                ", phone='" + phone + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode=" + zipCode +
                ", phone='" + phone + '\'' +
                ", orderProduct=" + orderProducts +
                '}';
    }

    public User(String username, String password, String email, String name , String surname,
                String country, String city, String street, int zipCode, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public User(String username, String password, String email, String name, String surname, String country, String city, String street, int zipCode, String phone, List<OrderProduct> orderProducts) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.phone = phone;
        this.orderProducts = orderProducts;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role.name().toString()));
        return authorities;
    }


    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }


}