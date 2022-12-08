package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hr.entity.HR;
import com.hr.service.IHRService;

@RestController
@RequestMapping("/hr")
public class HRController {

	@Autowired
	private IHRService hrService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public HR getHR(@PathVariable Long userId) {
		HR hr = hrService.getHR(userId);
		List resources = restTemplate.getForObject("http://RESOURCE-SERVICE/resource/hr/" + userId, List.class);
		hr.setResoures(resources);
		return hr;
	}

}
