package com.res.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.res.entity.Resource;

@Service
public class ResourceServiceImpl implements IResourceService {

	List<Resource> resList = List.of(new Resource(1L, "peter@gmail.com", "peter", "React Dev", 1001L),
			new Resource(2L, "samuel@gmail.com", "samuel", "Java Dev", 1001L),
			new Resource(3L, "kathir@gmail.com", "kathir", "Html Dev", 1002L),
			new Resource(4L, "helan@gmail.com", "helan", "Angular Dev", 1003L),
			new Resource(5L, "kabil@gmail.com", "kabil", "Spring Dev", 1004L),
			new Resource(6L, "davyd@gmail.com", "davyd", "AWS", 1004L),
			new Resource(7L, "tamil@gmail.com", "tamil", "AWS", 1005L),
			new Resource(8L, "keny@gmail.com", "keny", "Spring Dev", 1006L));

	@Override
	public List<Resource> getResourceForUser(Long userId) {
		return resList.stream().filter(res -> res.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
