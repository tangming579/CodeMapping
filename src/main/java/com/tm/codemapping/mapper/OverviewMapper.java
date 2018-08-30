package com.tm.codemapping.mapper;


import java.util.List;
import com.tm.codemapping.pojo.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface OverviewMapper {

	@Select("select * from asset_item")
    public List<AssetItemPojo> getAll();
	
	public int update(AssetItemPojo item);
    public int insert(AssetItemPojo item);
	
	@Select("select * from asset_item where id=#{id}")
	public AssetItemPojo getOneById(String id);
	
	@Select("insert into asset_item (id,name,number) values(uuid(),#{name},#{number})")
	public AssetItemPojo insertOne(@Param("name")String name, @Param("number")String number);
}
