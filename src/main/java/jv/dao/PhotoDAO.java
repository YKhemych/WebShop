package jv.dao;

import jv.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 30.06.2017.
 */
public interface PhotoDAO extends JpaRepository<Photo, Integer> {
}
