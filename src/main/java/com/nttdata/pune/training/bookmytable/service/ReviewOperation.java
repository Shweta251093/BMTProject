package com.nttdata.pune.training.bookmytable.service;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.History;




public interface ReviewOperation {
	public List<History> selectReviews();
	public void update(History history);
}
