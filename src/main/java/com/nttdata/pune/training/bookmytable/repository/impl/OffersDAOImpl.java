package com.nttdata.pune.training.bookmytable.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nttdata.pune.training.bookmytable.model.beans.Offers;
import com.nttdata.pune.training.bookmytable.repository.OffersDAO;
import com.nttdata.pune.training.bookmytable.util.OffersRowMapper;
@Repository
public class OffersDAOImpl implements OffersDAO{
	@Autowired
	private JdbcTemplate dbTemplate;

	@Override
	public void insert(Offers offers) {
		// TODO Auto-generated method stub
		dbTemplate.update("insert into offers(hotel_id,offer_id,menu_id,discount) values(?,?,?,?)", new Object[]{offers.getHotel_id(),offers.getOffer_id(),offers.getMenu_id(),offers.getDiscount()});
		
	}

	@Override
	public void update(Offers offers) {
		// TODO Auto-generated method stub
		System.out.println(offers);
		
		dbTemplate.update("update offers set discount=? where hotel_id=? and offer_id=? and menu_id=?",new Object[]{offers.getDiscount(),offers.getHotel_id(),offers.getOffer_id(),offers.getMenu_id()});
		
	}

	@Override
	public void delete(Offers offers) {
		// TODO Auto-generated method stub.
		System.out.println("we are at DAO IMPL");
 		dbTemplate.update("delete from offers where hotel_id=? and offer_id=? and menu_id=?",new Object[]{offers.getHotel_id(),offers.getOffer_id(),offers.getMenu_id()});
	}

	@Override
	public List<Offers> getAllOffers() {
		// TODO Auto-generated method stub
		String query="select o.hotel_id as hotel_id,o.offer_id as offer_id,o.menu_id as menu_id,o.discount as discount,m.food_name as food_name,pha.hotel_name as hotel_name from offers o,perm_hotel_admin pha,menu m where pha.HOTEL_ID=o.HOTEL_ID and m.MENU_ID=o.MENU_ID and m.HOTEL_ID=o.HOTEL_ID order by offer_id * 1 asc";
		List<Offers> listOfOffers=dbTemplate.query(query,new OffersRowMapper());
		
		return listOfOffers;
	}

}
