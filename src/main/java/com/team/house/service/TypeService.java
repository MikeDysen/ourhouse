package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.util.Page;

import java.util.List;

public interface TypeService {
 PageInfo<Type> getTypeList(Page page);
 int addType(Type type);
 int updateType(Type type);
 Type getTypeBYId(Integer id);
 int deleteType(Integer id);
 int deleteTypes(List<Integer> ids);
 List<Type> getTypeList();

}
