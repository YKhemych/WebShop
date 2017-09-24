package jv.dao;

import jv.entity.OrderProduct;
import jv.entity.Product;
import jv.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by user on 30.07.2017.
 */
public interface OrderProductDAO extends JpaRepository<OrderProduct, Integer> {

    @Query("from OrderProduct o left join fetch o.product where o.user = :user and o.reserved = 0")
    List<OrderProduct> selectAllWithProduct(@Param("user") User user);


    @Query("from OrderProduct op where op.user = :user and op.product = :product and op.reserved = 0" )
    OrderProduct findOneWithUserAndProduct(@Param("user") User user, @Param("product")Product product);

    @Modifying
    @Query("update OrderProduct o set o.reserved = 1 where o.id = :id")
    void setReservedTrue(@Param("id")int id);

    @Query("from OrderProduct op left join fetch op.product group by op.product order by sum(op.number) DESC")
    List<OrderProduct> findPopularOrder(Pageable pageRequest);


}
