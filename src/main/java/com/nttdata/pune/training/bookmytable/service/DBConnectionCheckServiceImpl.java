package com.nttdata.pune.training.bookmytable.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DBConnectionCheckServiceImpl implements DBConnectionCheckService {

	@Override
	public boolean canConnectToDB() {
		// TODO Auto-generated method stub
		return true;
	}

}
