package com.tm.codemapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tm.codemapping.bean.AssetItem;
import com.tm.codemapping.mapper.AssetItemMapper;


@Service
public class AssetItemService {

	@Autowired private AssetItemMapper assetItemMapper;
	
	@Transactional(readOnly=true)
    public List<AssetItem> getAll() {

		List<AssetItem> list = assetItemMapper.getAll();
		//List<AssetItemPojo> list=null;
        return list;
    }
	
	@Transactional(readOnly=true)
	public AssetItem getItemById(String id) {
		AssetItem item = assetItemMapper.getOneById(id);
		//AssetItemPojo item = new AssetItemPojo();
		return item;
	}
	
	@Transactional(readOnly=false)
	public AssetItem insertItem(String name,String number) {
		AssetItem item = assetItemMapper.insertOne(name,number);
		//AssetItemPojo item = new AssetItemPojo();
		return item;
	}
}
