package com.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hr.entity.HR;

@Service
public class IHRServiceImpl implements IHRService {

	// fake HR details
	List<HR> hrList = List.of(new HR(1001L, "Sam", "9034566789"), new HR(1002L, "Siva", "788997543"),
			new HR(1003L, "Davyd", "7376489986"), new HR(1004L, "raj", "7755754123"),
			new HR(1005L, "Nisha", "9876543566"), new HR(1005L, "ramya", "8775289750"));

	@Override
	public HR getHR(Long id) {
		return hrList.stream().filter(hr -> hr.getUserId().equals(id)).findAny().orElse(null);
	}

}
