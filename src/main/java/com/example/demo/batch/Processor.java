package com.example.demo.batch;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.model.UserInfo;

@Component
public class Processor implements ItemProcessor<UserInfo, UserInfo> {

	@Override
	public UserInfo process(UserInfo UserInfo) throws Exception {
		
		UserInfo.setCreatedDate(new Date());
		
		return UserInfo;
	}

}
