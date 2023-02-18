package com.driver.repositories;

import com.driver.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
//    @Query(value = "select * from images t where t.blog_id=:id", nativeQuery = true)
//    public List<Image> getAllImage(int id);
}
