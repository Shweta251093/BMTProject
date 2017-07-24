package com.nttdata.pune.training.bookmytable.repository;

import java.util.List;

import com.nttdata.pune.training.bookmytable.model.beans.Offers;

public interface OffersDAO {
	public void insert(Offers offers);
	public void update(Offers offers);
	public void delete(Offers offers);
	List<Offers> getAllOffers();
	
	
}
