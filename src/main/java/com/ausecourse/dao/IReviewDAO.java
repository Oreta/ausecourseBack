package com.ausecourse.dao;

import java.util.List;

import com.ausecourse.model.Review;

public interface IReviewDAO {
	
	public List<Review> findAll();
	public Review findById(String id);
	public Review save(Review review);
	public List<Review> getAllReviewsByUser(String id);
	public void delete(String id);

}


