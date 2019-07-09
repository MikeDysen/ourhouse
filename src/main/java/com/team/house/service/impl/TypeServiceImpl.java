package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.TypeService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public PageInfo<Type> getTypeList(Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        TypeExample typeExample = new TypeExample();
        List<Type> typeList=typeMapper.selectByExample(typeExample);
        PageInfo<Type> info=new PageInfo<Type>(typeList);
        return info;
    }

    public int addType(Type type) {
        return typeMapper.insertSelective(type);
    }

    public int updateType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    public Type getTypeBYId(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    public int deleteType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    public int deleteTypes(List<Integer> ids) {
        return typeMapper.deleteTypes(ids);
    }

    public List<Type> getTypeList() {

        return typeMapper.selectByExample(new TypeExample());
    }
}
