package com.lyu.saturday.service;

import com.lyu.saturday.common.exception.SaturdayServiceException;
import com.lyu.saturday.entity.Home;

import com.lyu.saturday.repository.HomeRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
	@Resource
	private HomeRepository homeRepository;


	public List<Home> getUsers() {
		return homeRepository.findAll();
	}

	public void createUser(String name) throws SaturdayServiceException {
		Home user = new Home();
		user.setUserName(name);
		homeRepository.save(user);
	}
}
