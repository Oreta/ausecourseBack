package com.ausecourse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ausecourse.dao.IOrderDAO;
import com.ausecourse.dao.IReviewDAO;
import com.ausecourse.model.Review;
import com.ausecourse.model.User;
import com.ausecourse.repository.ReviewRepository;
import com.ausecourse.repository.UserRepository;

@Service
public class ReviewDaoImpl implements IReviewDAO {
	
	@Autowired 
	ReviewRepository reviewRepository ; 
	
	@Autowired
	UserRepository userRepository ; 

	@Override
	public List<Review> findAll() {
		// TODO Auto-generated method stub
		List<Review> reviews = (List<Review>) this.reviewRepository.findAll() ; 
		return reviews;
	}

	@Override
	public Review findById(String id) {
		// TODO Auto-generated method stub
		return this.reviewRepository.findById(id).get();
	}

	@Override
	public Review save(Review review) {
		// TODO Auto-generated method stub
		return this.reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReviewsByUser(String id) {
		// TODO Auto-generated method stub
		User user = this.userRepository.findById(id).get(); 
		List<Review> reviews = this.findAll() ; 
		List<Review> res = new ArrayList<Review>(); 
		for(int i=0;i<reviews.size();i++)
			if(reviews.get(i).getUser().equals(user))
				res.add(reviews.get(i)); 
		
		return res;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
	}
	
	

}
