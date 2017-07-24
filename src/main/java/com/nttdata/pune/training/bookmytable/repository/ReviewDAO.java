package com.nttdata.pune.training.bookmytable.repository;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.History;




public interface ReviewDAO {
	//public void insert(Reviews reviews);
	public List<History> displayAllReviews(History history);
	void update(History history);
}
