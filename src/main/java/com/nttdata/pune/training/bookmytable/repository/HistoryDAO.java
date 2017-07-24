package com.nttdata.pune.training.bookmytable.repository;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.History;

public interface HistoryDAO {
	// data access object Declaration by methods
	public int insert(History history);

	public List<History> displayAllHistory(History history);
}
