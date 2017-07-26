package jv.dao;

import jv.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 25.06.2017.
 */

public interface CategoryDAO extends JpaRepository<Category, Integer> {
    @Modifying
    @Query("update Category c set c.name = :newName where c.id = :idCategory")
    void renameCategory(@Param("idCategory")int id,@Param("newName")String newName);

    @Modifying
    @Query("update Category c set c.idFatherCategoryes = :newIdFatherCategoryes where c.id = :idCategory")
    void changeIdFatherCategory(@Param("idCategory")int id, @Param("newIdFatherCategoryes")int newIdFatherCategoryes);

}
