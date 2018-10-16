package com.tm.codemapping.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.tm.codemapping.bean.*;

@Repository
@Mapper
public interface AssetItemMapper {

    public List<AssetItem> getAll();
	
	public int update(AssetItem item);
    public int insert(AssetItem item);
	
	@Select("select * from asset_item where id=#{id}")
	public AssetItem getOneById(String id);
	
	@Select("insert into asset_item (id,name,number) values(uuid(),#{name},#{number})")
	public AssetItem insertOne(@Param("name")String name, @Param("number")String number);
}
