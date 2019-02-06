package com.ausecourse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ausecourse.model.Product;
import com.ausecourse.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, String> {

}
