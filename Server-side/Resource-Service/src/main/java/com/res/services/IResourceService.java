package com.res.services;

import java.util.List;

import com.res.entity.Resource;

public interface IResourceService {

	public List<Resource> getResourceForUser(Long userId);

}
