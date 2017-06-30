package jv.service;

import jv.entity.Photo;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface PhotoService {
    void save(Photo photo);
    Photo findOne(int id);
    List<Photo> findAll();
}
