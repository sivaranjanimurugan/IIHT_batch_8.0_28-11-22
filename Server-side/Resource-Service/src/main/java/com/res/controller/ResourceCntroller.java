package com.res.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.res.entity.Resource;
import com.res.services.IResourceService;

@RestController
@RequestMapping("/resource")
public class ResourceCntroller {

	@Autowired
	private IResourceService resService;

	@GetMapping("/hr/{userId}")
	public List<Resource> getResourceList(@PathVariable("userId") Long userId) {
		return resService.getResourceForUser(userId);
	}

}
