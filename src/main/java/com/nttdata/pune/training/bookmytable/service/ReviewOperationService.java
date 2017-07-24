package com.nttdata.pune.training.bookmytable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nttdata.pune.training.bookmytable.model.beans.History;


import com.nttdata.pune.training.bookmytable.repository.ReviewDAO;

@Service
public class ReviewOperationService implements ReviewOperation {
	private static final History History = null;
	@Autowired
	private ReviewDAO reviewDao;
	@Override
	public List<History> selectReviews() {
		// TODO Auto-generated method stub
		List<History> listofReviews = reviewDao.displayAllReviews(History);
		return listofReviews;
	}
	
	@Override
	public void update(History history) {
		reviewDao.update(history);
	}

}
