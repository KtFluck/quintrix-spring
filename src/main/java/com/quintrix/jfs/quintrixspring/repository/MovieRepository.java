package com.quintrix.jfs.quintrixspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quintrix.jfs.quintrixspring.entity.Movies;

@Repository
public interface MovieRepository extends CrudRepository<Movies, Integer> {


}
