package com.example.demo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;

@Component
public class Writer implements ItemWriter<UserInfo> {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Override
	public void write(List<? extends UserInfo> userInfo) throws Exception {
		System.out.println("Data Saved for Users: " + userInfo);
		userInfoRepository.saveAll(userInfo);
	}

	
}
