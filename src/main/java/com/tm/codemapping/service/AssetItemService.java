package com.tm.codemapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tm.codemapping.dao.OverviewDao;
import com.tm.codemapping.pojo.AssetItemPojo;


@Service
public class AssetItemService {

	@Autowired private OverviewDao overviewDao;
	
	@Transactional(readOnly=true)
    public List<AssetItemPojo> getAll() {

		List<AssetItemPojo> list = overviewDao.getAll();
		//List<AssetItemPojo> list=null;
        return list;
    }
	
	@Transactional(readOnly=true)
	public AssetItemPojo getItemById(String id) {
		AssetItemPojo item = overviewDao.getOneById(id);
		//AssetItemPojo item = new AssetItemPojo();
		return item;
	}
}
